/**
 * @author Piyush Chaudhary
 */
package JavaTest;

import java.util.*;

/**
 * This is a test for generic class.
 *
 */
public class BoxPrinter<T> implements Comparable<BoxPrinter<T>> {
	public int var1;
	public T var2;
	public BoxPrinter( int x, T y) {
		this.var1 = x;
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
		Integer a = 500;
		Integer b = 500;
		//System.out.println(a == b);
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return 0;
			}
			
		});
		//Map<String, String> map = new Hashtable<>();
		String str = "abc";
		String str2 = "abc";
		String str1 = new String("abc");
		System.out.println(str == str1);
		//System.out.println();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + var1;
		result = prime * result + ((var2 == null) ? 0 : var2.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoxPrinter other = (BoxPrinter) obj;
		if (var1 != other.var1)
			return false;
		if (var2 == null) {
			if (other.var2 != null)
				return false;
		} else if (!var2.equals(other.var2))
			return false;
		return true;
	}


	public int compareTo(BoxPrinter<T> o) {
		// TODO Auto-generated method stub
		return this.var1 - o.var1;
	}
	
	

}
