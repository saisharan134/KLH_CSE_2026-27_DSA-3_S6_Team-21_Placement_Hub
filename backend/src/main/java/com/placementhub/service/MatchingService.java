package com.placementhub.service;

import com.placementhub.dsa.MatchingAlgorithm;
import com.placementhub.model.Job;
import com.placementhub.model.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MatchingService {

    private final EligibilityService eligibilityService;
    private final MatchingAlgorithm matchingAlgorithm;

    public MatchingService() {

        eligibilityService =
                new EligibilityService();

        matchingAlgorithm =
                new MatchingAlgorithm();
    }

    public List<Job> findMatchingJobs(
            Student student,
            List<Job> jobs) {

        List<Job> result =
                new ArrayList<>();

        for (Job job : jobs) {

            if (eligibilityService.checkEligibility(
                    student,
                    job)) {

                result.add(job);
            }
        }

        result.sort(
                new Comparator<Job>() {

                    @Override
                    public int compare(
                            Job job1,
                            Job job2) {

                        double score1 =
                                matchingAlgorithm
                                .calculateOverallMatch(
                                        student,
                                        job1
                                );

                        double score2 =
                                matchingAlgorithm
                                .calculateOverallMatch(
                                        student,
                                        job2
                                );

                        return Double.compare(
                                score2,
                                score1
                        );
                    }
                }
        );

        return result;
    }

    public double getMatchScore(
            Student student,
            Job job) {

        return matchingAlgorithm
                .calculateOverallMatch(
                        student,
                        job
                );
    }
}