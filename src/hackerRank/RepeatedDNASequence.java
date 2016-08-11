/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to
 * identify repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that
 * occur more than once in a DNA molecule.
 * 
 * For example,
 * 
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * 
 * Return: ["AAAAACCCCC", "CCCCCAAAAA"].
 * 
 */
public class RepeatedDNASequence {
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> result = new ArrayList<String>();
		Set<String> visited = new HashSet<>(), seen = new HashSet<>(); // O(n) space.
		for (int i = 0; i <= s.length() - 10; i++) {
			String str = s.substring(i, i + 10);
			if (seen.contains(str)) {
				if (!visited.contains(str)) {
					result.add(str);
					visited.add(str);
				}
			} else
				seen.add(str);
		}

		return result;
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
