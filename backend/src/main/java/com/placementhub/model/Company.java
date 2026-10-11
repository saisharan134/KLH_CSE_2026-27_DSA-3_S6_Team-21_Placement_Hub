package com.placementhub.model;

public class Company {

    private int companyId;
    private String companyName;
    private String location;
    private String website;
    private String description;

    // Default constructor
    public Company() {
    }

    // Parameterized constructor
    public Company(String companyName, String location,
                   String website, String description) {

        this.companyName = companyName;
        this.location = location;
        this.website = website;
        this.description = description;
    }

    // Getter and Setter for companyId
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    // Getter and Setter for companyName
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    // Getter and Setter for location
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Getter and Setter for website
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    // Getter and Setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", location='" + location + '\'' +
                ", website='" + website + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}