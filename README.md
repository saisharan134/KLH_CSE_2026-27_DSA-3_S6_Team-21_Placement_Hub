# Placement Hub - DSA-3 Project

## Project Overview

Placement Hub is a Java-based placement management system developed as a DSA-3 project. It helps students explore placement opportunities, search for jobs, check recommendations, and apply for jobs.

The project demonstrates practical use of Data Structures and Algorithms through job searching, fuzzy matching, sorting, pattern matching, edit distance, and recommendation techniques.

## Technology Stack

- Frontend: HTML, CSS, JavaScript
- Backend: Java 21+
- Server: Java Built-in HTTP Server
- Data Storage: Java Collections (ArrayList, HashMap)
- Database: Not used
- JDBC: Not used

## DSA Concepts Used

- ArrayList
- HashMap
- Stack
- Queue
- KMP Pattern Matching
- Rabin-Karp Algorithm
- Fuzzy Search
- Edit Distance
- Damerau-Levenshtein Distance
- Trie
- Multi-Pattern Matching
- Dynamic Programming
- Sorting
- Searching
- Job Matching and Recommendation
- Bipartite Matching
- Maximum Flow

## Main Features

### Student Features

- Student Login
- Student Registration
- View Profile
- View Companies
- View Jobs
- Search Jobs
- Fuzzy Job Search
- Job Sorting
- Job Recommendations
- Check Eligibility
- Apply for Jobs
- View Applications

### Admin Features

- View Students
- View Companies
- View Jobs
- View Applications
- Update Application Status

## Data Storage

This project does not use MySQL or any external database.

All project data is maintained in Java Collections such as `ArrayList` and objects.

Therefore:

- No MySQL installation is required.
- No JDBC connection is required.
- No SQL scripts are required.
- Data is stored in memory while the application is running.
- Data is reset when the application is restarted.

## Project Structure

```text
PlacementHubFull
│
├── backend
│   ├── pom.xml
│   └── src
│       └── main
│           └── java
│               └── com
│                   └── placementhub
│                       ├── Main.java
│                       ├── WebServer.java
│                       │
│                       ├── dao
│                       │   ├── StudentDAO.java
│                       │   ├── CompanyDAO.java
│                       │   ├── JobDAO.java
│                       │   └── ApplicationDAO.java
│                       │
│                       ├── model
│                       │   ├── Student.java
│                       │   ├── Company.java
│                       │   ├── Job.java
│                       │   └── Application.java
│                       │
│                       ├── dsa
│                       │   ├── AdvancedDSA.java
│                       │   ├── FuzzySearch.java
│                       │   ├── JobSearch.java
│                       │   ├── JobSort.java
│                       │   ├── MatchingAlgorithm.java
│                       │   ├── Search.java
│                       │   ├── Sort.java
│                       │   └── ...
│                       │
│                       └── service
│                           ├── AdminService.java
│                           └── ...
│
└── frontend
    ├── index.html
    ├── css
    └── js