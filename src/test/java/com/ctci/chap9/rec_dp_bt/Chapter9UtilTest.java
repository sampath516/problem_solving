package com.ctci.chap9.rec_dp_bt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.ctci.chap9.rec_dp_bt.Chapter9Util.Currency;

public class Chapter9UtilTest {

	@Test
	public void generatePermutationsTest() {
		String in = "ABC";
		char[] out = new char[in.length()];
		List<String> expected = new ArrayList<String>(Arrays.asList(new String[] { "ABC", "ACB", "BAC", "BCA", "CAB",
				"CBA", }));
		List<String> result = new ArrayList<String>();
		Chapter9Util.generatePermutations(in.toCharArray(), out, 0, in.length(), result);
		Assert.assertEquals(expected, result);

		in = "AB";
		out = new char[in.length()];
		expected = new ArrayList<String>(Arrays.asList(new String[] { "AB", "BA" }));
		result = new ArrayList<String>();
		Chapter9Util.generatePermutations(in.toCharArray(), out, 0, in.length(), result);
		Assert.assertEquals(expected, result);
	}

	@Test
	public void nQueensTest() {
		int n = 1;
		int[] x = new int[n];
		int depth = 0;
		int length = n;
		List<int[]> solutions = new ArrayList<int[]>();
		Chapter9Util.nQueens(x, depth, length, solutions);
		List<int[]> expected = new ArrayList<int[]>();
		expected.add(new int[] { 0 });
		int size = solutions.size();
		Assert.assertEquals(1, size);
		for (int i = 0; i < size; i++) {
			Assert.assertArrayEquals(expected.get(i), solutions.get(i));
		}

		n = 2;
		x = new int[n];
		depth = 0;
		length = n;
		solutions = new ArrayList<int[]>();
		Chapter9Util.nQueens(x, depth, length, solutions);
		Assert.assertTrue(solutions.isEmpty());

		n = 3;
		x = new int[n];
		depth = 0;
		length = n;
		solutions = new ArrayList<int[]>();
		Chapter9Util.nQueens(x, depth, length, solutions);
		Assert.assertTrue(solutions.isEmpty());

		n = 4;
		x = new int[n];
		depth = 0;
		length = n;
		solutions = new ArrayList<int[]>();
		Chapter9Util.nQueens(x, depth, length, solutions);
		expected = new ArrayList<int[]>();
		expected.add(new int[] { 1, 3, 0, 2 });
		expected.add(new int[] { 2, 0, 3, 1 });
		size = solutions.size();
		Assert.assertEquals(2, size);
		for (int i = 0; i < size; i++) {
			Assert.assertArrayEquals(expected.get(i), solutions.get(i));
		}

		n = 8;
		x = new int[n];
		depth = 0;
		length = n;
		solutions = new ArrayList<int[]>();
		Chapter9Util.nQueens(x, depth, length, solutions);
		expected = new ArrayList<int[]>();
		expected.add(new int[] { 1, 3, 0, 2 });
		expected.add(new int[] { 2, 0, 3, 1 });
		Assert.assertEquals(92, solutions.size());
		Assert.assertArrayEquals(new int[] { 0, 4, 7, 5, 2, 6, 1, 3 }, solutions.get(0));
		Assert.assertArrayEquals(new int[] { 1, 5, 7, 2, 0, 3, 6, 4 }, solutions.get(8));
		Assert.assertArrayEquals(new int[] { 2, 5, 3, 0, 7, 4, 6, 1 }, solutions.get(20));

	}

	@Test
	public void testDenominations() {

		int n = 1;
		Currency[] solution = new Currency[1];
		int depth = 0;
		int length = 4;
		int sum = 0;
		Set<Currency[]> solutions = new LinkedHashSet<Currency[]>();		
		Chapter9Util.generateRepresentationsOfNCents(n, depth, length, sum, solution, solutions, 0);
		Assert.assertEquals(1, solutions.size());
		Iterator<Currency[]> iter = solutions.iterator();
		Assert.assertArrayEquals(new Currency[] { Currency.PENNIES }, iter.next());

		n = 2;
		solution = new Currency[2];
		depth = 0;
		solutions = new LinkedHashSet<Currency[]>();
		Chapter9Util.generateRepresentationsOfNCents(n, depth, length, sum, solution, solutions, 0);
		Assert.assertEquals(1, solutions.size());
		iter = solutions.iterator();
		Assert.assertArrayEquals(new Currency[] { Currency.PENNIES, Currency.PENNIES }, iter.next());

		n = 5;
		solution = new Currency[5];
		depth = 0;
		solutions = new LinkedHashSet<Currency[]>();
		Chapter9Util.generateRepresentationsOfNCents(n, depth, length, sum, solution, solutions, 0);
		Assert.assertEquals(2, solutions.size());
		iter = solutions.iterator();
		Assert.assertArrayEquals(new Currency[] { Currency.NIKELS, null, null, null, null }, iter.next());
		Assert.assertArrayEquals(new Currency[] { Currency.PENNIES, Currency.PENNIES, Currency.PENNIES,
				Currency.PENNIES, Currency.PENNIES }, iter.next());

		n = 6;
		solution = new Currency[6];
		depth = 0;
		solutions = new LinkedHashSet<Currency[]>();
		Chapter9Util.generateRepresentationsOfNCents(n, depth, length, sum, solution, solutions, 0);
		Assert.assertEquals(2, solutions.size());
		iter = solutions.iterator();
		Assert.assertArrayEquals(new Currency[] { Currency.NIKELS, Currency.PENNIES, null, null, null, null },
				iter.next());

		Assert.assertArrayEquals(new Currency[] { Currency.PENNIES, Currency.PENNIES, Currency.PENNIES,
				Currency.PENNIES, Currency.PENNIES, Currency.PENNIES }, iter.next());

		n = 11;
		depth = 0;
		solutions = new LinkedHashSet<Currency[]>();
		solution = new Currency[n];
		Chapter9Util.generateRepresentationsOfNCents(n, depth, length, sum, solution, solutions, 0);
		// print(solutions);
		Assert.assertEquals(4, solutions.size());
		iter = solutions.iterator();
		Assert.assertArrayEquals(new Currency[] { Currency.DIMES, Currency.PENNIES, null, null, null, null, null, null,
				null, null, null }, iter.next());
		Assert.assertArrayEquals(new Currency[] { Currency.NIKELS, Currency.NIKELS, Currency.PENNIES, null, null, null,
				null, null, null, null, null }, iter.next());

		Assert.assertArrayEquals(new Currency[] { Currency.NIKELS, Currency.PENNIES, Currency.PENNIES,
				Currency.PENNIES, Currency.PENNIES, Currency.PENNIES, Currency.PENNIES, null, null, null, null },
				iter.next());
		Assert.assertArrayEquals(new Currency[] { Currency.PENNIES, Currency.PENNIES, Currency.PENNIES,
				Currency.PENNIES, Currency.PENNIES, Currency.PENNIES, Currency.PENNIES, Currency.PENNIES,
				Currency.PENNIES, Currency.PENNIES, Currency.PENNIES }, iter.next());
	}

//	private static void print(Set<Currency[]> set) {
//		for (Currency[] s : set) {
//			for (Currency c : s) {
//				if (c != null) {
//					System.out.print(c.name() + " ");
//				}
//			}
//			System.out.println();
//		}
//	}

}
