package JavaTest;

import java.util.HashMap;

interface A {
	default void equals1(Object obj) {

	}
}

class myclass {
	public int num = 10;

	public myclass(int x) {
		this.num = x;
	}

	public int getNum() {
		return num;
	}
}

public class InterfaceTest {
	public static void foo(int i) {
		i = 5;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> map = new HashMap<>();
		int i = 10;
		foo(i);
		System.out.println(i);
	}

}
