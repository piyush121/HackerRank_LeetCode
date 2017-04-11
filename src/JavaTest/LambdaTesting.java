/**
 * @author Piyush Chaudhary
 */
package JavaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Piyush Chaudhary
 *
 */
@FunctionalInterface
interface MyLambda {
	public int foo(int a);

	default void show() {

	}
}

public class LambdaTesting implements Runnable{
	static int count = 0;
	public static void inc() {
		//show something.
	synchronized(LambdaTesting.class) {
		count++;
		}
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		inc();		
	}
	public static void main(String[] args) {
		Consumer<Integer> consumer = p -> {
			System.out.println(p);
			// System.out.println(this); Will not work.
		};

		consumer.accept(10);
	
	Integer[] arr = {3,2,4,1,5};
	List<Integer> list = Arrays.asList(arr);
	int sum = list.stream().filter(a -> a > 1).reduce(0, (a, b) -> a + b);
	System.out.println(LambdaTesting.class);
	}

	
}
