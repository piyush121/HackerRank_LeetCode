package hackerRank;

import java.util.Scanner;

public class inssort {
	    

	public static void insertIntoSorted(int[] ar) {
        // Fill up this function  
        int tmp=ar[ar.length-1];
        int i=0;
        for( i=ar.length-2;i>0;i--)
            {
            if(ar[i]>=tmp)
                {
                ar[i+1]=ar[i];
                  for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
            }
            else
                break;
             }
        	ar[i+1]=ar[i];
            ar[i]=tmp;
              for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");

    }
    
    
/* Tail starts here */
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
         for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
         }
         insertIntoSorted(ar);
    }
    
    
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }

}
