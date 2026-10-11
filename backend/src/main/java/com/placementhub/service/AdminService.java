package com.placementhub.service;

import com.placementhub.dao.ApplicationDAO;
import com.placementhub.dao.CompanyDAO;
import com.placementhub.dao.JobDAO;
import com.placementhub.dao.StudentDAO;
import com.placementhub.model.Application;
import com.placementhub.model.Company;
import com.placementhub.model.Job;
import com.placementhub.model.Student;

public class AdminService {

    private final StudentDAO studentDAO = new StudentDAO();
    private final CompanyDAO companyDAO = new CompanyDAO();
    private final JobDAO jobDAO = new JobDAO();
    private final ApplicationDAO applicationDAO = new ApplicationDAO();

    // ================= STUDENTS =================

    public void viewStudents() {

        System.out.println();
        System.out.println("========================================");
        System.out.println("              STUDENTS");
        System.out.println("========================================");

        for (Student student : studentDAO.getAllStudents()) {

            System.out.println(
                    "ID = " + student.getStudentId()
                    + " | Name = " + student.getName()
                    + " | Email = " + student.getEmail()
                    + " | Phone = " + student.getPhone()
                    + " | Branch = " + student.getBranch()
                    + " | CGPA = " + student.getCgpa()
                    + " | Backlogs = " + student.getBacklogs()
                    + " | Skills = " + student.getSkills()
                    + " | Graduation Year = " + student.getGraduationYear()
            );
        }
    }


    // ================= COMPANIES =================

    public void viewCompanies() {

        System.out.println();
        System.out.println("========================================");
        System.out.println("              COMPANIES");
        System.out.println("========================================");

        for (Company company : companyDAO.getAllCompanies()) {

            System.out.println(
                    "ID = " + company.getCompanyId()
                    + " | Name = " + company.getCompanyName()
                    + " | Location = " + company.getLocation()
                    + " | Website = " + company.getWebsite()
                    + " | Description = " + company.getDescription()
            );
        }
    }


    // ================= JOBS =================

    public void viewJobs() {

        System.out.println();
        System.out.println("========================================");
        System.out.println("                 JOBS");
        System.out.println("========================================");

        for (Job job : jobDAO.getAllJobs()) {

            System.out.println(
                    "ID = " + job.getJobId()
                    + " | Company ID = " + job.getCompanyId()
                    + " | Role = " + job.getJobRole()
                    + " | Package = " + job.getPackageLpa() + " LPA"
                    + " | Min CGPA = " + job.getMinCgpa()
                    + " | Branches = " + job.getAllowedBranches()
                    + " | Skills = " + job.getRequiredSkills()
                    + " | Max Backlogs = " + job.getMaxBacklogs()
                    + " | Drive Date = " + job.getDriveDate()
            );
        }
    }


    // ================= APPLICATIONS =================

    public void viewApplications() {

        System.out.println();
        System.out.println("========================================");
        System.out.println("            APPLICATIONS");
        System.out.println("========================================");

        for (Application application : applicationDAO.getAllApplications()) {

            System.out.println(
                    "Application ID = " + application.getApplicationId()
                    + " | Student ID = " + application.getStudentId()
                    + " | Job ID = " + application.getJobId()
                    + " | Date = " + application.getApplicationDate()
                    + " | Status = " + application.getStatus()
            );
        }
    }


    // ================= UPDATE STATUS =================

    public boolean updateApplicationStatus(
            int applicationId,
            String status) {

        return applicationDAO.updateStatus(
                applicationId,
                status
        );
    }
}