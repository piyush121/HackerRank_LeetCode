package TravisTest;

import static org.junit.Assert.*;
import hackerRank.CompareVersionNumbers;

public class Travis {
		@org.junit.Test
		public void testHellowWorld(){
			assertEquals(1, CompareVersionNumbers.compareVersion("1.1", "01"));
		}
	}


