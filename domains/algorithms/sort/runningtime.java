import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;



/* Head ends here */
public class Solution {

static void insertionSort(int[] ar) {
              int count =0;

              for(int i=1;i<ar.length;i++){
            	  int n= ar[i];
            	  int j=i-1;
            	  while(j>=0 && ar[j]>n){
            		  //System.err.print(i+" ");
            		  ar[j+1]=ar[j]; //shift right
            		  j--;
            		  count++;
            }
        ar[j+1]= n;


		    }
              System.out.println( count);



           }

/* Tail starts here */

      public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           int n = in.nextInt();
           int[] ar = new int[n];
           for(int i=0;i<n;i++){
              ar[i]=in.nextInt();
           }
           insertionSort(ar);
       }
   }
