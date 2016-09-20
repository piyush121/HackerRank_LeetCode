/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a 
non-empty substring in str.

Examples:
pattern = "abab", str = "redblueredblue" should return true.
pattern = "aaaa", str = "asdasdasdasd" should return true.
pattern = "aabb", str = "xyzabcxzyabc" should return false.
Notes:
You may assume both pattern and str contains only lowercase letters.
 *
 */
public class WordPattern_II {
	public boolean wordPatternMatch(String pattern, String str) {
        if(pattern.length() == 0 && str.length() != 0)
            return false;
		Map<Character, String> map = new HashMap<>();
		return dfs(0, 0, pattern, str, map);
    }
	
	private boolean dfs(int curr, int start, String pattern, String str, Map<Character, String> map) {
		if(curr == pattern.length())
			return true;
		for(int i = start ; i < str.length(); i++) {
			Character ch = pattern.charAt(curr);
			if(!map.containsKey(ch)) {
			    if(map.values().contains(str.substring(start, i + 1)))
			        continue;
				map.put(ch, str.substring(start, i + 1));
				boolean res = dfs(curr + 1, i + 1, pattern, str, map);
				if(res)
					return true;
				else
					map.remove(ch);
			}
			else {
				String st = map.get(ch);
				if(find(st, str.substring(start))) {
					boolean res = dfs(curr + 1, i + st.length(), pattern, str, map);
					if(res)
						return true;
				}
			}
			
		}
		return false;
	}
	private boolean find(String needle, String hay) {
	    //System.out.println(hay);
		if(hay.length() < needle.length())
			return false;
		for(int i = 0 ; i < needle.length(); i++) {
			if(needle.charAt(i) != hay.charAt(i))
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		WordPattern_II obj = new WordPattern_II();
		System.out.println(obj.wordPatternMatch("abba", "dogcatcatdog"));
	}
}
