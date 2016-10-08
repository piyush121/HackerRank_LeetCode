/**
 * @author Piyush Chaudhary
 */
package hackerRank;
import java.util.*;
/**
 * The median of a dataset of integers is the midpoint value of the dataset for which an equal number of 
 * integers are less than and greater than the value. To find the median, you must first sort your dataset
 *  of integers in non-decreasing order, then:

If your dataset contains an odd number of elements, the median is the middle element of the sorted sample. 
If your dataset contains an even number of elements, the median is the average of the two middle elements 
Given an input stream of  integers, you must perform the following task for each  integer:

Add the  integer to a running list of integers.
Find the median of the updated list (i.e., for the first element through the  element).
Print the list's updated median on a new line. The printed value must be a double-precision number scaled 
to decimal place (i.e. 0.0,  format).
Input Format

The first line contains a single integer, , denoting the number of integers in the data stream. 
Each line  of the  subsequent lines contains an integer, , to be added to your list.

Constraints

Output Format

After each new integer is added to the list, print the list's updated median on a new line as a single
 double-precision number scaled to  decimal place (i.e.,  format).

Sample Input

6
12
4
5
3
8
7
Sample Output

12.0
8.0
5.0
4.5
5.0
6.0
 *
 */
public class RunningMedian {

	public static float getMedian(PriorityQueue<Integer> max, PriorityQueue<Integer> min) {
		if (max.size() > min.size())
			return (float) max.peek();
		else if (min.size() > max.size())
			return (float) min.peek();
		else
			return ((float) max.peek() + (float) min.peek()) / 2;
	}

	public static void main(String[] args) { // O(nlogn) with heaps. Good enough !
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[] = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}

		PriorityQueue<Integer> max = new PriorityQueue<>();
		PriorityQueue<Integer> min = new PriorityQueue<>(n, Collections.reverseOrder());
		min.offer(a[0]);
		System.out.println((float) a[0]);
		float median = (float) a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > median) {
				if (max.size() > min.size())
					min.offer(max.poll());
				max.offer(a[i]);
			}

			else {
				if (min.size() > max.size())
					max.offer(min.poll());
				min.offer(a[i]);
			}
			median = getMedian(max, min);
			System.out.println(median);
		}
	}
}
