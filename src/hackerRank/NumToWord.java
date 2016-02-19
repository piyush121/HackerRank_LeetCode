package hackerRank;

public class NumToWord { //Really a tedious problem.
	String[] ones={"","one","two","three","four","five","six","seven","eight","nine"};
	String[] teens={"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
	String[] tens={"","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
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
		int div=1;
		while(num/div>=10)
			div*=10;
		while(div>=1)
		{
			if(div==100)
				{
					str+=ones[num/div]+" hundred";
					num-=div*(num/div);
				}

			else if(div==10 && num/div>1)
			{
				str+=" "+tens[num/div-1];
				num-=div*(num/div);
			}
			else if(div==10 && num/div==1)
			{
				num-=div*(num/div);
				div/=10;
				str+=" "+teens[num/div ];
				break;
			}
			else if(div>=1 && div <=9)
				{
					str+=" "+ones[num/div];
					num-=div*(num/div);

				}

			div/=10;
			
		}
		return str;
		
	}
	
	public static void main(String[] args) {
		NumToWord obj=new NumToWord();
		System.out.println(obj.realWord(1000000));	

}
}
