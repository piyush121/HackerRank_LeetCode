package hackerRank;

public class HalloweenParty {

	static void max_Chocolates(int[] arr) {
	
		for(int i=0;i<arr.length;i++)
		{
			int length=0;
			int breadth=0;
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
	
}
