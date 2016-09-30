/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

/**
 * Submitted as a part of Moody's University Hackathon.
 *
 */
public class AsteriskExpression {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Stack<Character> stack = null;
		;
		for (int i = 0; i < n; i++) {
			String str = scan.next();
			char[] arr = str.toCharArray();
			if (str.indexOf("***") != -1 || arr[0] == '*' || arr[arr.length - 1] == '*') {
				System.out.println("Syntax Error");
				continue;
			}
			BigInteger prev = new BigInteger("1");
			BigInteger prevVal = new BigInteger("1");
			BigInteger curr = new BigInteger("0");
			StringBuilder strb = new StringBuilder();
			double sign = 1;
			boolean flag = true;
			for (int j = 0; j < arr.length; j++) {
				if (Character.isDigit(arr[j])) {
					strb.append(arr[j]);
				} else if (arr[j] == '*') {
					curr = new BigInteger(strb.toString());
					prev = sign == 1 ? prev.multiply(curr)
							: prevVal.modPow(curr, new BigInteger("1000000007")).multiply(prev.divide(prevVal));
					prevVal = sign == 1 ? curr : prevVal.modPow(curr, new BigInteger("1000000007"));
					strb = new StringBuilder();
					if (arr[j + 1] == '*') {
						sign = 2;
						j++;
					} else
						sign = 1;
				} else
					sign = j == 1 ? 1 : 2;
				// System.out.println(prev + " " + prevVal + " " + curr);
			}
			curr = new BigInteger(strb.toString());
			if (sign == 0)
				System.out.println(prev.multiply(new BigInteger("10").add(curr)));
			else {
				prev = sign == 1 ? prev.multiply(curr)
						: prevVal.modPow(curr, new BigInteger("1000000007")).multiply(prev.divide(prevVal));
				prev = prev.mod(BigInteger.valueOf(1000000007));
				System.out.println(prev.toString());
			}
		}

	}
}
