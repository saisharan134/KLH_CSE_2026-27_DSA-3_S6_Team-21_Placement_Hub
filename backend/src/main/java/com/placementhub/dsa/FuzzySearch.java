package com.placementhub.dsa;

import com.placementhub.model.Job;
import java.util.*;

public class FuzzySearch {
    public record Result(Job job, double score, String matchedField) {}

    public List<Result> search(List<Job> jobs, String keyword, double threshold) {
        List<Result> out = new ArrayList<>();
        if (keyword == null || keyword.isBlank()) return out;
        for (Job j : jobs) {
            double role = AdvancedDSA.similarity(keyword, j.getJobRole());
            double skills = bestSkillSimilarity(keyword, j.getRequiredSkills());
            double desc = AdvancedDSA.similarity(keyword, j.getJobDescription());
            double best = role; String field = "Job Role";
            if (skills > best) { best = skills; field = "Required Skills"; }
            if (desc > best) { best = desc; field = "Description"; }
            if (best >= threshold) out.add(new Result(j, best, field));
        }
        out.sort(Comparator.comparingDouble(Result::score).reversed());
        return out;
    }

    private double bestSkillSimilarity(String keyword, String skills) {
        double best = 0;
        if (skills != null) for (String s : skills.split(",")) best = Math.max(best, AdvancedDSA.similarity(keyword, s.trim()));
        return best;
    }
}
