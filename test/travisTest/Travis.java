package travisTest;
import hackerRank.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class Travis {

	@Test
	public void test1(){
		assertEquals(1, CompareVersionNumbers.compareVersion("1.1", "01"));
	}
	@Test
	public void test2(){
		assertEquals(1, new CountCompleteTreeNodes().countNodes(new TreeNode(1)));
	}

}
