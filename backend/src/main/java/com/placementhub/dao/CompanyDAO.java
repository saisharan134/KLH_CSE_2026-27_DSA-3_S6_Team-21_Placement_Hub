package com.placementhub.dao;

import com.placementhub.model.Company;

import java.util.ArrayList;
import java.util.List;

public class CompanyDAO {

    private static final List<Company> companies = new ArrayList<>();
    private static int nextCompanyId = 1;

    static {

        // ================= COMPANY 1 =================
        Company c1 = new Company(
                "TCS",
                "Hyderabad",
                "https://www.tcs.com",
                "Tata Consultancy Services - IT services and consulting company");
        c1.setCompanyId(nextCompanyId++);
        companies.add(c1);

        // ================= COMPANY 2 =================
        Company c2 = new Company(
                "Infosys",
                "Bangalore",
                "https://www.infosys.com",
                "Global technology services and consulting company");
        c2.setCompanyId(nextCompanyId++);
        companies.add(c2);

        // ================= COMPANY 3 =================
        Company c3 = new Company(
                "Wipro",
                "Hyderabad",
                "https://www.wipro.com",
                "Information technology and business consulting company");
        c3.setCompanyId(nextCompanyId++);
        companies.add(c3);

        // ================= COMPANY 4 =================
        Company c4 = new Company(
                "Accenture",
                "Hyderabad",
                "https://www.accenture.com",
                "Technology services and consulting organization");
        c4.setCompanyId(nextCompanyId++);
        companies.add(c4);

        // ================= COMPANY 5 =================
        Company c5 = new Company(
                "Deloitte",
                "Hyderabad",
                "https://www.deloitte.com",
                "Professional services and technology consulting organization");
        c5.setCompanyId(nextCompanyId++);
        companies.add(c5);

        // ================= COMPANY 6 =================
        Company c6 = new Company(
                "Microsoft",
                "Hyderabad",
                "https://www.microsoft.com",
                "Technology company developing software, cloud and AI solutions");
        c6.setCompanyId(nextCompanyId++);
        companies.add(c6);

        // ================= COMPANY 7 =================
        Company c7 = new Company(
                "Amazon",
                "Hyderabad",
                "https://www.amazon.com",
                "Technology and e-commerce company with cloud computing services");
        c7.setCompanyId(nextCompanyId++);
        companies.add(c7);

        // ================= COMPANY 8 =================
        Company c8 = new Company(
                "Google",
                "Bangalore",
                "https://www.google.com",
                "Technology company focused on search, cloud, AI and software");
        c8.setCompanyId(nextCompanyId++);
        companies.add(c8);

        // ================= COMPANY 9 =================
        Company c9 = new Company(
                "IBM",
                "Bangalore",
                "https://www.ibm.com",
                "Technology and consulting company specializing in enterprise solutions");
        c9.setCompanyId(nextCompanyId++);
        companies.add(c9);

        // ================= COMPANY 10 =================
        Company c10 = new Company(
                "Capgemini",
                "Bangalore",
                "https://www.capgemini.com",
                "Technology services and digital transformation company");
        c10.setCompanyId(nextCompanyId++);
        companies.add(c10);

        // ================= COMPANY 11 =================
        Company c11 = new Company(
                "Cognizant",
                "Hyderabad",
                "https://www.cognizant.com",
                "IT services and digital transformation company");
        c11.setCompanyId(nextCompanyId++);
        companies.add(c11);

        // ================= COMPANY 12 =================
        Company c12 = new Company(
                "HCLTech",
                "Noida",
                "https://www.hcltech.com",
                "Global technology and IT services company");
        c12.setCompanyId(nextCompanyId++);
        companies.add(c12);

        // ================= COMPANY 13 =================
        Company c13 = new Company(
                "Tech Mahindra",
                "Hyderabad",
                "https://www.techmahindra.com",
                "Technology consulting and digital solutions company");
        c13.setCompanyId(nextCompanyId++);
        companies.add(c13);

        // ================= COMPANY 14 =================
        Company c14 = new Company(
                "Oracle",
                "Bangalore",
                "https://www.oracle.com",
                "Enterprise software, database and cloud technology company");
        c14.setCompanyId(nextCompanyId++);
        companies.add(c14);

        // ================= COMPANY 15 =================
        Company c15 = new Company(
                "SAP",
                "Bangalore",
                "https://www.sap.com",
                "Enterprise software and business technology company");
        c15.setCompanyId(nextCompanyId++);
        companies.add(c15);

        // ================= COMPANY 16 =================
        Company c16 = new Company(
                "Adobe",
                "Noida",
                "https://www.adobe.com",
                "Software company focused on digital media and creative solutions");
        c16.setCompanyId(nextCompanyId++);
        companies.add(c16);

        // ================= COMPANY 17 =================
        Company c17 = new Company(
                "Cisco",
                "Bangalore",
                "https://www.cisco.com",
                "Networking, cybersecurity and technology solutions company");
        c17.setCompanyId(nextCompanyId++);
        companies.add(c17);

        // ================= COMPANY 18 =================
        Company c18 = new Company(
                "Dell Technologies",
                "Bangalore",
                "https://www.dell.com",
                "Technology company providing hardware, cloud and IT solutions");
        c18.setCompanyId(nextCompanyId++);
        companies.add(c18);

        // ================= COMPANY 19 =================
        Company c19 = new Company(
                "Accolite Digital",
                "Bangalore",
                "https://www.accolite.com",
                "Digital engineering and technology services company");
        c19.setCompanyId(nextCompanyId++);
        companies.add(c19);

        // ================= COMPANY 20 =================
        Company c20 = new Company(
                "Persistent Systems",
                "Pune",
                "https://www.persistent.com",
                "Technology services and digital engineering company");
        c20.setCompanyId(nextCompanyId++);
        companies.add(c20);

        // ================= COMPANY 21 =================
        Company c21 = new Company(
                "Zoho",
                "Chennai",
                "https://www.zoho.com",
                "Software company developing cloud-based business applications");
        c21.setCompanyId(nextCompanyId++);
        companies.add(c21);

        // ================= COMPANY 22 =================
        Company c22 = new Company(
                "Freshworks",
                "Chennai",
                "https://www.freshworks.com",
                "Software company providing customer and employee experience solutions");
        c22.setCompanyId(nextCompanyId++);
        companies.add(c22);

        // ================= COMPANY 23 =================
        Company c23 = new Company(
                "Mphasis",
                "Bangalore",
                "https://www.mphasis.com",
                "IT services and cloud transformation company");
        c23.setCompanyId(nextCompanyId++);
        companies.add(c23);

        // ================= COMPANY 24 =================
        Company c24 = new Company(
                "LTIMindtree",
                "Bangalore",
                "https://www.ltimindtree.com",
                "Technology consulting and digital solutions company");
        c24.setCompanyId(nextCompanyId++);
        companies.add(c24);

        // ================= COMPANY 25 =================
        Company c25 = new Company(
                "Flipkart",
                "Bangalore",
                "https://www.flipkart.com",
                "Indian e-commerce and technology company");
        c25.setCompanyId(nextCompanyId++);
        companies.add(c25);
    }


    // ================= GET ALL COMPANIES =================

    public List<Company> getAllCompanies() {
        return new ArrayList<>(companies);
    }


    // ================= ADD COMPANY =================

    public boolean addCompany(Company company) {

        if (company == null) {
            return false;
        }

        company.setCompanyId(nextCompanyId++);
        companies.add(company);

        return true;
    }


    // ================= GET COMPANY BY ID =================

    public Company getCompanyById(int companyId) {

        for (Company company : companies) {

            if (company.getCompanyId() == companyId) {
                return company;
            }
        }

        return null;
    }
}