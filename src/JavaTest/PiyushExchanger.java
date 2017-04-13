package JavaTest;

import java.util.concurrent.Exchanger;

public class PiyushExchanger extends Thread{
	Exchanger<String> exchangeMessage;
	
	public PiyushExchanger(Exchanger<String> exchange) {
		this.exchangeMessage = exchange;
		this.start();
	}
	public void run() {
		String msg;
		try {
			msg = exchangeMessage.exchange("Hi");
			System.out.println("Robin: " + msg);
			msg = exchangeMessage.exchange("I'm good");
			System.out.println("Robin: " + msg);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
