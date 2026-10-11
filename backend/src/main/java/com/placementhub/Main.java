package com.placementhub;

import com.placementhub.dsa.AdvancedDSA;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("========================================");
        System.out.println("       PLACEMENT HUB - DSA 3");
        System.out.println("========================================");
        System.out.println("KMP: " + AdvancedDSA.kmpSearch("Java Developer", "Developer"));
        System.out.println("Rabin-Karp: " + AdvancedDSA.rabinKarp("Software Engineer", "Engineer"));
        System.out.println("Edit Distance (Jvaa -> Java): " + AdvancedDSA.editDistance("Jvaa", "Java"));
        System.out.println("Starting web application...");
        new WebServer().start();
    }
}
