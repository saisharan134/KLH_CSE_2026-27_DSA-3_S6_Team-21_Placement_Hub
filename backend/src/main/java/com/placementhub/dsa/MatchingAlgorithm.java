package com.placementhub.dsa;
import com.placementhub.model.*;
import java.util.*;
public class MatchingAlgorithm {
    public double calculateSkillMatch(Student s, Job j) {
        if(s==null||j==null||s.getSkills()==null||j.getRequiredSkills()==null)return 0;
        Map<String,Boolean> have=new HashMap<>(); for(String x:s.getSkills().split(","))have.put(x.trim().toLowerCase(),true);
        int hit=0,total=0; for(String x:j.getRequiredSkills().split(",")){total++;if(have.containsKey(x.trim().toLowerCase()))hit++;}
        return total==0?0:100.0*hit/total;
    }
    public double calculateOverallMatch(Student s, Job j) {
        return AdvancedDSA.matchingScore(s.getSkills(),j.getRequiredSkills(),s.getCgpa(),j.getMinCgpa());
    }
}
