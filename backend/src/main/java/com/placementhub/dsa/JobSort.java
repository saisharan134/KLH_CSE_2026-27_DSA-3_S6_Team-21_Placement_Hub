package com.placementhub.dsa;
import com.placementhub.model.Job;
import java.util.*;
public class JobSort {
    public List<Job> sortByPackage(List<Job> jobs) { List<Job> x=new ArrayList<>(jobs); x.sort(Comparator.comparingDouble(Job::getPackageLpa).reversed()); return x; }
    public List<Job> sortByMinimumCgpa(List<Job> jobs) { List<Job> x=new ArrayList<>(jobs); x.sort(Comparator.comparingDouble(Job::getMinCgpa).reversed()); return x; }
}
