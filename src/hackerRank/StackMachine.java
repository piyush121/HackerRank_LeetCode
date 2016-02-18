package hackerRank;

import java.util.Stack;


public class StackMachine {  // Codility test
	
	 public static int solution(String S) {
	        // write your code in Java SE 8
	        Stack<Integer> stack = new Stack<Integer>();
	        
	        for(int i=0;i<S.length();i++)
	        {
	            if(S.charAt(i) != '+' && S.charAt(i) != '*')
	                stack.push((S.charAt(i) -'0'));
	            
	            else if(stack.size()>1)
	                {
	                    if( S.charAt(i) == '+')
	                        {
	                            int x=stack.pop();
	                            int y=stack.pop();
	                            if(x+y<4096)
	                            	stack.push(x+y);
	                            else
	                            	return -1;
	                        }
	                    else if( S.charAt(i) == '*')
	                        {
	                            int x=stack.pop();
	                            int y=stack.pop();
	                            if(x*y<4096)
	                            	stack.push(x*y);
	                            else
	                            	return -1;
	                        }
	                }
	             else
	                return -1;
	                
	        }
	        
	        if(stack.size()>0)
	            return stack.pop();
	        else
	        return -1;
	    }
	 public static void main(String[] args) {
			System.out.println(solution("13+62*7+*"));
			System.out.println(solution("11++"));
			System.out.println(solution("8"));
	}

}
