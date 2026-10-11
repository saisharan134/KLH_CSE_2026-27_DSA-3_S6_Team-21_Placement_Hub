package com.placementhub.dao;

import com.placementhub.model.Application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDAO {

    // In-memory application storage
    private static final List<Application> applications = new ArrayList<>();

    // Used to generate application IDs
    private static int nextApplicationId = 1;


    // =========================
    // APPLY FOR JOB
    // =========================
    public boolean applyForJob(int studentId, int jobId) {

        // Check if student already applied for this job
        for (Application application : applications) {

            if (application.getStudentId() == studentId
                    && application.getJobId() == jobId) {

                System.out.println("Already applied for this job.");

                return false;
            }
        }

        // Create new application
        Application application = new Application();

        application.setApplicationId(nextApplicationId++);
        application.setStudentId(studentId);
        application.setJobId(jobId);
        application.setApplicationDate(LocalDate.now());
        application.setStatus("Applied");

        // Store application in ArrayList
        applications.add(application);

        return true;
    }


    // =========================
    // GET STUDENT APPLICATIONS
    // =========================
    public List<Application> getStudentApplications(int studentId) {

        List<Application> result = new ArrayList<>();

        for (Application application : applications) {

            if (application.getStudentId() == studentId) {

                result.add(application);
            }
        }

        return result;
    }


    // =========================
    // VIEW STUDENT APPLICATIONS
    // =========================
    public void viewStudentApplications(int studentId) {

        System.out.println();
        System.out.println("========== MY APPLICATIONS ==========");

        boolean found = false;

        for (Application application : applications) {

            if (application.getStudentId() == studentId) {

                found = true;

                System.out.println(
                        "Application ID : "
                                + application.getApplicationId()
                );

                System.out.println(
                        "Job ID         : "
                                + application.getJobId()
                );

                System.out.println(
                        "Date           : "
                                + application.getApplicationDate()
                );

                System.out.println(
                        "Status         : "
                                + application.getStatus()
                );

                System.out.println(
                        "------------------------------------"
                );
            }
        }

        if (!found) {

            System.out.println(
                    "No applications found."
            );
        }
    }


    // =========================
    // UPDATE APPLICATION STATUS
    // =========================
    public boolean updateStatus(
            int applicationId,
            String status) {

        for (Application application : applications) {

            if (application.getApplicationId() == applicationId) {

                application.setStatus(status);

                return true;
            }
        }

        return false;
    }


    // =========================
    // GET ALL APPLICATIONS
    // =========================
    public List<Application> getAllApplications() {

        return new ArrayList<>(applications);
    }


    // =========================
    // FIND APPLICATION BY ID
    // =========================
    public Application getApplicationById(int applicationId) {

        for (Application application : applications) {

            if (application.getApplicationId() == applicationId) {

                return application;
            }
        }

        return null;
    }
}