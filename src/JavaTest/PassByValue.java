/**
 * @author Piyush Chaudhary
 */
package JavaTest;

/**
 * @author Piyush Chaudhary
 *
 */
public class PassByValue {
	int val = 1;
	public void foo(PassByValue obj1) {
		obj1 = null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PassByValue obj = new PassByValue();
		PassByValue obj2 = new PassByValue();
		obj.foo(obj2);
		System.out.println(obj2.val);
	}

}
