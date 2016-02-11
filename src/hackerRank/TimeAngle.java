package hackerRank;

public class TimeAngle {
	
	public static double findAngle(float h,float m)
	{
		double hrSpeed=0.5;
		double minSpeed=6.0;
		
		double angle=Math.abs((h*60+m)*hrSpeed - m*minSpeed);

		return Math.min(angle,360-angle);
		
	}
	
	public static void main(String[] args) {
		System.out.println(findAngle(9, 0));
	}

}
