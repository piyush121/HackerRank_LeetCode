package hackerRank;

public class NumToWord { //Really a tedious problem.
	String[] ones={"","one","two","three","four","five","six","seven","eight","nine"};
	String[] teens={"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
	String[] tens={"ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
	String[] bigs={"","thousand","million"};
	
	public String realWord(int num)
	{
		String str="";
		int count=0;
		while(num>0)
		{	
			if(num%1000>0)
				str=numToWord(num%1000)+" "+bigs[count]+" "+str;
			num/=1000;
			count++;
		}
		
		return str;
	}

	public String numToWord(int num)
	{
		String str="";
		
		while(num>0){
			if(num/100>=1)
				{
					str+=ones[num/100]+" hundred";
					num%=100;
				}

			else if(num/10>1 && num/10<=9)
			{
				str+=" "+tens[num/10];
				num%=10;
			}
			else if(num/10==1)
			{
				num%=10;
				str+=" "+teens[num-1];
				return str;
			}
			else if(num>=1 && num<=9)
				{
					str+=" "+ones[num];
					return str;
				}
	
		}
		return str;
		
	}
	
	public static void main(String[] args) {
		NumToWord obj=new NumToWord();
		System.out.println(obj.realWord(11111));	

}
}
