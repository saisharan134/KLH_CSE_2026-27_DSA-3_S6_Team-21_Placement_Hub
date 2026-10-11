package com.placementhub.dsa;

import java.util.*;

public final class AdvancedDSA {
    private AdvancedDSA() {}

    public static boolean kmpSearch(String text, String pattern) {
        if (text == null || pattern == null) return false;
        text = text.toLowerCase(); pattern = pattern.toLowerCase();
        if (pattern.isEmpty()) return true;
        int[] lps = lps(pattern); int i = 0, j = 0;
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) { i++; j++; if (j == pattern.length()) return true; }
            else if (j > 0) j = lps[j - 1]; else i++;
        }
        return false;
    }

    private static int[] lps(String p) {
        int[] a = new int[p.length()];
        for (int i = 1, len = 0; i < p.length();) {
            if (p.charAt(i) == p.charAt(len)) a[i++] = ++len;
            else if (len > 0) len = a[len - 1]; else a[i++] = 0;
        }
        return a;
    }

    public static boolean rabinKarp(String text, String pattern) {
        if (text == null || pattern == null) return false;
        text = text.toLowerCase(); pattern = pattern.toLowerCase();
        int n = text.length(), m = pattern.length();
        if (m == 0) return true; if (m > n) return false;
        long mod1 = 1_000_000_007L, mod2 = 1_000_000_009L, base = 257;
        long h1 = 1, h2 = 1, ph1 = 0, ph2 = 0, th1 = 0, th2 = 0;
        for (int i=1;i<m;i++){h1=h1*base%mod1;h2=h2*base%mod2;}
        for (int i=0;i<m;i++){char pc=pattern.charAt(i),tc=text.charAt(i);ph1=(ph1*base+pc)%mod1;ph2=(ph2*base+pc)%mod2;th1=(th1*base+tc)%mod1;th2=(th2*base+tc)%mod2;}
        for (int i=0;i<=n-m;i++) {
            if(ph1==th1&&ph2==th2&&text.regionMatches(i,pattern,0,m)) return true;
            if(i<n-m){th1=(th1-text.charAt(i)*h1)%mod1;if(th1<0)th1+=mod1;th1=(th1*base+text.charAt(i+m))%mod1;th2=(th2-text.charAt(i)*h2)%mod2;if(th2<0)th2+=mod2;th2=(th2*base+text.charAt(i+m))%mod2;}
        }
        return false;
    }

    public static int editDistance(String a,String b){
        if(a==null)a=""; if(b==null)b=""; a=a.toLowerCase();b=b.toLowerCase();
        int[] prev=new int[b.length()+1], cur=new int[b.length()+1];
        for(int j=0;j<=b.length();j++)prev[j]=j;
        for(int i=1;i<=a.length();i++){cur[0]=i;for(int j=1;j<=b.length();j++){int c=a.charAt(i-1)==b.charAt(j-1)?0:1;cur[j]=Math.min(Math.min(cur[j-1]+1,prev[j]+1),prev[j-1]+c);}int[] t=prev;prev=cur;cur=t;}
        return prev[b.length()];
    }

    public static double similarity(String a,String b){
        if(a==null||b==null)return 0; if(a.equalsIgnoreCase(b))return 100;
        int max=Math.max(a.length(),b.length()); if(max==0)return 100;
        return 100.0*(1.0-(double)editDistance(a,b)/max);
    }

    public static int damerauDistance(String a,String b){
        if(a==null)a="";if(b==null)b="";a=a.toLowerCase();b=b.toLowerCase();
        int n=a.length(),m=b.length();int[][] d=new int[n+1][m+1];
        for(int i=0;i<=n;i++)d[i][0]=i;for(int j=0;j<=m;j++)d[0][j]=j;
        for(int i=1;i<=n;i++)for(int j=1;j<=m;j++){int c=a.charAt(i-1)==b.charAt(j-1)?0:1;d[i][j]=Math.min(Math.min(d[i-1][j]+1,d[i][j-1]+1),d[i-1][j-1]+c);if(i>1&&j>1&&a.charAt(i-1)==b.charAt(j-2)&&a.charAt(i-2)==b.charAt(j-1))d[i][j]=Math.min(d[i][j],d[i-2][j-2]+1);}return d[n][m];
    }

    public static int countPatterns(String text,String[] patterns){int c=0;if(patterns!=null)for(String p:patterns)if(p!=null&&kmpSearch(text,p))c++;return c;}

    public static double matchingScore(String studentSkills,String requiredSkills,double cgpa,double minCgpa){
        if(requiredSkills==null||requiredSkills.isBlank())return Math.min(cgpa*10,100);
        String[] req=requiredSkills.split(",");int matched=0;
        for(String r:req){double best=0;if(studentSkills!=null)for(String s:studentSkills.split(","))best=Math.max(best,similarity(s.trim(),r.trim()));if(best>=75)matched++;}
        double skill=100.0*matched/Math.max(1,req.length);double academic=cgpa>=minCgpa?Math.min(100,cgpa*10):0;return skill*.6+academic*.4;
    }

    public static int maxFlow(int[][] capacity,int source,int sink){
        int n=capacity.length,flow=0;int[][] r=new int[n][n];for(int i=0;i<n;i++)r[i]=capacity[i].clone();
        while(true){int[] parent=new int[n];Arrays.fill(parent,-1);boolean[] seen=new boolean[n];int[] q=new int[n];int h=0,t=0;q[t++]=source;seen[source]=true;while(h<t){int u=q[h++];for(int v=0;v<n;v++)if(!seen[v]&&r[u][v]>0){seen[v]=true;parent[v]=u;q[t++]=v;}}if(!seen[sink])break;int pf=Integer.MAX_VALUE;for(int v=sink;v!=source;v=parent[v])pf=Math.min(pf,r[parent[v]][v]);for(int v=sink;v!=source;v=parent[v]){int u=parent[v];r[u][v]-=pf;r[v][u]+=pf;}flow+=pf;}return flow;
    }

    public static boolean isPrime(long n){if(n<2)return false;if(n%2==0)return n==2;for(long i=3;i*i<=n;i+=2)if(n%i==0)return false;return true;}
}
