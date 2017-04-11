package JavaTest;
//Deadloack test
public class Deadlock {
	public static void main(String[] args) {
		LambdaTesting lamb = new LambdaTesting();
		Thread t1 = new Thread(lamb);
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
}
