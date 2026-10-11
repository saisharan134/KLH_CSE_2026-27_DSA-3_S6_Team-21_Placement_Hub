package com.placementhub.model;

import java.time.LocalDate;

public class Application {
    private int applicationId;
    private int studentId;
    private int jobId;
    private LocalDate applicationDate;
    private String status;
    public Application() {}
    public Application(int studentId,int jobId,LocalDate applicationDate,String status){this.studentId=studentId;this.jobId=jobId;this.applicationDate=applicationDate;this.status=status;}
    public int getApplicationId(){return applicationId;} public void setApplicationId(int v){applicationId=v;}
    public int getStudentId(){return studentId;} public void setStudentId(int v){studentId=v;}
    public int getJobId(){return jobId;} public void setJobId(int v){jobId=v;}
    public LocalDate getApplicationDate(){return applicationDate;} public void setApplicationDate(LocalDate v){applicationDate=v;}
    public String getStatus(){return status;} public void setStatus(String v){status=v;}
}
