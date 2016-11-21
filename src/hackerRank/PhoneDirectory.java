/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

/**
 * Design a Phone Directory which supports the following operations:

get: Provide a number which is not assigned to anyone.
check: Check if a number is available or not.
release: Recycle or release a number.
Example:

// Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
PhoneDirectory directory = new PhoneDirectory(3);

// It can return any available phone number. Here we assume it returns 0.
directory.get();

// Assume it returns 1.
directory.get();

// The number 2 is available, so return true.
directory.check(2);

// It returns 2, the only number that is left.
directory.get();

// The number 2 is no longer available, so return false.
directory.check(2);

// Release number 2 back to the pool.
directory.release(2);

// Number 2 is available again, return true.
directory.check(2);
 *
 */
public class PhoneDirectory {

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
        TreeSet<Integer> availableNumbers; // TreeSet is not very efficient. But works !
        int size;
    public PhoneDirectory(int maxNumbers) {
        availableNumbers = new TreeSet<>();
        for(int i = 0 ; i < maxNumbers; i++)
            availableNumbers.add(i);
        size = maxNumbers;
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(availableNumbers.size() == 0)
            return -1;
        int next = availableNumbers.first();
        availableNumbers.remove(next);
        return next;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return availableNumbers.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        availableNumbers.add(number);
    }
}

class PhoneDirectory2 { // fastest

	  Queue<Integer> availableQ;
	    int[] checkList;
	    public PhoneDirectory2(int maxNumbers) {
	        availableQ = new LinkedList<Integer>();
	        checkList = new int[maxNumbers];
	        for(int i=0;i<maxNumbers;i++)
	            availableQ.add(i);
	    }
	    
	    /** Provide a number which is not assigned to anyone.
	        @return - Return an available number. Return -1 if none is available. */
	    public int get() { // O(1)
	        if(availableQ.isEmpty()==true) return -1;
	        else checkList[availableQ.peek()] = -1;
	        return availableQ.poll();
	    }
	    
	    /** Check if a number is available or not. */
	    public boolean check(int number) {//O(1)
	        if(checkList[number]==-1) return false;
	        else return true;
	    }
	    
	    /** Recycle or release a number. */
	    public void release(int number) { //O(1)
	        if(checkList[number]==-1){
	            checkList[number] = 0;
	            availableQ.add(number);
	        }
	    }
	}

class PhoneDirectory1 { // another good solution.

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
        Set<Integer> usedNumbers;
        List<Integer> numbers;
        int size;
    public PhoneDirectory1(int maxNumbers) { // O(n)
        usedNumbers = new HashSet<>();
        numbers = new ArrayList<>();
        for(int i = 0 ; i < maxNumbers; i++) {
            numbers.add(i);
        }
        size = maxNumbers;
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(numbers.size() == 0)
            return -1;
        int next = numbers.remove(0);
        usedNumbers.add(next);
        return next;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !usedNumbers.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(usedNumbers.remove(number))
            numbers.add(number);
    }
}
/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
