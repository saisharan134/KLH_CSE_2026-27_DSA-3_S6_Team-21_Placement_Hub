package com.placementhub.dsa;

import java.util.*;

/** Maximum bipartite matching for students-to-jobs allocation. */
public class BipartiteMatching {
    private final List<Integer>[] graph;
    private final int[] matchJob;
    public BipartiteMatching(int students,int jobs){
        graph=new List[students];for(int i=0;i<students;i++)graph[i]=new ArrayList<>();matchJob=new int[jobs];Arrays.fill(matchJob,-1);
    }
    public void addEdge(int student,int job){if(student>=0&&student<graph.length&&job>=0&&job<matchJob.length)graph[student].add(job);}
    public int maximumMatching(){int result=0;for(int s=0;s<graph.length;s++){boolean[] seen=new boolean[matchJob.length];if(dfs(s,seen))result++;}return result;}
    private boolean dfs(int s,boolean[] seen){for(int j:graph[s])if(!seen[j]){seen[j]=true;if(matchJob[j]==-1||dfs(matchJob[j],seen)){matchJob[j]=s;return true;}}return false;}
    public int[] getJobMatches(){return matchJob.clone();}
}
