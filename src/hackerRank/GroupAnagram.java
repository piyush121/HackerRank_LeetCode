package hackerRank;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.
 */

/**
 * @author Piyush Chaudhary
 *
 */
public class GroupAnagram {
	
public List<List<String>> groupAnagrams(String[] strs) {
	HashMap<String, List<String>> map = new HashMap<>();
	
	for (String str : strs) {
		char[] str1 = str.toCharArray();
		Arrays.sort(str1);
		if(!map.containsKey(String.valueOf(str1)))
			map.put(String.valueOf(str1), new LinkedList<>());
		map.get(String.valueOf(str1)).add(str);
			
		
	}
	return new LinkedList<>(map.values());
	
    }

}
