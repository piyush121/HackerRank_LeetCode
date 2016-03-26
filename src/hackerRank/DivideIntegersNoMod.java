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

	public static int divide1(int dividend, int divisor) { // Highly Efficient.
		int dividendabs = Math.abs(dividend);
		int divisorabs = Math.abs(divisor);

		int count = 1;
		int res = 0;
		int temp = dividendabs;
		while (dividendabs >= 0) {
			count = 1;
			temp = 1;
			while (dividendabs - count >= 0) {
				count = count << 1;
				temp = temp <<1;
			}
			dividendabs -= count;
			res += count;
		}
		if (dividend > 0 && divisor > 0 || dividend < 0 && divisor > 0)
			return res;
		else
			return -res;
	}

	public static void main(String[] args) {
		System.out.println(divide1(15, 3));
	}

}
