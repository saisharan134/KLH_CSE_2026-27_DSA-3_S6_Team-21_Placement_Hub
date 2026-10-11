package com.placementhub.service;

import com.placementhub.model.Job;
import com.placementhub.model.Student;

public class EligibilityService {

    public boolean checkEligibility(
            Student student,
            Job job) {

        // CGPA check
        if (student.getCgpa() < job.getMinCgpa()) {
            return false;
        }

        // Backlog check
        if (student.getBacklogs() > job.getMaxBacklogs()) {
            return false;
        }

        // Branch check
        String allowedBranches =
                job.getAllowedBranches();

        if (allowedBranches != null &&
                !allowedBranches.isBlank() &&
                !allowedBranches.equalsIgnoreCase("ALL")) {

            boolean branchMatch = false;

            String[] branches =
                    allowedBranches.split(",");

            for (String branch : branches) {

                if (branch.trim()
                        .equalsIgnoreCase(
                                student.getBranch())) {

                    branchMatch = true;
                    break;
                }
            }

            if (!branchMatch) {
                return false;
            }
        }

        return true;
    }
}