/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Follow up for H-Index: What if the citations array is sorted in ascending
 * order? Could you optimize your algorithm?
 * 
 * Hint:
 * 
 * Expected runtime complexity is in O(log n) and the input is sorted.
 *
 * 
 */
public class H_Index_II {
	public static int hIndex(int[] citations) {
		int len = citations.length;
		if (len == 0)
			return 0;
		int end = len - 1;
		int mid = end / 2;
		int start = 0;
		while (start < end) { // Usual stuff.
			if (citations[mid] >= len - mid) // H-Index check.
				end = mid;
			else
				start = mid + 1;
			mid = (start + end) / 2; // This will ensure the correct mid value.
		}
		if (citations[mid] >= len - mid) // Final check.
			return len - mid;
		else
			return 0;
	}

	public static void main(String[] args) {
		System.out.println(hIndex(new int[] { 1, 1, 2, 3, 4, 5, 7 }));
	}
}
