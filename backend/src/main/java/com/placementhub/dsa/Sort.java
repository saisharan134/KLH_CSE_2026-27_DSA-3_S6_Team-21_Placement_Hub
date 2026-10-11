package com.placementhub.dsa;
public class Sort {
 public static void bubbleSort(int[] a){for(int i=0;i<a.length-1;i++){boolean sw=false;for(int j=0;j<a.length-i-1;j++)if(a[j]>a[j+1]){int t=a[j];a[j]=a[j+1];a[j+1]=t;sw=true;}if(!sw)break;}}
 public static void selectionSort(int[] a){for(int i=0;i<a.length-1;i++){int m=i;for(int j=i+1;j<a.length;j++)if(a[j]<a[m])m=j;int t=a[i];a[i]=a[m];a[m]=t;}}
}
