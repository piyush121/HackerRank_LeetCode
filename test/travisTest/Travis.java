package travisTest;

import static org.junit.Assert.*;

import org.junit.Test;

import hackerRank.CompareVersionNumbers;

public class Travis {

	@Test
	public void testHellowWorld(){
		assertEquals(1, CompareVersionNumbers.compareVersion("1.1", "01"));
	}

}
