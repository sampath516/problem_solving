package com.ci.chap3.ds.arrays;



import org.junit.Assert;
import org.junit.Test;

public class ArraysTest {
	@Test
	public void testFindSingleDuplicate() {
		int[] input = new int []{0,0};
		int duplicate = Arrays.findSingleDuplicate(input);
		Assert.assertEquals(0, duplicate);
		
		input = new int []{0,1,0};
		duplicate = Arrays.findSingleDuplicate(input);
		Assert.assertEquals(0, duplicate);
		
		input = new int []{0,1,1};
		duplicate = Arrays.findSingleDuplicate(input);
		Assert.assertEquals(1, duplicate);
		
		input = new int []{0,1,2,1};
		duplicate = Arrays.findSingleDuplicate(input);
		Assert.assertEquals(1, duplicate);
		
		input = new int []{2,1,0,0};
		duplicate = Arrays.findSingleDuplicate(input);
		Assert.assertEquals(0, duplicate);
		
		input = new int []{0,1,2,2};
		duplicate = Arrays.findSingleDuplicate(input);
		Assert.assertEquals(2, duplicate);
	}

}
