package JavaTest;

import java.util.concurrent.Semaphore;

class Person extends Thread {
	Semaphore machine;
	String name;

	public void run() {
		System.out.println(name + " waiting to acquire ATM");
		try {
			machine.acquire();
			System.out.println(name + " Using machine now.");
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name + " Machine used");
		machine.release();
	}

	public Person(Semaphore ATM, String name) {
		this.machine = ATM;
		this.name = name;
		this.start();
	}
}

public class SemaphoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Semaphore machine = new Semaphore(2);
		new Person(machine, "Piyush");
		new Person(machine, "Robin");
		new Person(machine, "Nitin");
		new Person(machine, "Rahul");
		new Person(machine, "Gaurav");
	}

}
