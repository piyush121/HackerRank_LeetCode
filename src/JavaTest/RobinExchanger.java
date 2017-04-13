package JavaTest;

import java.util.concurrent.Exchanger;

public class RobinExchanger extends Thread{
	Exchanger<String> exchangeMessage;
	
	public RobinExchanger(Exchanger<String> exchange) {
		this.exchangeMessage = exchange;
		this.start();
	}
	public void run() {
		String msg;
		try {
			msg = exchangeMessage.exchange("Knock knock");
			System.out.println("Piyush: " + msg);
			msg = exchangeMessage.exchange("How are you");
			System.out.println("Piyush: " + msg);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
