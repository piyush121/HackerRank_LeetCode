/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.List;

/**
 * Given two 1d vectors, implement an iterator to return their elements alternately.

For example, given two 1d vectors:

v1 = [1, 2]
v2 = [3, 4, 5, 6]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

Clarification for the follow up question - Update (2015-09-18):
The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

[1,2,3]
[4,5,6,7]
[8,9]
It should return [1,4,8,2,5,9,3,6,7].
Show Company Tags
Show Tags
Show Similar Problems

 *
 */
public class ZigzagIterator {
    Integer ptr1;
    Integer ptr2;
    boolean flag;
    List<Integer> v1;
    List<Integer> v2;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        ptr1 = 0;
        ptr2 = 0;
        flag = true;
    }

    public int next() {
        int val = 0;
        if(flag) {
            if(ptr1!= v1.size()) {
                val = v1.get(ptr1);
                ptr1++;
            }
            else {
                val = v2.get(ptr2);
                ptr2++;
            }
        }
        else {
            if(ptr2!= v2.size()) {
                val = v2.get(ptr2);
                ptr2++;
            }
            else {
                val = v1.get(ptr1);
                ptr1++;
            }
        
        }
        flag = !flag;
        return val;
    }

    public boolean hasNext() {
        if(ptr1 == v1.size() && ptr2 == v2.size())
            return false;
        else
            return true;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
