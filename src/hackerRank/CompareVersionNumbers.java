/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Compare two version numbers version1 and version2. If version1 > version2
 * return 1, if version1 < version2 return -1, otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits
 * and the . character. The . character does not represent a decimal point and
 * is used to separate number sequences. For instance, 2.5 is not "two and a
 * half" or "half way to version three", it is the fifth second-level revision
 * of the second first-level revision.
 * 
 * Here is an example of version numbers ordering:
 * 
 * 0.1 < 1.1 < 1.2 < 13.37
 *
 */
public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		if (version1.equals(version2))
			return 0;
		String[] str1 = version1.split("\\.");
		String[] str2 = version2.split("\\.");

		for (int i = 0; i < str1.length || i < str2.length; i++) {
			int num1 = i < str1.length ? Integer.parseInt(str1[i]) : 0; // cool nice trick to avoid so many if conditions.
			int num2 = i < str2.length ? Integer.parseInt(str2[i]) : 0;
			if (num1 > num2)
				return 1;
			if (num2 > num1)
				return -1;
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(compareVersion("1.1", "01"));

	}

}
