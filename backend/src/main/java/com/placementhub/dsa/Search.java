package com.placementhub.dsa;
public class Search {
 public static int linearSearch(int[] a,int target){for(int i=0;i<a.length;i++)if(a[i]==target)return i;return -1;}
 public static int binarySearch(int[] a,int target){int l=0,r=a.length-1;while(l<=r){int m=(l+r)>>>1;if(a[m]==target)return m;if(a[m]<target)l=m+1;else r=m-1;}return -1;}
}
