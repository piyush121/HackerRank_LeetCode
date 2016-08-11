package TravisTest;

import static org.junit.Assert.*;
import hackerRank.CompareVersionNumbers;
import org.junit.Test;

public class Travis {
		@Test
		public void testHellowWorld(){
			assertEquals(1, CompareVersionNumbers.compareVersion("1.1", "01"));
		}
	}


