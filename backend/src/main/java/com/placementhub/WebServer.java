package com.placementhub;

import com.placementhub.dao.*;
import com.placementhub.dsa.*;
import com.placementhub.model.*;
import com.placementhub.service.*;
import com.sun.net.httpserver.*;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class WebServer {

    private static final int PORT = 8080;

    // DAO objects
    private final StudentDAO students = new StudentDAO();
    private final CompanyDAO companies = new CompanyDAO();
    private final JobDAO jobs = new JobDAO();
    private final ApplicationDAO applications = new ApplicationDAO();

    // DSA / service objects
    private final MatchingService matching = new MatchingService();
    private final JobSearch search = new JobSearch();
    private final FuzzySearch fuzzy = new FuzzySearch();


    // =========================
    // MAIN
    // =========================

    public static void main(String[] args) throws Exception {
        new WebServer().start();
    }


    // =========================
    // START SERVER
    // =========================

    public void start() throws Exception {

        HttpServer server =
                HttpServer.create(
                        new InetSocketAddress(PORT),
                        0
                );

        server.createContext("/api", this::api);

        server.createContext("/", this::staticFiles);

        server.setExecutor(
                java.util.concurrent.Executors.newCachedThreadPool()
        );

        server.start();

        System.out.println(
                "Placement Hub running at http://localhost:" + PORT
        );
    }


    // =========================
    // API HANDLER
    // =========================

    private void api(HttpExchange ex) throws IOException {

        try {

            String path =
                    ex.getRequestURI().getPath();

            String method =
                    ex.getRequestMethod();

            Map<String, String> q =
                    params(
                            ex.getRequestURI()
                                    .getRawQuery()
                    );

            Map<String, String> body =
                    method.equals("POST")
                            ? params(readBody(ex))
                            : Map.of();

            Map<String, String> p =
                    new HashMap<>(q);

            p.putAll(body);

            Object result;

            int status = 200;


            // =========================
            // HEALTH CHECK
            // =========================

            if (path.equals("/api/health")) {

                result = Map.of(
                        "ok",
                        true,
                        "message",
                        "Placement Hub API is running"
                );
            }


            // =========================
            // STUDENT LOGIN
            // =========================

            else if (
                    path.equals("/api/login")
                            && method.equals("POST")
            ) {

                Student s =
                        students.loginStudent(
                                p.getOrDefault(
                                        "email",
                                        ""
                                ),
                                p.getOrDefault(
                                        "password",
                                        ""
                                )
                        );

                result =
                        s == null
                                ? Map.of(
                                        "success",
                                        false,
                                        "message",
                                        "Invalid email or password"
                                )
                                : studentMap(s);

                if (s == null) {
                    status = 401;
                }
            }


            // =========================
            // STUDENT REGISTRATION
            // =========================

            else if (
                    path.equals("/api/register")
                            && method.equals("POST")
            ) {

                Student s =
                        new Student(
                                p.get("name"),
                                p.get("email"),
                                p.get("password"),
                                p.get("phone"),
                                p.get("branch"),
                                num(p.get("cgpa")),
                                (int) num(
                                        p.get("backlogs")
                                ),
                                p.get("skills"),
                                (int) num(
                                        p.get("graduationYear")
                                )
                        );

                boolean ok =
                        students.registerStudent(s);

                result =
                        Map.of(
                                "success",
                                ok,
                                "message",
                                ok
                                        ? "Registration successful"
                                        : "Registration failed"
                        );

                if (!ok) {
                    status = 400;
                }
            }


            // =========================
            // GET JOBS
            // =========================

            else if (
                    path.equals("/api/jobs")
            ) {

                result =
                        jobMaps(
                                jobs.getAllJobs()
                        );
            }


            // =========================
            // GET COMPANIES
            // =========================

            else if (
                    path.equals("/api/companies")
            ) {

                result =
                        companyMaps(
                                companies.getAllCompanies()
                        );
            }


            // =========================
            // JOB SEARCH
            // KMP / RABIN-KARP
            // =========================

            else if (
                    path.equals("/api/search")
            ) {

                String keyword =
                        p.getOrDefault(
                                "q",
                                ""
                        );

                String algorithm =
                        p.getOrDefault(
                                "algorithm",
                                "KMP"
                        );

                if (
                        algorithm.equalsIgnoreCase(
                                "RABIN-KARP"
                        )
                ) {

                    result =
                            jobMaps(
                                    search.rabinKarpSearch(
                                            jobs.getAllJobs(),
                                            keyword
                                    )
                            );

                } else {

                    result =
                            jobMaps(
                                    search.kmpSearch(
                                            jobs.getAllJobs(),
                                            keyword
                                    )
                            );
                }
            }


            // =========================
            // FUZZY SEARCH
            // =========================

            else if (
                    path.equals("/api/fuzzy")
            ) {

                double threshold = num(p.getOrDefault("threshold", "65")) / 100.0;

                List<Map<String, Object>> a =
                        new ArrayList<>();

                for (
                        FuzzySearch.Result r :
                        fuzzy.search(
                                jobs.getAllJobs(),
                                p.getOrDefault(
                                        "q",
                                        ""
                                ),
                                threshold
                        )
                ) {

                    Map<String, Object> m =
                            jobMap(
                                    r.job()
                            );

                    m.put(
                            "similarity",
                            Math.round(
                                    r.score() * 100.0
                            ) / 100.0
                    );

                    m.put(
                            "matchedField",
                            r.matchedField()
                    );

                    a.add(m);
                }

                result = a;
            }


            // =========================
            // JOB RECOMMENDATIONS
            // =========================

            else if (
                    path.equals(
                            "/api/recommendations"
                    )
            ) {

                Student s =
                        students.getStudentByEmail(
                                p.getOrDefault(
                                        "email",
                                        ""
                                )
                        );

                if (s == null) {

                    status = 404;

                    result =
                            Map.of(
                                    "success",
                                    false,
                                    "message",
                                    "Student not found"
                            );

                } else {

                    List<Map<String, Object>> a =
                            new ArrayList<>();

                    for (
                            Job j :
                            matching.findMatchingJobs(
                                    s,
                                    jobs.getAllJobs()
                            )
                    ) {

                        Map<String, Object> m =
                                jobMap(j);

                        m.put(
                                "matchScore",
                                Math.round(
                                        matching.getMatchScore(
                                                s,
                                                j
                                        ) * 100.0
                                ) / 100.0
                        );

                        a.add(m);
                    }

                    result = a;
                }
            }


            // =========================
            // APPLY FOR JOB
            // =========================

            else if (
                    path.equals("/api/apply")
                            && method.equals("POST")
            ) {

                int studentId =
                        (int) num(
                                p.get("studentId")
                        );

                int jobId =
                        (int) num(
                                p.get("jobId")
                        );

                boolean ok =
                        applications.applyForJob(
                                studentId,
                                jobId
                        );

                result =
                        Map.of(
                                "success",
                                ok,
                                "message",
                                ok
                                        ? "Application submitted"
                                        : "Already applied or failed"
                        );

                if (!ok) {
                    status = 400;
                }
            }


            // =========================
            // MY APPLICATIONS
            // =========================

            else if (
                    path.equals(
                            "/api/applications"
                    )
            ) {

                int studentId =
                        (int) num(
                                p.getOrDefault(
                                        "studentId",
                                        "0"
                                )
                        );

                result =
                        applicationMaps(
                                studentId
                        );
            }


            // =========================
            // DSA DEMO
            // =========================

            else if (
                    path.equals("/api/dsa-demo")
            ) {

                result =
                        Map.of(
                                "KMP",
                                AdvancedDSA.kmpSearch(
                                        "Java Developer",
                                        "Developer"
                                ),

                                "RabinKarp",
                                AdvancedDSA.rabinKarp(
                                        "Software Engineer",
                                        "Engineer"
                                ),

                                "EditDistance_Jvaa_Java",
                                AdvancedDSA.editDistance(
                                        "Jvaa",
                                        "Java"
                                ),

                                "Damerau_Jav_Jva",
                                AdvancedDSA.damerauDistance(
                                        "Jav",
                                        "Jva"
                                ),

                                "MaxFlow",
                                AdvancedDSA.maxFlow(
                                        new int[][]{
                                                {0, 3, 2, 0},
                                                {0, 0, 1, 2},
                                                {0, 0, 0, 3},
                                                {0, 0, 0, 0}
                                        },
                                        0,
                                        3
                                )
                        );
            }


            // =========================
            // INVALID ENDPOINT
            // =========================

            else {

                status = 404;

                result =
                        Map.of(
                                "success",
                                false,
                                "message",
                                "Endpoint not found"
                        );
            }


            sendJson(
                    ex,
                    status,
                    json(result)
            );

        } catch (Exception e) {

            e.printStackTrace();

            sendJson(
                    ex,
                    500,
                    json(
                            Map.of(
                                    "success",
                                    false,
                                    "message",
                                    e.getMessage() == null
                                            ? "Server error"
                                            : e.getMessage()
                            )
                    )
            );
        }
    }


    // =========================
    // STATIC FRONTEND FILES
    // =========================

    private void staticFiles(
            HttpExchange ex
    ) throws IOException {

        String path =
                URLDecoder.decode(
                        ex.getRequestURI()
                                .getPath(),
                        StandardCharsets.UTF_8
                );

        if (path.equals("/")) {
            path = "/index.html";
        }

        Path root =
                Paths.get(
                        "frontend"
                )
                .toAbsolutePath()
                .normalize();

        if (!Files.isDirectory(root)) {

            root =
                    Paths.get(
                            "../frontend"
                    )
                    .toAbsolutePath()
                    .normalize();
        }

        Path file =
                root.resolve(
                        path.substring(1)
                )
                .normalize();

        if (
                !file.startsWith(root)
                        || !Files.exists(file)
                        || Files.isDirectory(file)
        ) {

            sendText(
                    ex,
                    404,
                    "Not found"
            );

            return;
        }

        String type =
                Files.probeContentType(file);

        if (type == null) {

            type =
                    contentType(
                            file.getFileName()
                                    .toString()
                    );
        }

        byte[] data =
                Files.readAllBytes(file);

        ex.getResponseHeaders()
                .set(
                        "Content-Type",
                        type
                );

        ex.sendResponseHeaders(
                200,
                data.length
        );

        try (
                OutputStream o =
                        ex.getResponseBody()
        ) {

            o.write(data);
        }
    }


    // =========================
    // CONTENT TYPE
    // =========================

    private String contentType(
            String n
    ) {

        String x =
                n.toLowerCase();

        if (x.endsWith(".html")) {
            return "text/html; charset=UTF-8";
        }

        if (x.endsWith(".css")) {
            return "text/css; charset=UTF-8";
        }

        if (x.endsWith(".js")) {
            return "application/javascript; charset=UTF-8";
        }

        return "application/octet-stream";
    }


    // =========================
    // SEND TEXT
    // =========================

    private void sendText(
            HttpExchange e,
            int s,
            String t
    ) throws IOException {

        byte[] b =
                t.getBytes(
                        StandardCharsets.UTF_8
                );

        e.getResponseHeaders()
                .set(
                        "Content-Type",
                        "text/plain; charset=UTF-8"
                );

        e.sendResponseHeaders(
                s,
                b.length
        );

        try (
                OutputStream o =
                        e.getResponseBody()
        ) {

            o.write(b);
        }
    }


    // =========================
    // SEND JSON
    // =========================

    private void sendJson(
            HttpExchange e,
            int s,
            String t
    ) throws IOException {

        byte[] b =
                t.getBytes(
                        StandardCharsets.UTF_8
                );

        e.getResponseHeaders()
                .set(
                        "Content-Type",
                        "application/json; charset=UTF-8"
                );

        e.getResponseHeaders()
                .set(
                        "Access-Control-Allow-Origin",
                        "*"
                );

        e.sendResponseHeaders(
                s,
                b.length
        );

        try (
                OutputStream o =
                        e.getResponseBody()
        ) {

            o.write(b);
        }
    }


    // =========================
    // READ REQUEST BODY
    // =========================

    private String readBody(
            HttpExchange e
    ) throws IOException {

        return new String(
                e.getRequestBody()
                        .readAllBytes(),
                StandardCharsets.UTF_8
        );
    }


    // =========================
    // NUMBER PARSER
    // =========================

    private double num(
            String s
    ) {

        try {

            return Double.parseDouble(
                    s == null || s.isBlank()
                            ? "0"
                            : s
            );

        } catch (Exception e) {

            return 0;
        }
    }


    // =========================
    // REQUEST PARAMETERS
    // =========================

    private Map<String, String> params(
            String raw
    ) {

        Map<String, String> m =
                new HashMap<>();

        if (raw == null) {
            return m;
        }

        for (
                String part :
                raw.split("&")
        ) {

            int i =
                    part.indexOf('=');

            String k =
                    i < 0
                            ? part
                            : part.substring(
                                    0,
                                    i
                            );

            String v =
                    i < 0
                            ? ""
                            : part.substring(
                                    i + 1
                            );

            m.put(
                    URLDecoder.decode(
                            k,
                            StandardCharsets.UTF_8
                    ),
                    URLDecoder.decode(
                            v,
                            StandardCharsets.UTF_8
                    )
            );
        }

        return m;
    }


    // =========================
    // STUDENT → MAP
    // =========================

    private Map<String, Object> studentMap(
            Student s
    ) {

        Map<String, Object> m =
                new LinkedHashMap<>();

        m.put(
                "studentId",
                s.getStudentId()
        );

        m.put(
                "name",
                s.getName()
        );

        m.put(
                "email",
                s.getEmail()
        );

        m.put(
                "phone",
                s.getPhone()
        );

        m.put(
                "branch",
                s.getBranch()
        );

        m.put(
                "cgpa",
                s.getCgpa()
        );

        m.put(
                "backlogs",
                s.getBacklogs()
        );

        m.put(
                "skills",
                s.getSkills()
        );

        m.put(
                "graduationYear",
                s.getGraduationYear()
        );

        m.put(
                "success",
                true
        );

        return m;
    }


    // =========================
    // COMPANY → MAP
    // =========================

    private Map<String, Object> companyMap(
            Company c
    ) {

        Map<String, Object> m =
                new LinkedHashMap<>();

        m.put(
                "companyId",
                c.getCompanyId()
        );

        m.put(
                "companyName",
                c.getCompanyName()
        );

        m.put(
                "location",
                c.getLocation()
        );

        m.put(
                "website",
                c.getWebsite()
        );

        m.put(
                "description",
                c.getDescription()
        );

        return m;
    }


    // =========================
    // COMPANIES → LIST
    // =========================

    private List<Map<String, Object>> companyMaps(
            List<Company> x
    ) {

        List<Map<String, Object>> a =
                new ArrayList<>();

        for (Company c : x) {

            a.add(
                    companyMap(c)
            );
        }

        return a;
    }


    // =========================
    // JOB → MAP
    // =========================

    private Map<String, Object> jobMap(
            Job j
    ) {

        Map<String, Object> m =
                new LinkedHashMap<>();

        m.put(
                "jobId",
                j.getJobId()
        );

        m.put(
                "companyId",
                j.getCompanyId()
        );

        m.put(
                "jobRole",
                j.getJobRole()
        );

        m.put(
                "packageLpa",
                j.getPackageLpa()
        );

        m.put(
                "minCgpa",
                j.getMinCgpa()
        );

        m.put(
                "allowedBranches",
                j.getAllowedBranches()
        );

        m.put(
                "requiredSkills",
                j.getRequiredSkills()
        );

        m.put(
                "maxBacklogs",
                j.getMaxBacklogs()
        );

        m.put(
                "driveDate",
                String.valueOf(
                        j.getDriveDate()
                )
        );

        m.put(
                "jobDescription",
                j.getJobDescription()
        );

        return m;
    }


    // =========================
    // JOBS → LIST
    // =========================

    private List<Map<String, Object>> jobMaps(
            List<Job> x
    ) {

        List<Map<String, Object>> a =
                new ArrayList<>();

        for (Job j : x) {

            a.add(
                    jobMap(j)
            );
        }

        return a;
    }


    // =========================
    // APPLICATIONS → LIST
    // =========================

    private List<Map<String, Object>> applicationMaps(
            int sid
    ) {

        List<Map<String, Object>> out =
                new ArrayList<>();

        // Get applications from ArrayList
        List<Application> applicationsList =
                applications.getStudentApplications(
                        sid
                );

        for (
                Application application :
                applicationsList
        ) {

            Map<String, Object> m =
                    new LinkedHashMap<>();


            // Application ID
            m.put(
                    "applicationId",
                    application.getApplicationId()
            );


            // Job ID
            m.put(
                    "jobId",
                    application.getJobId()
            );


            // Application date
            m.put(
                    "date",
                    String.valueOf(
                            application.getApplicationDate()
                    )
            );


            // Application status
            m.put(
                    "status",
                    application.getStatus()
            );


            // Find the job
            Job job =
                    jobs.getJobById(
                            application.getJobId()
                    );

            if (job != null) {

                m.put(
                        "jobRole",
                        job.getJobRole()
                );


                // Find the company
                Company company =
                        companies.getCompanyById(
                                job.getCompanyId()
                        );

                if (company != null) {

                    m.put(
                            "companyName",
                            company.getCompanyName()
                    );

                } else {

                    m.put(
                            "companyName",
                            "Unknown Company"
                    );
                }

            } else {

                m.put(
                        "jobRole",
                        "Unknown Job"
                );

                m.put(
                        "companyName",
                        "Unknown Company"
                );
            }

            out.add(m);
        }

        return out;
    }


    // =========================
    // JSON CONVERTER
    // =========================

    private String json(
            Object o
    ) {

        if (o == null) {
            return "null";
        }

        if (
                o instanceof String
                        || o instanceof Character
        ) {

            return quote(
                    String.valueOf(o)
            );
        }

        if (
                o instanceof Number
                        || o instanceof Boolean
        ) {

            return String.valueOf(o);
        }

        if (
                o instanceof Map<?, ?> m
        ) {

            StringBuilder b =
                    new StringBuilder("{");

            boolean first = true;

            for (
                    var en :
                    m.entrySet()
            ) {

                if (!first) {
                    b.append(',');
                }

                first = false;

                b.append(
                        quote(
                                String.valueOf(
                                        en.getKey()
                                )
                        )
                );

                b.append(':');

                b.append(
                        json(
                                en.getValue()
                        )
                );
            }

            return b.append('}')
                    .toString();
        }

        if (
                o instanceof Iterable<?> it
        ) {

            StringBuilder b =
                    new StringBuilder("[");

            boolean first = true;

            for (
                    Object x :
                    it
            ) {

                if (!first) {
                    b.append(',');
                }

                first = false;

                b.append(
                        json(x)
                );
            }

            return b.append(']')
                    .toString();
        }

        return quote(
                String.valueOf(o)
        );
    }


    // =========================
    // JSON STRING ESCAPING
    // =========================

    private String quote(
            String s
    ) {

        return "\""
                + s.replace(
                        "\\",
                        "\\\\"
                )
                .replace(
                        "\"",
                        "\\\""
                )
                .replace(
                        "\r",
                        "\\r"
                )
                .replace(
                        "\n",
                        "\\n"
                )
                .replace(
                        "\t",
                        "\\t"
                )
                + "\"";
    }
}