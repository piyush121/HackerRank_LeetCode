/**
 * @author Piyush Chaudhary
 */
package JavaTest;

/**
 * @author Piyush Chaudhary
 *
 */
public class Producer extends Thread {
	InterThreadCommunication food;

	public Producer(InterThreadCommunication shared) {
		// TODO Auto-generated constructor stub
		this.food = shared;
	}

	public void run() {
		while (true) {
			try {
				produce();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void produce() throws InterruptedException {
		synchronized (food) {
			food.food++;
			Thread.sleep(1000);
			food.notify();
			try {
				System.out.println("PRoducer Waiting");
				food.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
