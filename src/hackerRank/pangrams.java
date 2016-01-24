/**
 * 
 */
package hackerRank;

/**
 * @author piyus
 *
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class pangrams {
	static HashSet<Character> myhash=new HashSet<>();

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        String str= in.nextLine();
        str = str.toLowerCase();
        for(char ch: str.toCharArray())
        	if(ch==' ')
        		continue;
        	else
        	{
        		if(!myhash.contains(ch))
        			myhash.add(ch);
        	}
        	if (myhash.size()<26)
        		System.out.println("Not Pangram");
        	else
        		System.out.println(" Pangram");

        	
    }
}
