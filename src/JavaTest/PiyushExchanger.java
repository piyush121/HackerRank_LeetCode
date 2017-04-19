package JavaTest;

import java.util.concurrent.Exchanger;

public class PiyushExchanger extends Thread {
	private Exchanger<String> sillyTalk;

	public PiyushExchanger(Exchanger<String> exchange) {
		this.sillyTalk = exchange;
	}

	public void run() {
		String reply;
		try {
			// start the conversation with CoffeeShopThread
			reply = sillyTalk.exchange("Knock knock!");
			// Now, print the response received from CoffeeShopThread
			System.out.println("CoffeeShop: " + reply);
			// exchange another set of messages
			reply = sillyTalk.exchange("Duke");
			// Now, print the response received from CoffeeShopThread
			System.out.println("CoffeeShop: " + reply);
			// an exchange could happen only when both send and receive happens
			// since this is the last sentence to speak, we close the chat by
			// ignoring the "dummy" reply
			reply = sillyTalk.exchange("The one who was born in this coffee shop!");
			// talk over, so ignore the reply!
		} catch (InterruptedException ie) {
			System.err.println("Got interrupted during my silly talk");
		}

	}
}
