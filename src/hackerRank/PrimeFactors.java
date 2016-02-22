package hackerRank;

public class PrimeFactors {
	
	public static void primeFactors(int num)
	
	{
		if(num%2==0)
			System.out.println(2);
		while(num%2==0)
			num=num/2;
		for(int i=3;i<=Math.sqrt(num);i=i+2)
		{
			if(num%i==0)
				System.out.println(i);
				
			while(num%i==0)
				num/=i;
		}
		if(num>2)
			System.out.println(num);
		
	}
	
	public static void main(String[] args) {
		primeFactors(39);
	}

}
