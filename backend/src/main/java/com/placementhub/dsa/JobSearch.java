package com.placementhub.dsa;

import com.placementhub.model.Job;
import java.util.*;

public class JobSearch {
    public List<Job> kmpSearch(List<Job> jobs, String keyword) {
        return search(jobs, keyword, true);
    }
    public List<Job> rabinKarpSearch(List<Job> jobs, String keyword) {
        return search(jobs, keyword, false);
    }
    private List<Job> search(List<Job> jobs, String keyword, boolean kmp) {
        List<Job> out = new ArrayList<>();
        for (Job j : jobs) {
            boolean ok = kmp ? AdvancedDSA.kmpSearch(j.getJobRole(), keyword) : AdvancedDSA.rabinKarp(j.getJobRole(), keyword);
            ok |= kmp ? AdvancedDSA.kmpSearch(j.getRequiredSkills(), keyword) : AdvancedDSA.rabinKarp(j.getRequiredSkills(), keyword);
            ok |= kmp ? AdvancedDSA.kmpSearch(j.getJobDescription(), keyword) : AdvancedDSA.rabinKarp(j.getJobDescription(), keyword);
            if (ok) out.add(j);
        }
        return out;
    }
}
