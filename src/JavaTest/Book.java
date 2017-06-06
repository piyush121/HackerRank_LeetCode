package JavaTest;
import java.io.*;
import java.util.Scanner;
abstract class AbstractBook {
	public String name = "Piyush";
}

interface Sleepy {
	//public String name = "undefined";
}

class Book extends AbstractBook implements Sleepy {
	public Book(String name) {
		this.name = name; // LINE A
	}

	public static void main(String[] args) {
		AbstractBook philosophyBook = new Book("Principia Mathematica");
		System.out.println(2 * 7 % 4); // LINE B
		Scanner scan = new Scanner(System.in);
		System.out.println(scan.nextInt());
	}
}