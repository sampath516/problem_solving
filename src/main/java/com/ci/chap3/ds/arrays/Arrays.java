package com.ci.chap3.ds.arrays;

public class Arrays {
	/**
	 * Duplication in an Array
	 * 
	 * Question 5: An array contains n numbers ranging from 0 to n-2. There is
	 * exactly one number duplicated in the array. How do you find the
	 * duplicated number? For example, if an array with length 5 contains
	 * numbers {0, 2, 1, 3, 2}, the duplicated number is 2.
	 * 
	 * Approach-1: In single pass, arrange the numbers at their respective
	 * positions. For example, 0 at 0th position, 1 at 1st position etc. One
	 * number does not get the position because already a duplicate of it
	 * already occupied its position.
	 */
	public static int findSingleDuplicate(int[] input) {
		int duplicate = -1;
		int temp = 0;
		for (int p = 0; p < input.length;) {
			if (input[p] < 0 || input[p] > (input.length - 1)) {
				throw new IllegalArgumentException("Invalid number at index: "
						+ p);
			}
			
			//If the number(i.e. input[p]) at position p is greater than p, then swap input[p] with input[input[p]]
			if (input[p] > p) {
				temp = input[p];
				input[p] = input[temp];
				input[temp] = temp;
			//If input[p] equals to its position p, increase p by one position
			} else if (input[p] == p) {
				p++;
			//If input[p] is less than its position value, input[p] is the duplicate element.
			} else {
				duplicate = input[p];
				break;
			}
		}
		return duplicate;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
