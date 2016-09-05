/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among
 * them, there may exist one celebrity. The definition of a celebrity is that
 * all the other n - 1 people know him/her but he/she does not know any of them.
 * 
 * Now you want to find out who the celebrity is or verify that there is not
 * one. The only thing you are allowed to do is to ask questions like: "Hi, A.
 * Do you know B?" to get information of whether A knows B. You need to find out
 * the celebrity (or verify there is not one) by asking as few questions as
 * possible (in the asymptotic sense).
 * 
 * You are given a helper function bool knows(a, b) which tells you whether A
 * knows B. Implement a function int findCelebrity(n), your function should
 * minimize the number of calls to knows.
 * 
 * Note: There will be exactly one celebrity if he/she is in the party. Return
 * the celebrity's label if there is a celebrity in the party. If there is no
 * celebrity, return -1.
 *
 */
public class FindTheCelebrity {
	
	public int findCelebrity(int n) { // Efficient 2 pass solution.
        if(n < 2)
            return -1;
        int candidate = 0;
        for(int i = 1 ; i < n; i++)
            if(knows(candidate, i)) // If A knows B then A cannot be celebrity.
                candidate = i; // And if B knows A then B cannot be celebrity.
        for(int i = 0 ; i < n; i++)
            if(i != candidate && !knows(i,candidate) || i != candidate && knows(candidate, i))
                return -1;
        return candidate;
        
    }
	
	public int findCelebrity1(int n) { // Almost bruteforce implementation.
		for (int i = 0; i < n; i++)
			if (helper(i, n) && celeb(i, n))
				return i;
		return -1;
	}

	private boolean helper(int k, int n) { // whether everybody know this
											// person.

		for (int i = 0; i < n; i++) {

			if (i != k && !knows(i, k))
				return false;
		}
		return true;
	}

	private boolean celeb(int k, int n) { // Whether this person knows anybody.
		for (int i = 0; i < n; i++) {

			if (i != k && knows(k, i))
				return false;
		}
		return true;
	}

	private boolean knows(int a, int b) { // dummy method.
		return true;
	}
}
