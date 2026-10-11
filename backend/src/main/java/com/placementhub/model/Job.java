package com.placementhub.model;

import java.time.LocalDate;

public class Job {

    private int jobId;
    private int companyId;
    private String jobRole;
    private double packageLpa;
    private double minCgpa;
    private String allowedBranches;
    private String requiredSkills;
    private int maxBacklogs;
    private LocalDate driveDate;
    private String jobDescription;

    public Job() {
    }

    public Job(int companyId,
               String jobRole,
               double packageLpa,
               double minCgpa,
               String allowedBranches,
               String requiredSkills,
               int maxBacklogs,
               LocalDate driveDate,
               String jobDescription) {

        this.companyId = companyId;
        this.jobRole = jobRole;
        this.packageLpa = packageLpa;
        this.minCgpa = minCgpa;
        this.allowedBranches = allowedBranches;
        this.requiredSkills = requiredSkills;
        this.maxBacklogs = maxBacklogs;
        this.driveDate = driveDate;
        this.jobDescription = jobDescription;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public double getPackageLpa() {
        return packageLpa;
    }

    public void setPackageLpa(double packageLpa) {
        this.packageLpa = packageLpa;
    }

    public double getMinCgpa() {
        return minCgpa;
    }

    public void setMinCgpa(double minCgpa) {
        this.minCgpa = minCgpa;
    }

    public String getAllowedBranches() {
        return allowedBranches;
    }

    public void setAllowedBranches(String allowedBranches) {
        this.allowedBranches = allowedBranches;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public int getMaxBacklogs() {
        return maxBacklogs;
    }

    public void setMaxBacklogs(int maxBacklogs) {
        this.maxBacklogs = maxBacklogs;
    }

    public LocalDate getDriveDate() {
        return driveDate;
    }

    public void setDriveDate(LocalDate driveDate) {
        this.driveDate = driveDate;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", companyId=" + companyId +
                ", jobRole='" + jobRole + '\'' +
                ", packageLpa=" + packageLpa +
                ", minCgpa=" + minCgpa +
                ", allowedBranches='" + allowedBranches + '\'' +
                ", requiredSkills='" + requiredSkills + '\'' +
                ", maxBacklogs=" + maxBacklogs +
                ", driveDate=" + driveDate +
                ", jobDescription='" + jobDescription + '\'' +
                '}';
    }
}