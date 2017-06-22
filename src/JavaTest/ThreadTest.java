/**
 * @author Piyush Chaudhary
 */
package JavaTest;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Piyush Chaudhary
 *
 */
public class ThreadTest extends Thread {
	public static void show() {
		System.out.println("");
	}
	protected void protmet(){
        System.out.println("PROTECTED METHOD");
    }
	
	public void run() {
		System.out.println("Child thread:" + Thread.currentThread().getName());

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new ThreadTest();
		t1.start();
		Thread t2 = new ThreadTest();
		t2.start();
		Thread t3 = new ThreadTest();
		t3.start();
		Throwable th = new Throwable();
		// th.printStackTrace();
		System.out.println(Thread.currentThread().getName());

		try (FileReader input = new FileReader("file.txt");
				BufferedInputStream bufferedInput = new BufferedInputStream(null);) {
			int data = bufferedInput.read();
			while (data != -1) {
				System.out.print((char) data);
				data = bufferedInput.read();
			}
		} catch (IOException | ArithmeticException | NullPointerException exc) {

		}
		System.out.println(1.0/0);
		ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
		TreeSet<Integer> treeset = new TreeSet<>();
		treeset.add(null);
		}
}
