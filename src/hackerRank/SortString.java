package hackerRank;

public class SortString {
	
	public static void sort(String str){ // Sort in case sensitive order.
		char[] str1=str.toCharArray();
		
		for(int i=0;i<str.length();i++) // Applying normal bubble sort.
			for(int j=1;j<str.length();j++){
				if(Character.compare(Character.toLowerCase(str1[j]),Character.toLowerCase(str1[j-1]))==0)
					{if(str1[j]<str1[j-1]){
						char temp=str1[j-1];
						str1[j-1]=str1[j];
						str1[j]=temp;
				}
					}
				else if(Character.compare(Character.toLowerCase(str1[j]),Character.toLowerCase(str1[j-1]))<0){
					
						char temp=str1[j-1];
						str1[j-1]=str1[j];
						str1[j]=temp;
				
				}
			}
		String newStr=new String(str1);
		System.out.println(newStr);
	}
	public static void main(String[] args) {
		sort("CbaDd");
	}
}
