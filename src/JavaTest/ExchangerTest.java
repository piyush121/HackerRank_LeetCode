package JavaTest;

import java.util.concurrent.Exchanger;

public class ExchangerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exchanger<String> exchange = new Exchanger<String>();
		Thread t1 = new RobinExchanger(exchange);
		Thread t2 = new PiyushExchanger(exchange);
		t1.start();
		t2.start();

	}

}
