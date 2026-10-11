package com.placementhub.dsa;
import com.placementhub.model.Application;
public class ApplicationList {
 private Node head;
 private static class Node{Application data;Node next;Node(Application d){data=d;}}
 public void add(Application a){Node n=new Node(a);if(head==null){head=n;return;}Node c=head;while(c.next!=null)c=c.next;c.next=n;}
 public int size(){int n=0;for(Node c=head;c!=null;c=c.next)n++;return n;}
}
