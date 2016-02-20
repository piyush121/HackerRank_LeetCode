package hackerRank;

public class ZigZag {
	
	public static void print(String str,int rows)
	{
		boolean dir=true;
		for(int i=0;i<rows;i++)
		{	int j=i;
			while(j<str.length())
			{	
			if(j%(rows-1)==0)
					{
						System.out.print(str.charAt(j));
						j+=2*(rows-1);
					}
			else
			{
				if(dir)	
				{
					System.out.print(str.charAt(j));
					j+=2*(rows-1 -(j)%4);
					dir=!dir;
				}
				else
				{
					System.out.print(str.charAt(j));
					j+=2*((j)%4);
					dir=!dir;
				}				
					
			}
				
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		print("paypalishiring",4);
	}

}
