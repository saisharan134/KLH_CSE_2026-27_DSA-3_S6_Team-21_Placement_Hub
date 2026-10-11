package com.placementhub.model;

public class Student {

    private int studentId;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String branch;
    private double cgpa;
    private int backlogs;
    private String skills;
    private int graduationYear;

    public Student() {
    }

    public Student(String name, String email, String password,
                   String phone, String branch, double cgpa,
                   int backlogs, String skills, int graduationYear) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.branch = branch;
        this.cgpa = cgpa;
        this.backlogs = backlogs;
        this.skills = skills;
        this.graduationYear = graduationYear;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public int getBacklogs() {
        return backlogs;
    }

    public void setBacklogs(int backlogs) {
        this.backlogs = backlogs;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", branch='" + branch + '\'' +
                ", cgpa=" + cgpa +
                ", backlogs=" + backlogs +
                ", skills='" + skills + '\'' +
                ", graduationYear=" + graduationYear +
                '}';
    }
}