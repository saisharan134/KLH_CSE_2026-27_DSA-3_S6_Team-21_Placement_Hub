package com.placementhub.dao;

import com.placementhub.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // In-memory storage instead of MySQL
    private static final List<Student> students = new ArrayList<>();

    // Used to generate unique student IDs
    private static int nextStudentId = 1;

    // Add some sample students when the application starts
    static {
        Student s1 = new Student(
                "Sai Sharan",
                "sai@gmail.com",
                "1234",
                "9876543210",
                "AI&ML",
                8.5,
                0,
                "Java, Python, DSA, Machine Learning",
                2027
        );
        s1.setStudentId(nextStudentId++);
        students.add(s1);

        Student s2 = new Student(
                "Rahul",
                "rahul@gmail.com",
                "1234",
                "9876543211",
                "CSE",
                8.0,
                1,
                "Java, DSA, SQL",
                2027
        );
        s2.setStudentId(nextStudentId++);
        students.add(s2);
    }


    // =========================
    // LOGIN
    // =========================
    public Student loginStudent(String email, String password) {

        for (Student student : students) {

            if (student.getEmail().equalsIgnoreCase(email)
                    && student.getPassword().equals(password)) {

                return student;
            }
        }

        return null;
    }


    // =========================
    // GET STUDENT BY EMAIL
    // =========================
    public Student getStudentByEmail(String email) {

        for (Student student : students) {

            if (student.getEmail().equalsIgnoreCase(email)) {

                return student;
            }
        }

        return null;
    }


    // =========================
    // REGISTER STUDENT
    // =========================
    public boolean registerStudent(Student student) {

        // Check whether email already exists
        for (Student existing : students) {

            if (existing.getEmail().equalsIgnoreCase(student.getEmail())) {

                return false;
            }
        }

        // Generate ID
        student.setStudentId(nextStudentId++);

        // Store student in ArrayList
        students.add(student);

        return true;
    }


    // =========================
    // GET ALL STUDENTS
    // =========================
    public List<Student> getAllStudents() {

        return new ArrayList<>(students);
    }
}