package hackerRank;
import java.util.Scanner;

public class sevenWOnders {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
			String str = sc.next();
			int res = 0;
			int tc = count(str, 'T');
			int gc  = count(str, 'G');
			int cc = count(str, 'C');
			int min = Math.min(Math.min(tc, gc), cc);
			res += min * 7;
			res += tc*tc + gc*gc + cc*cc;
			System.out.println(res);

	}
	public static int count( String str, char ch) {
		int res = 0;
		
		for(char c : str.toCharArray())
			if(c == ch)
				res++;
		return res;
	}
	
	
}
