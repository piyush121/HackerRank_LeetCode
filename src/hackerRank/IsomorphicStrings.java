/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Piyush Chaudhary
 *
 */
public class IsomorphicStrings {

	public boolean isIsomorphic(String s, String t) { // Fastest.
        if(s.length() == 0)
            return true;
        char[] curr = new char[256];
        char[] seen = new char[256]; // Only ASCII chars are being used .So we can do it !
        for(int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if(curr[sc] != 0 ) { 
                if( curr[sc] != tc)
                    return false;
            }
            else {
                if(seen[tc] == '1')
                    return false;
                else {
                    curr[sc] = tc;
                    seen[tc] = '1';
                }
                    
            }
                
        }
        return true;
    }
	
	public boolean isIsomorphic1(String s, String t) { // HAShMap based solution. Good one too.
        if(s.length() == 0)
            return true;
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i)) ){
                if(t.charAt(i) != map.get(s.charAt(i)))
                    return false;
            }
            else {
                if(map.containsValue(t.charAt(i)) )
                    return false;
                else
                    map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
