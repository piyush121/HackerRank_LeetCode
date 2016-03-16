package hackerRank;

import java.util.Stack;

public class ValidParenthesis {
	public boolean isValid(String s) { // pretty fast.
        if(s.length()==0)
            return true;
        
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++) {
            char ch=s.charAt(i);
            if(ch=='(' || ch=='[' || ch=='{')
                stack.push(ch);
            else if(stack.size()==0)
                return false;
            else if (ch == ')' && stack.pop() != '(')
                return false;
            else if (ch == ']' && stack.pop() != '[')
                return false;
            else if (ch == '}' && stack.pop() != '{')
                return false;
            
        }
        
        if(stack.size()!=0)
            return false;
        return true;
        
        
    }

}
