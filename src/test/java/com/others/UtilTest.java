package com.others;

import org.junit.Assert;
import org.junit.Test;

public class UtilTest {

	@Test
	public void testContinuousSubsequence() {

		int[] input = new int[] { 5, 6, 1 };
		int expectedSum = 12;
		int noOfSubSequences = Util.ContinuousSubsequence(input, expectedSum);
		Assert.assertEquals(1, noOfSubSequences);

		input = new int[] { 0, 5, 6, 1 };
		expectedSum = 12;
		noOfSubSequences = Util.ContinuousSubsequence(input, expectedSum);
		Assert.assertEquals(2, noOfSubSequences);

		input = new int[] { 5, 6, 1, 0 };
		expectedSum = 12;
		noOfSubSequences = Util.ContinuousSubsequence(input, expectedSum);
		Assert.assertEquals(2, noOfSubSequences);
		
		input = new int[] {0, 5, 6, 1, 0 };
		expectedSum = 12;
		noOfSubSequences = Util.ContinuousSubsequence(input, expectedSum);
		Assert.assertEquals(3, noOfSubSequences);
		
		input = new int[] {5};
		expectedSum = 12;
		noOfSubSequences = Util.ContinuousSubsequence(input, expectedSum);
		Assert.assertEquals(0, noOfSubSequences);
		
		input = new int[] {5,6};
		expectedSum = 12;
		noOfSubSequences = Util.ContinuousSubsequence(input, expectedSum);
		Assert.assertEquals(0, noOfSubSequences);
		
		input = new int[] {5,6,6};
		expectedSum = 12;
		noOfSubSequences = Util.ContinuousSubsequence(input, expectedSum);
		Assert.assertEquals(0, noOfSubSequences);
		
		input = new int[] {5,6,6,0};
		expectedSum = 12;
		noOfSubSequences = Util.ContinuousSubsequence(input, expectedSum);
		Assert.assertEquals(2, noOfSubSequences);

	}

}
