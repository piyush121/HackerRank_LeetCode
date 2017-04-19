/**
 * @author Piyush Chaudhary
 */
package JavaTest;

/**
 * @author Piyush Chaudhary
 *
 */
public class Consumer extends Thread{
	InterThreadCommunication food;

	public Consumer(InterThreadCommunication shared) {
		// TODO Auto-generated constructor stub
		this.food = shared;
	}

	public void run() {
		while (true) {		
			consume();
		}
	}

	public void consume() {
		synchronized (food) {

			System.out.println("Consumed food #" + food.food);
			food.notify();
			try {
				food.wait();
				System.out.println("Consumer Waiting");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}	
	}
}
