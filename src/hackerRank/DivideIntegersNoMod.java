package hackerRank;

public class DivideIntegersNoMod {

	public static int divide(int dividend, int divisor) { // Highly inefficient.
		int dividendabs = Math.abs(dividend);
		int divisorabs = Math.abs(divisor);
		if (divisorabs == 1) {
			if (dividend > 0 && divisor > 0 || dividend < 0 && divisor > 0)
				return dividend;
			else
				return dividendabs;
		}
		int count = 0;
		while (dividendabs > 0) {
			dividendabs -= divisorabs;
			count++;
			if (dividendabs < 0)
				count--;
			if (count == Integer.MAX_VALUE)
				break;
		}
		if (dividend > 0 && divisor > 0 || dividend < 0 && divisor > 0)
			return count;
		else
			return -1 * count;
	}

	public static int divide1(int dividend, int divisor) { // Efficient.
		if(dividend == Integer.MIN_VALUE && divisor==-1) //Corner case.
			return Integer.MAX_VALUE;
		long dividendabs = Math.abs((long)dividend);
		long divisorabs = Math.abs((long)divisor);
		long count = 1;			//
		int res = 0;
		long temp = dividendabs;
		while (dividendabs >= divisorabs) {
			count = divisorabs;
			temp = 1;
			while (dividendabs - count >= count << 1) {
				count = count << 1;	//shifting count by 1 bit to make it double.
				temp = temp << 1;	// shifting temporary result by 1 bit as well.
			}
			dividendabs -= count;	//because need to check whether the remaining number is still divisible by divisor.
			res += temp;
		}
		if (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0)
			return res;
		else
			return -res;
	}

	public static void main(String[] args) {
		System.out.println(divide1(1,1));
	}

}
