/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function to generate the generalized abbreviations of a word.
 * 
 * Example: Given word = "word", return the following list (order does not
 * matter): ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2",
 * "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 *
 */
public class GenaralizedAbbreviation {
	public static List<String> generateAbbreviations(String word) { // Elegant Question asked at Google!
        List<String> res = new ArrayList<>();
        if(word.length() == 0 ) {
        	res.add("");
            return res;
        }
        res.add(String.valueOf(word.length()));    
        for(int i = 0; i < word.length(); i++) {
            String s = word.substring(i + 1);
            String left = i == 0 ? "" : "" + i;
            String ch = "" + word.charAt(i);
            for(String right : generateAbbreviations(s)) { // similar to string permutation.
                res.add(left + ch + right);
            }
        }
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateAbbreviations("wo"));
	}

}
