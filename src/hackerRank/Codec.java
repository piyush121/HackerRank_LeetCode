/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}
Machine 2 (receiver) has the function:
vector<string> decode(string s) {
  //... your code
  return strs;
}
So Machine 1 does:

string encoded_string = encode(strs);
and Machine 2 does:

vector<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.

Note:
The string may contain any possible characters out of 256 valid ascii characters. Your algorithm 
should be generalized enough to work on any possible characters.
Do not use class member/global/static variables to store states. Your encode and decode algorithms 
should be stateless.
Do not rely on any library method such as eval or serialize methods. You should implement your own 
encode/decode algorithm.
 *
 */
public class Codec {

	// Encodes a list of strings to a single string.
	public String encode(List<String> strs) {
		StringBuilder strb = new StringBuilder();
		for (String str : strs) {
			strb.append(str.replace("/", "//") + " / ");
		}
		return strb.toString();
	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String s) {
		List<String> res = new ArrayList<>();
		int i = s.indexOf(" / ");
		while (i != -1) {
			res.add(s.substring(0, i).replace("//", "/"));
			s = s.substring(i + 3);
			i = s.indexOf(" / ");
		}
		return res;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));