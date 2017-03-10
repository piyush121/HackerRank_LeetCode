/**
 * @author Piyush Chaudhary
 */
package JavaTest;

import java.util.*;

/**
 * This is a test for generic class.
 *
 */
public class BoxPrinter<T> {
	private T var1, var2;
	public BoxPrinter( int x, T y) {
		//this.var1 = x;
		this.var2 = y;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoxPrinter<String> box = new BoxPrinter<>(10, "bye");
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		Iterator<Integer> itr = list.iterator();
		for(;itr.hasNext();) {
			itr.next();
			itr.remove();
		}
	}

}
