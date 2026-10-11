package com.placementhub.dsa;

import java.util.*;

/** Multiple-pattern string matching using a trie + failure links. */
public class AhoCorasick {
    private static class Node {
        Map<Character,Integer> next = new HashMap<>();
        int fail;
        List<String> out = new ArrayList<>();
    }
    private final List<Node> nodes = new ArrayList<>();
    public AhoCorasick(){ nodes.add(new Node()); }
    public void addPattern(String pattern){
        if(pattern==null||pattern.isBlank())return;
        int cur=0; String p=pattern.toLowerCase();
        for(char c:p.toCharArray()) cur=nodes.get(cur).next.computeIfAbsent(c,k->{nodes.add(new Node());return nodes.size()-1;});
        nodes.get(cur).out.add(pattern);
    }
    public void build(){
        ArrayDeque<Integer> q=new ArrayDeque<>();
        for(int child:nodes.get(0).next.values()){nodes.get(child).fail=0;q.add(child);}
        while(!q.isEmpty()){
            int u=q.remove();
            for(var e:nodes.get(u).next.entrySet()){
                char c=e.getKey(); int v=e.getValue(); q.add(v); int f=nodes.get(u).fail;
                while(f!=0&&!nodes.get(f).next.containsKey(c))f=nodes.get(f).fail;
                if(nodes.get(f).next.containsKey(c)&&nodes.get(f).next.get(c)!=v)f=nodes.get(f).next.get(c);
                nodes.get(v).fail=f; nodes.get(v).out.addAll(nodes.get(f).out);
            }
        }
    }
    public Set<String> findMatches(String text){
        Set<String> found=new LinkedHashSet<>(); if(text==null)return found;
        int cur=0; for(char raw:text.toLowerCase().toCharArray()){
            while(cur!=0&&!nodes.get(cur).next.containsKey(raw))cur=nodes.get(cur).fail;
            if(nodes.get(cur).next.containsKey(raw))cur=nodes.get(cur).next.get(raw); else cur=0;
            found.addAll(nodes.get(cur).out);
        } return found;
    }
}
