package hackerRank;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author Piyush Chaudhary
 *
 */
public class ColumnName {
	
	public static int colIndex(String col)
	{	int index=0;
		int mul=0;
		for(int i=col.length()-1;i>=0;i--)
		{	
			index  += (col.charAt(i)-64) * Math.pow(26, mul);
			mul++;
		}
		return index;
	}
	
	public static void main(String[] args) {
		
		System.out.println(colIndex("AAA"));
		HashSet<String> myhash=new HashSet<>();
		
		
	}

}
