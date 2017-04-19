/**
 * @author Piyush Chaudhary
 */
package JavaTest;

/**
 * @author Piyush Chaudhary
 *
 */
public class InterThreadCommunication {
	public int food = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterThreadCommunication sharedResource = new InterThreadCommunication();
		sharedResource.food = 0;
		Thread t1 = new Producer(sharedResource);
		Thread t2 = new Consumer(sharedResource);
		t1.start();
		t2.start();

	}

}
