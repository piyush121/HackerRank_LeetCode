package hackerRank;

import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

import javax.print.attribute.HashAttributeSet;

public class LongestPalindromicSubsequence {
	
	public static int maxLength(String str)
	{
		int[][] DP=new int[str.length()+1][str.length()+1];
		StringBuilder strb=new StringBuilder();
		TreeMap<Integer,Integer> parent=new TreeMap<>(Collections.reverseOrder());
				
		for(int i=0;i<=str.length();i++)
			DP[i][i]=1;
		
		for(int j=2;j<=str.length();j++)
			for(int i=j-1;i>0;i--)
			{
			
				if(str.charAt(i-1)!=str.charAt(j-1))
					{
						DP[i][j]=Math.max(DP[i+1][j], DP[i][j-1]);
						
					}
				else if(str.charAt(i-1)==str.charAt(j-1) && j==2)
					DP[i][j]=2;
				else
					{
						DP[i][j]=DP[i+1][j-1]+2;
						parent.put(j-1,j-2);
					}

				
			}
		System.out.println(parent);
			Integer key=parent.firstKey();
			while(parent.containsKey(key)==true)
			{
				strb.append(str.charAt(key));
				key=parent.get(key);
			}
			for(int i=strb.length()-1;i>=0;i--)
				strb.append(strb.charAt(i));
			System.out.println(strb.toString());

		for(int i=0;i<=str.length();i++)
			{
			for(int j=0;j<=str.length();j++)
				System.out.print(DP[i][j]);
			System.out.println();
			}
		return DP[1][DP.length-1];

		
	}
	public static void main(String[] args) {
		System.out.println(maxLength("abba"));
	}

}
