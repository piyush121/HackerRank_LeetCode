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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Rewa == null) ? 0 : Rewa.hashCode());
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
		InterfaceTest other = (InterfaceTest) obj;
		if (Rewa == null) {
			if (other.Rewa != null)
				return false;
		} else if (!Rewa.equals(other.Rewa))
			return false;
		return true;
	}

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
