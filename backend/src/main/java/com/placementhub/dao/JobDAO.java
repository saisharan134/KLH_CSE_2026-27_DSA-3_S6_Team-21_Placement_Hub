package com.placementhub.dao;

import com.placementhub.model.Job;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JobDAO {

    private static final List<Job> jobs = new ArrayList<>();
    private static int nextJobId = 1;

    static {

        // ================= JOB 1 =================
        Job j1 = new Job(
                1, "Java Developer", 8.0, 7.0,
                "CSE,AI&ML,IT", "Java,DSA,SQL", 0,
                LocalDate.of(2026, 10, 15),
                "Java software development role");
        j1.setJobId(nextJobId++);
        jobs.add(j1);

        // ================= JOB 2 =================
        Job j2 = new Job(
                2, "Software Engineer", 10.0, 7.5,
                "CSE,AI&ML,IT", "Java,Python,DSA", 0,
                LocalDate.of(2026, 10, 20),
                "Software engineering and application development");
        j2.setJobId(nextJobId++);
        jobs.add(j2);

        // ================= JOB 3 =================
        Job j3 = new Job(
                3, "Machine Learning Engineer", 12.0, 8.0,
                "AI&ML,CSE,IT", "Python,Machine Learning,DSA", 1,
                LocalDate.of(2026, 10, 25),
                "Machine learning and AI development role");
        j3.setJobId(nextJobId++);
        jobs.add(j3);

        // ================= JOB 4 =================
        Job j4 = new Job(
                4, "Data Analyst", 7.5, 7.0,
                "CSE,AI&ML,IT", "Python,SQL,Excel", 1,
                LocalDate.of(2026, 11, 1),
                "Data analysis and reporting role");
        j4.setJobId(nextJobId++);
        jobs.add(j4);

        // ================= JOB 5 =================
        Job j5 = new Job(
                5, "Backend Developer", 9.0, 7.5,
                "CSE,AI&ML,IT", "Java,Spring Boot,SQL", 0,
                LocalDate.of(2026, 11, 5),
                "Backend application development role");
        j5.setJobId(nextJobId++);
        jobs.add(j5);

        // ================= JOB 6 =================
        Job j6 = new Job(
                1, "Full Stack Developer", 9.5, 7.0,
                "CSE,AI&ML,IT", "Java,JavaScript,HTML,CSS,SQL", 0,
                LocalDate.of(2026, 11, 10),
                "Full stack web application development");
        j6.setJobId(nextJobId++);
        jobs.add(j6);

        // ================= JOB 7 =================
        Job j7 = new Job(
                4, "Cloud Engineer", 11.0, 7.5,
                "CSE,AI&ML,IT", "Java,AWS,Cloud,SQL", 1,
                LocalDate.of(2026, 11, 15),
                "Cloud infrastructure and application development");
        j7.setJobId(nextJobId++);
        jobs.add(j7);

        // ================= JOB 8 =================
        Job j8 = new Job(
                5, "Data Scientist", 13.0, 8.0,
                "AI&ML,CSE", "Python,Machine Learning,Statistics,SQL", 0,
                LocalDate.of(2026, 11, 20),
                "Data science and machine learning role");
        j8.setJobId(nextJobId++);
        jobs.add(j8);

        // ================= JOB 9 =================
        Job j9 = new Job(
                2, "DevOps Engineer", 10.5, 7.5,
                "CSE,AI&ML,IT", "Linux,Docker,AWS,Jenkins", 1,
                LocalDate.of(2026, 11, 25),
                "DevOps, CI/CD and cloud automation role");
        j9.setJobId(nextJobId++);
        jobs.add(j9);

        // ================= JOB 10 =================
        Job j10 = new Job(
                3, "Frontend Developer", 8.5, 7.0,
                "CSE,AI&ML,IT", "HTML,CSS,JavaScript,React", 1,
                LocalDate.of(2026, 12, 1),
                "Frontend web development role");
        j10.setJobId(nextJobId++);
        jobs.add(j10);

        // ================= JOB 11 =================
        Job j11 = new Job(
                1, "Java Backend Engineer", 11.0, 7.5,
                "CSE,AI&ML,IT", "Java,Spring Boot,REST API,SQL", 0,
                LocalDate.of(2026, 12, 5),
                "Backend development using Java and Spring Boot");
        j11.setJobId(nextJobId++);
        jobs.add(j11);

        // ================= JOB 12 =================
        Job j12 = new Job(
                4, "AI Engineer", 14.0, 8.0,
                "AI&ML,CSE", "Python,Machine Learning,Deep Learning,TensorFlow", 0,
                LocalDate.of(2026, 12, 10),
                "Artificial intelligence and machine learning development");
        j12.setJobId(nextJobId++);
        jobs.add(j12);

        // ================= JOB 13 =================
        Job j13 = new Job(
                5, "Cyber Security Analyst", 9.5, 7.0,
                "CSE,IT", "Cyber Security,Networking,Linux,Python", 1,
                LocalDate.of(2026, 12, 15),
                "Cyber security monitoring and analysis role");
        j13.setJobId(nextJobId++);
        jobs.add(j13);

        // ================= JOB 14 =================
        Job j14 = new Job(
                2, "Cloud Developer", 12.0, 7.5,
                "CSE,AI&ML,IT", "AWS,Azure,Java,Cloud,SQL", 0,
                LocalDate.of(2026, 12, 20),
                "Cloud application development role");
        j14.setJobId(nextJobId++);
        jobs.add(j14);

        // ================= JOB 15 =================
        Job j15 = new Job(
                3, "Python Developer", 8.0, 7.0,
                "CSE,AI&ML,IT", "Python,Django,REST API,SQL", 1,
                LocalDate.of(2027, 1, 5),
                "Python application development role");
        j15.setJobId(nextJobId++);
        jobs.add(j15);

        // ================= JOB 16 =================
        Job j16 = new Job(
                4, "Data Engineer", 12.5, 7.5,
                "CSE,AI&ML,IT", "Python,SQL,ETL,Apache Spark", 0,
                LocalDate.of(2027, 1, 10),
                "Data engineering and pipeline development");
        j16.setJobId(nextJobId++);
        jobs.add(j16);

        // ================= JOB 17 =================
        Job j17 = new Job(
                5, "Mobile App Developer", 9.0, 7.0,
                "CSE,AI&ML,IT", "Java,Kotlin,Android,XML", 1,
                LocalDate.of(2027, 1, 15),
                "Android mobile application development");
        j17.setJobId(nextJobId++);
        jobs.add(j17);

        // ================= JOB 18 =================
        Job j18 = new Job(
                1, "Business Analyst", 8.5, 7.0,
                "CSE,AI&ML,IT", "SQL,Excel,Python,Communication", 1,
                LocalDate.of(2027, 1, 20),
                "Business analysis and data reporting role");
        j18.setJobId(nextJobId++);
        jobs.add(j18);

        // ================= JOB 19 =================
        Job j19 = new Job(
                2, "Machine Learning Developer", 13.5, 8.0,
                "AI&ML,CSE", "Python,Machine Learning,Scikit-learn,SQL", 0,
                LocalDate.of(2027, 1, 25),
                "Machine learning model development role");
        j19.setJobId(nextJobId++);
        jobs.add(j19);

        // ================= JOB 20 =================
        Job j20 = new Job(
                3, "Software Testing Engineer", 7.5, 6.5,
                "CSE,AI&ML,IT", "Java,Python,Selenium,Testing", 2,
                LocalDate.of(2027, 2, 1),
                "Software testing and quality assurance role");
        j20.setJobId(nextJobId++);
        jobs.add(j20);

        // ================= JOB 21 =================
        Job j21 = new Job(
                4, "UI/UX Designer", 7.5, 6.5,
                "CSE,AI&ML,IT", "Figma,UI Design,UX Design,HTML,CSS", 1,
                LocalDate.of(2027, 2, 5),
                "User interface and user experience design role");
        j21.setJobId(nextJobId++);
        jobs.add(j21);

        // ================= JOB 22 =================
        Job j22 = new Job(
                5, "Blockchain Developer", 11.5, 7.5,
                "CSE,AI&ML", "Blockchain,Java,Solidity,Web3", 0,
                LocalDate.of(2027, 2, 10),
                "Blockchain application development role");
        j22.setJobId(nextJobId++);
        jobs.add(j22);

        // ================= JOB 23 =================
        Job j23 = new Job(
                1, "Cloud Architect", 15.0, 8.0,
                "CSE,AI&ML,IT", "AWS,Azure,Cloud,Networking,Architecture", 0,
                LocalDate.of(2027, 2, 15),
                "Cloud architecture and infrastructure design role");
        j23.setJobId(nextJobId++);
        jobs.add(j23);

        // ================= JOB 24 =================
        Job j24 = new Job(
                2, "Network Engineer", 8.5, 6.5,
                "CSE,IT", "Networking,Linux,CCNA,Routing,Switching", 1,
                LocalDate.of(2027, 2, 20),
                "Computer networking and infrastructure role");
        j24.setJobId(nextJobId++);
        jobs.add(j24);

        // ================= JOB 25 =================
        Job j25 = new Job(
                3, "Database Developer", 9.5, 7.0,
                "CSE,AI&ML,IT", "SQL,MySQL,Database,Python,PLSQL", 1,
                LocalDate.of(2027, 2, 25),
                "Database development and management role");
        j25.setJobId(nextJobId++);
        jobs.add(j25);

        // ================= JOB 26 =================
        Job j26 = new Job(
                4, "NLP Engineer", 13.0, 8.0,
                "AI&ML,CSE", "Python,NLP,Machine Learning,Transformers", 0,
                LocalDate.of(2027, 3, 1),
                "Natural language processing and AI role");
        j26.setJobId(nextJobId++);
        jobs.add(j26);

        // ================= JOB 27 =================
        Job j27 = new Job(
                5, "Computer Vision Engineer", 13.5, 8.0,
                "AI&ML,CSE", "Python,OpenCV,Deep Learning,Computer Vision", 0,
                LocalDate.of(2027, 3, 5),
                "Computer vision and image processing role");
        j27.setJobId(nextJobId++);
        jobs.add(j27);

        // ================= JOB 28 =================
        Job j28 = new Job(
                1, "Embedded Systems Engineer", 9.0, 7.0,
                "CSE,AI&ML,EEE,ECE", "C,C++,Embedded Systems,Microcontrollers", 1,
                LocalDate.of(2027, 3, 10),
                "Embedded systems and firmware development role");
        j28.setJobId(nextJobId++);
        jobs.add(j28);

        // ================= JOB 29 =================
        Job j29 = new Job(
                2, "IoT Engineer", 9.5, 7.0,
                "CSE,AI&ML,ECE,EEE", "IoT,Python,ESP32,Arduino,Networking", 1,
                LocalDate.of(2027, 3, 15),
                "Internet of Things application development role");
        j29.setJobId(nextJobId++);
        jobs.add(j29);

        // ================= JOB 30 =================
        Job j30 = new Job(
                3, "Robotics Engineer", 10.5, 7.5,
                "AI&ML,CSE,ECE,EEE", "Python,C++,Robotics,ROS,Computer Vision", 1,
                LocalDate.of(2027, 3, 20),
                "Robotics and autonomous systems development role");
        j30.setJobId(nextJobId++);
        jobs.add(j30);

        // ================= JOB 31 =================
        Job j31 = new Job(
                4, "Product Manager", 12.0, 7.5,
                "CSE,AI&ML,IT", "Product Management,Agile,SQL,Communication", 1,
                LocalDate.of(2027, 3, 25),
                "Technology product management role");
        j31.setJobId(nextJobId++);
        jobs.add(j31);

        // ================= JOB 32 =================
        Job j32 = new Job(
                5, "Technical Support Engineer", 7.0, 6.5,
                "CSE,AI&ML,IT", "Networking,Linux,SQL,Communication", 2,
                LocalDate.of(2027, 4, 1),
                "Technical support and troubleshooting role");
        j32.setJobId(nextJobId++);
        jobs.add(j32);

        // ================= JOB 33 =================
        Job j33 = new Job(
                1, "QA Automation Engineer", 8.5, 7.0,
                "CSE,AI&ML,IT", "Java,Selenium,Python,Automation,Testing", 1,
                LocalDate.of(2027, 4, 5),
                "Automated software testing role");
        j33.setJobId(nextJobId++);
        jobs.add(j33);

        // ================= JOB 34 =================
        Job j34 = new Job(
                2, "DevSecOps Engineer", 12.5, 7.5,
                "CSE,AI&ML,IT", "DevOps,Security,AWS,Docker,Linux", 0,
                LocalDate.of(2027, 4, 10),
                "Development, security and operations role");
        j34.setJobId(nextJobId++);
        jobs.add(j34);

        // ================= JOB 35 =================
        Job j35 = new Job(
                3, "Site Reliability Engineer", 13.0, 7.5,
                "CSE,AI&ML,IT", "Linux,AWS,Docker,Kubernetes,Python", 0,
                LocalDate.of(2027, 4, 15),
                "System reliability and cloud operations role");
        j35.setJobId(nextJobId++);
        jobs.add(j35);

        // ================= JOB 36 =================
        Job j36 = new Job(
                4, "Data Visualization Analyst", 8.0, 7.0,
                "CSE,AI&ML,IT", "Power BI,Tableau,SQL,Python,Excel", 1,
                LocalDate.of(2027, 4, 20),
                "Data visualization and business reporting role");
        j36.setJobId(nextJobId++);
        jobs.add(j36);

        // ================= JOB 37 =================
        Job j37 = new Job(
                5, "Big Data Engineer", 13.5, 7.5,
                "CSE,AI&ML,IT", "Hadoop,Spark,Python,SQL,Big Data", 0,
                LocalDate.of(2027, 4, 25),
                "Big data processing and analytics role");
        j37.setJobId(nextJobId++);
        jobs.add(j37);

        // ================= JOB 38 =================
        Job j38 = new Job(
                1, "MLOps Engineer", 14.0, 8.0,
                "AI&ML,CSE", "Python,Machine Learning,Docker,Kubernetes,AWS", 0,
                LocalDate.of(2027, 5, 1),
                "Machine learning deployment and operations role");
        j38.setJobId(nextJobId++);
        jobs.add(j38);

        // ================= JOB 39 =================
        Job j39 = new Job(
                2, "Deep Learning Engineer", 14.5, 8.0,
                "AI&ML,CSE", "Python,Deep Learning,TensorFlow,PyTorch", 0,
                LocalDate.of(2027, 5, 5),
                "Deep learning model development role");
        j39.setJobId(nextJobId++);
        jobs.add(j39);

        // ================= JOB 40 =================
        Job j40 = new Job(
                3, "Research Engineer", 12.0, 8.0,
                "AI&ML,CSE", "Python,Research,Machine Learning,Algorithms", 0,
                LocalDate.of(2027, 5, 10),
                "Research and algorithm development role");
        j40.setJobId(nextJobId++);
        jobs.add(j40);

        // ================= JOB 41 =================
        Job j41 = new Job(
                4, "Security Engineer", 11.0, 7.5,
                "CSE,IT", "Cyber Security,Linux,Python,Networking", 0,
                LocalDate.of(2027, 5, 15),
                "Application and infrastructure security role");
        j41.setJobId(nextJobId++);
        jobs.add(j41);

        // ================= JOB 42 =================
        Job j42 = new Job(
                5, "Solutions Architect", 14.0, 8.0,
                "CSE,AI&ML,IT", "Java,Cloud,AWS,Architecture,SQL", 0,
                LocalDate.of(2027, 5, 20),
                "Technology solutions architecture role");
        j42.setJobId(nextJobId++);
        jobs.add(j42);

        // ================= JOB 43 =================
        Job j43 = new Job(
                1, "API Developer", 9.0, 7.0,
                "CSE,AI&ML,IT", "Java,REST API,Spring Boot,JSON", 1,
                LocalDate.of(2027, 5, 25),
                "REST API and backend service development role");
        j43.setJobId(nextJobId++);
        jobs.add(j43);

        // ================= JOB 44 =================
        Job j44 = new Job(
                2, "React Developer", 9.5, 7.0,
                "CSE,AI&ML,IT", "JavaScript,React,HTML,CSS,Git", 1,
                LocalDate.of(2027, 6, 1),
                "React based frontend development role");
        j44.setJobId(nextJobId++);
        jobs.add(j44);

        // ================= JOB 45 =================
        Job j45 = new Job(
                3, "Angular Developer", 9.0, 7.0,
                "CSE,AI&ML,IT", "JavaScript,Angular,TypeScript,HTML,CSS", 1,
                LocalDate.of(2027, 6, 5),
                "Angular web application development role");
        j45.setJobId(nextJobId++);
        jobs.add(j45);

        // ================= JOB 46 =================
        Job j46 = new Job(
                4, "Full Stack Java Developer", 11.5, 7.5,
                "CSE,AI&ML,IT", "Java,Spring Boot,JavaScript,React,SQL", 0,
                LocalDate.of(2027, 6, 10),
                "Full stack development using Java technologies");
        j46.setJobId(nextJobId++);
        jobs.add(j46);

        // ================= JOB 47 =================
        Job j47 = new Job(
                5, "Data Quality Analyst", 7.5, 6.5,
                "CSE,AI&ML,IT", "SQL,Python,Excel,Data Analysis", 2,
                LocalDate.of(2027, 6, 15),
                "Data quality monitoring and validation role");
        j47.setJobId(nextJobId++);
        jobs.add(j47);

        // ================= JOB 48 =================
        Job j48 = new Job(
                1, "Business Intelligence Developer", 10.5, 7.5,
                "CSE,AI&ML,IT", "SQL,Power BI,Tableau,Python", 1,
                LocalDate.of(2027, 6, 20),
                "Business intelligence and analytics development role");
        j48.setJobId(nextJobId++);
        jobs.add(j48);

        // ================= JOB 49 =================
        Job j49 = new Job(
                2, "Cloud Security Engineer", 13.0, 7.5,
                "CSE,AI&ML,IT", "AWS,Cloud Security,Linux,Networking", 0,
                LocalDate.of(2027, 6, 25),
                "Cloud security and infrastructure protection role");
        j49.setJobId(nextJobId++);
        jobs.add(j49);

        // ================= JOB 50 =================
        Job j50 = new Job(
                3, "Generative AI Engineer", 16.0, 8.0,
                "AI&ML,CSE", "Python,Generative AI,LLM,NLP,Machine Learning", 0,
                LocalDate.of(2027, 7, 1),
                "Generative AI and large language model development role");
        j50.setJobId(nextJobId++);
        jobs.add(j50);
    }


    // ================= GET ALL JOBS =================

    public List<Job> getAllJobs() {
        return new ArrayList<>(jobs);
    }


    // ================= ADD JOB =================

    public boolean addJob(Job job) {

        if (job == null) {
            return false;
        }

        job.setJobId(nextJobId++);
        jobs.add(job);

        return true;
    }


    // ================= GET JOB BY ID =================

    public Job getJobById(int jobId) {

        for (Job job : jobs) {

            if (job.getJobId() == jobId) {
                return job;
            }
        }

        return null;
    }
}