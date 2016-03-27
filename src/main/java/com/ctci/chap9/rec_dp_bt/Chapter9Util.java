package com.ctci.chap9.rec_dp_bt;

import java.util.List;
import java.util.Set;

public class Chapter9Util {

	enum Currency {
		QUARTERTS(25), DIMES(10), NIKELS(5), PENNIES(1);
		private int value;

		private Currency(int value) {
			this.value = value;
		}
	};

	int noOfCoins = Currency.values().length;

	/**
	 * Write a method to compute all permutations of a string.
	 * 
	 * Solution: Solution is based on backtracking technique.
	 * 
	 * Explicit Constraints:
	 * 
	 * 
	 * Implicit Constraints:
	 * 
	 * 
	 * Assumptions:
	 * 
	 * 1. String contains unique characters. No duplicate characters
	 * 
	 */
	public static void generatePermutations(char[] in, char[] out, int depth, int length, List<String> result) {
		// base case
		if (depth == length) {
			return;
		}

		for (int i = 0; i < length; i++) {
			if (contains(out, depth, in[i])) {
				continue;
			}
			out[depth] = in[i];
			if (depth == length - 1) {
				result.add(new String(out));
			}
			generatePermutations(in, out, depth + 1, length, result);
		}
	}

	private static boolean contains(char[] in, int length, char c) {

		for (int i = 0; i < length; i++) {
			if (c == in[i]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Write an algorithm to print all ways of arranging eight queens on an 8x8
	 * chess board so that none of them share the same row, column or diagonal.
	 * In this case, "diagonal" means all diagonals, not just the two that
	 * bisect the board.
	 */
	public static void nQueens(int x[], int depth, int length, List<int[]> solutions) {

		for (int i = 0; i < length; i++) {
			// : depth --->row : column --->column :
			if (place(x, depth, i)) {
				x[depth] = i;
				if (depth == length - 1) {
					solutions.add(x.clone());
					return;
				}
				nQueens(x, depth + 1, length, solutions);
			}
		}

	}

	private static boolean place(int[] x, int row, int column) {
		for (int i = 0; i < row; i++) {
			// (row, column) ----> (i, x[i])
			if (x[i] == column || Math.abs(i - row) == Math.abs(x[i] - column)) {
				return false;
			}
		}

		return true;
	}

	private static void print(int[] x) {
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
		System.out.println();
	}

	/**
	 * Given an infinite number of quarters (25 cents), dimes (10 cents),
	 * nickels (5 cents) and pennies (1 cent), write code to calculate the
	 * number of ways of representing n cents.
	 * @param offset TODO
	 */
	public static void generateRepresentationsOfNCents(int n, int depth, int length, int sum, Currency[] solution,
			Set<Currency[]> solutions, int offset) {

		int localDepth = depth;
		int localSum = sum;
		for (int i = offset; i < length; i++) {
			localDepth = depth;
			localSum = sum;
			Currency nextDenomination = getNextDenomination(i);
			if (possibleSolution(n, localSum, nextDenomination.value)) {
				solution[localDepth] = nextDenomination;
				localSum = localSum + nextDenomination.value;
				if (answerSolution(n, localSum)) {
					solutions.add(solution.clone());
					localSum = sum;
				//	print(solution);
					adjustSolution(solution, depth);
					continue;
				}
				if (localDepth < solution.length - 1) {
					generateRepresentationsOfNCents(n, localDepth + 1, length, localSum, solution, solutions, i);
					adjustSolution(solution, depth);
				}

			}

		}
	}

	private static void adjustSolution(Currency[] solution, int depth) {
		for (int i = depth; i < solution.length; i++) {
			solution[i++] = null;
		}

	}

//	private static void print(Currency[] set) {
//		for (Currency c : set) {
//			if (c != null) {
//				System.out.print(c.name() + " ");
//			}
//		}
//		System.out.println();
//
//	}

	private static boolean answerSolution(int n, int sum) {
		return n == sum;
	}

	private static boolean possibleSolution(int n, int sum, int cents) {
		if (n >= (sum + cents)) {
			return true;
		}
		return false;
	}

	private static Currency getNextDenomination(int index) {

		switch (index) {
		case 0:
			return Currency.QUARTERTS;
		case 1:
			return Currency.DIMES;
		case 2:
			return Currency.NIKELS;
		case 3:
			return Currency.PENNIES;
		default:
			throw new RuntimeException("Unknown Cents Type");
		}

	}
}
