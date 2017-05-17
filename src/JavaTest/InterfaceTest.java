package JavaTest;

import java.util.HashMap;

interface A {
	default void equals1(Object obj) {

	}
}

class myclass {
	protected int num = 10;

	public myclass(int x) {
		this.num = x;
	}

	public int getNum() {
		return num;
	}
}

public class InterfaceTest extends myclass{
	String Rewa = "Rewa";

	public InterfaceTest(int x) {
		super(x);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> map = new HashMap<>();
		myclass obj = new myclass(2);
		obj.num = 20;
	}

}
