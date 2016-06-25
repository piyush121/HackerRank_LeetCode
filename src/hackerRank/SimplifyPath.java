package hackerRank;

import java.util.ArrayDeque;

/**
 * @author Piyush Chaudhary
 *
 */
public class SimplifyPath {

	public static String simplifyPath(String path) {	 // Splitting at '/' is the
														// key
														// concept for this ques.
														// Optionally you can use Stacks
														// if you want!
		StringBuilder strb = new StringBuilder();
		ArrayDeque<String> res = new ArrayDeque<>();
		for (String str : path.split("/")) {
			if (str.equals("..")) {
				res.pollLast();
			} else if (!str.equals("") && !str.equals("."))
				res.add(str);
		}
		for (String str : res)
			strb.append("/" + str);

		if (strb.length() == 0)
			strb.append("/");
		return strb.toString();
	}

	public static void main(String[] args) {
		System.out.println(simplifyPath("/a/./b/../../c/"));
	}
}
