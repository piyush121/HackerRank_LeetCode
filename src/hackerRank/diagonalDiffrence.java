package hackerRank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class diagonalDiffrence {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }
        int sum1=0;
        int sum2=0;
        for(int i=0;i<a.length;i++)
        	for(int j=0;j<a[0].length;j++)
        		{
        			if(i==j)	
        				sum1+=a[i][j];
        		}
        for(int i=0;i<a.length;i++)
        	for(int j=0;j<a[0].length;j++)
        		{
        			if(j==a[0].length-1-i)	
        				sum2+=a[i][j];
        		}
        System.out.println(Math.abs(sum2-sum1));
        
        
    }
}
