package JavaTest;
class Sample {
	public int id = 10;
}
public class RandomIdGenerator extends Sample{
	public int id = 70;
	
	public RandomIdGenerator(int id) {
		this.id = id;
	}

	public static void main(String[] args) {
		Sample obj = new RandomIdGenerator(20);
	    System.out.println(obj.id);
	}
}


