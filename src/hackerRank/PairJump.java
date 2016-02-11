package hackerRank;

public class PairJump {
	
	public static boolean pairCheck(int a,int b, int c , int d)
	{	boolean foundC=false;
		boolean foundD=false;
		for(int i=1;i<=Math.max(c,d);i++)
			for(int j=1;j<=Math.max(c,d);j++)
			{
				int val1=a*i+b*j;
				if(val1==c)
					foundC=true;
				else if(val1==d)
					foundD=true;
				if  (foundC && foundD)
					break;
							
			}
		return  (foundC && foundD);

	}
	
	public static void main(String[] args) {
		System.out.println(pairCheck(1,2,2,2));
	}

}
