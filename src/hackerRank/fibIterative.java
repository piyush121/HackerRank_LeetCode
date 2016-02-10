package hackerRank;

public class fibIterative {
	
	public static int fib(int n)		//O(1) space and O(n) time. Cool !
	{
		if(n==1||n==2)
			return 1;
		int prev=1;
		int prevprev=1;
		int current=2;
		for(int i=3;i<=n;i++)
		{
			
			current=prev+prevprev;
			prevprev=prev;
			prev=current;
		}
		
		return current;
	}
	
	public static void main(String[] args) {
		System.out.println(fib(6));
	}

}
