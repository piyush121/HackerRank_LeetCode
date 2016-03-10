package hackerRank;

public class AnyBaseToDecimal {

	public static int convert(String str, int base) {

		int power = 0;
		int num = 0;
		for (int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) <= '9' && str.charAt(i) >= '0') // digits case
			{
				num += Math.pow(base, power) * (str.charAt(i) - '0');
				power++;
			} else {
				num += Math.pow(base, power) * (str.charAt(i) - 55); // Alphabets
																		// case.
				power++;
			}

		}

		return num;

	}

	public static String revConvert(int num, int base) // Converting any base to
														// decimal.
	{
		StringBuilder strb = new StringBuilder();
		while (num != 0) // keep on dividing until you get a 0.
		{
			if (num % base >= '0' && num % base <= '9') {
				strb.append(String.valueOf(num % base - '0'));
				num /= base;
			} else {
				char ch = (char) (num % base + 55);
				strb.append(ch);
				num /= base;
			}
		}
		return strb.toString();

	}

	public static void main(String[] args) {
		System.out.println(convert("A1", 16));
		System.out.println(revConvert(10, 11));
	}

}
