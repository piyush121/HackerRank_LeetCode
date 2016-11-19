/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a stream of integers and a window size, calculate the moving average of all 
 * integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
 */
public class MovingAverageFromDataStream {
	int size;
    int count;
    List<Integer> list;
    double avg;
    double sum;
    /** Initialize your data structure here. */
    public MovingAverageFromDataStream(int size) { // O(k) space and O(1) runtime.
        this.size = size;
        this.count = 0;
        this.list = new LinkedList<>();
        this.avg = 0;
        this.sum = 0;
    }
    
    public double next(int val) {
        if(count < size) {
            list.add(val);
            sum += val;
            count++;
            avg = sum / count;
        }
        else {
            sum -= list.get(0);
            list.remove(0);
            list.add(val);
            sum += val;
            avg = sum / size;
        }
        
        return avg;
    }
}
