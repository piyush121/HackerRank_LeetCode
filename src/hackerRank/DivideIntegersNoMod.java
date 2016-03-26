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

	public static void main(String[] args) {
		System.out.println(divide(2147483647, 2));
	}

}
