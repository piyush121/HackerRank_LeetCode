package hackerRank;

public class HalloweenParty {

	static void max_Chocolates_not_Efficient(int[] arr) {
	
		for(int i=0;i<arr.length;i++)
		{
			long length=0;
			long breadth=0;
			int j=1;
			while(j<=arr[i])
			{
				if(j%2==0)
					length++;
				else
					breadth++;
				j++;
			}
			System.out.println(length*breadth);

		}
		
	}
	static void max_Chocolates_Efficient(int[] arr) {
		
		for(int i=0;i<arr.length;i++)
		{
			long mid=arr[i]/2;
			System.out.println(mid*arr[i]-1);
		}
	}
	
}
