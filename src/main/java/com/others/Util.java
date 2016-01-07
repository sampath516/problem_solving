package com.others;

public class Util {
	/**
	 * Computes the number of continuous subsequences whose sum is equal to the
	 * expected sum. Example: Input 5, 6, 1, 5,10, 3, 6,3, 7, Expected sum: 12
	 * Output: 3 3 sub sequences: [5,6,1], [6,1,5] and [3,6,3]
	 * 
	 * @param input
	 * @param expectedSum
	 * @return
	 */
	public static int ContinuousSubsequence(int[] input, int expectedSum) {

		int sum = 0;
		int noOfSubSequences = 0;
		int begin = 0, end = 0;
		while (sum == expectedSum || end < input.length) {

			if (sum == expectedSum) {
				noOfSubSequences++;
				if (end < input.length) {
					sum = sum + input[end++];
				} else {
					sum = sum - input[begin++];
				}
			} else if (sum < expectedSum) {
				sum = sum + input[end++];
			} else {
				sum = sum - input[begin++];
			}

		}

		return noOfSubSequences;
	}

}
