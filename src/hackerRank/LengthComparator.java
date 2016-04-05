package hackerRank;
import java.util.Comparator;

/**
 * @author Piyush Chaudhary
 *
 */
public class LengthComparator implements Comparator<String>{ // compare strings based in their length.

	@Override
	public int compare(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return new Integer(arg0.length()).compareTo(arg1.length());
	}

}
