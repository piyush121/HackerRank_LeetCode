package hackerRank;

public class ZigZag {
	
	public static void print(String str,int rows)
	{
		boolean dir=true;
		for(int i=0;i<rows;i++)
		{	int j=i;
			while(j<str.length())
			{	if(j!=0 || j!=rows-1)
					{
						System.out.println(str.charAt(j));
						j+=2*(rows-1);
					}
			else
			{
				if(dir)	
				{
					System.out.println(str.charAt(j));
					j+=2*(rows-1 -(j+1)%4);
				}
				else
				{
					System.out.println(str.charAt(j));
					j+=2*((j+1)%4);
				}				
					
			}
				
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		print("paypalshiring",4);
	}

}
