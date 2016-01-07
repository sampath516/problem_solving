package com.ctci.chap1.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringUtil {

	/**
	 * 
	 * Implement an algorithm to determine if a string has all unique
	 * characters. What if you can not use additional data structures?
	 * 
	 * Option 1: Use HashSet; TC: O(N)
	 * 
	 * Option 2: Brute force approach: Compare every character (one by one, in
	 * sequence, starting with first character) with all other characters; TC:
	 * O(N2)
	 */
	public static boolean containsUniqueCharacters(String str) {

		if (str == null || str.length() <= 1) {
			return true;
		}
		int length = str.length();
		Set<Character> set = new HashSet<Character>();
		char[] strArr = str.toCharArray();
		for (int i = 0; i < length; i++) {
			if (set.contains(strArr[i])) {
				return false;
			} else {
				set.add(strArr[i]);
			}
		}
		return true;
	}

	/**
	 * Write code to reverse a String.
	 * 
	 */
	public static String reverse(String str) {
		if (str == null || str.length() == 1) {
			return str;
		}

		char[] strArr = str.toCharArray();
		int length = str.length();

		for (int i = 0, j = length - 1; i < j; i++, j--) {
			if (strArr[i] != strArr[j]) {
				swap(strArr, i, j);
			}
		}
		return new String(strArr);

	}

	private static void swap(char[] strArr, int i, int j) {
		char c = strArr[i];
		strArr[i] = strArr[j];
		strArr[j] = c;
	}
	/**
	 * Remove duplicate characters from a string
	 * Option 1: Brute force approach
	 */
	public static String removeDuplicateChars(String strIn) {
		if (strIn == null || strIn.length() == 1) {
			return strIn;
		}

		char[] strArr = strIn.toCharArray();
		int length = strArr.length;
		for (int i = 0; i < length - 1; i++) {
			for (int j = i + 1; j < length; j++) {
				if (strArr[i] == strArr[j]) {
					remove(strArr, j, length);
					j--;
					length--;
					continue;
				}
			}
		}
		String strOut = new String(strArr);
		return strOut.substring(0, length);
	}

	private static void remove(char[] strArr, int j, int length) {
		for (int i = j; i < length - 1; i++) {
			strArr[j] = strArr[j + 1];
		}

	}

	public static String removeDuplicateChars_v1(String strIn) {
		if (strIn == null || strIn.length() == 1) {
			return strIn;
		}

		char[] strArr = strIn.toCharArray();
		int start = 0;
		for (int i = strArr.length - 1; i > start; i--) {
			for (int j = i - 1; j >= start; j--) {
				if (strArr[i] == strArr[j]) {
					if (j > 0) {
						strArr[j] = strArr[j - 1];
						j++;
						start++;
					}						
					continue;
				}
			}
		}
		String strOut = new String(strArr);
		return strOut.substring(start+1, strArr.length);
	}

	public static boolean arePermutations(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length()) {
			return false;
		}
		if (s1.length() == 1) {
			if (s1.equals(s2)) {
				return true;
			} else {
				return false;
			}
		}
		char[] s1a = s1.toCharArray();
		char[] s2a = s2.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s1a.length; i++) {
			Integer count = map.get(s1a[i]);
			if (count != null) {
				map.put(s1a[i], count + 1);
			} else {
				map.put(s1a[i], 1);
			}
		}
		for (int j = 0; j < s2a.length; j++) {
			Integer count = map.get(s2a[j]);
			if (count != null) {
				if (count > 1) {
					map.put(s2a[j], count - 1);
				} else {
					map.remove(s2a[j]);
				}

			} else {
				return false;
			}
		}
		if (map.size() > 0) {
			return false;
		}

		return true;
	}

	public static char[] replaceColon(char[] in, char[] token, int actualLength) {
		if (in == null || token == null) {
			return in;
		}
		int newActualLength = 0;
		int spaceCount = 0;
		for (int i = 0; i < actualLength; i++) {
			if (in[i] == ':') {
				spaceCount += 1;
			}
		}
		if (spaceCount == 0) {
			return in;
		}

		newActualLength = actualLength + 2 * spaceCount;
		if (newActualLength > in.length) {
			throw new RuntimeException("No sufficient space");
		}
		for (int j = actualLength - 1, k = newActualLength - 1; j >= 0; j--, k--) {
			if (in[j] == ':') {
				in[k] = '0';
				in[--k] = '2';
				in[--k] = '%';
			} else {
				in[k] = in[j];
			}
		}
		return in;
	}

	public static String stringCompression(String s) {

		if (s == null || s.length() == 2) {
			return s;
		}
		char[] sArr = s.toCharArray();
		StringBuffer compressedStr = new StringBuffer();
		int charCount = 1;
		compressedStr.append(sArr[0]);
		for (int i = 1; i < sArr.length; i++) {
			if (sArr[i] == sArr[i - 1]) {
				charCount += 1;
			} else {
				compressedStr.append(charCount);
				compressedStr.append(sArr[i]);
				charCount = 1;
			}
		}
		compressedStr.append(charCount);
		if (compressedStr.length() >= s.length()) {
			return s;
		}
		return compressedStr.toString();
	}

	public static void main(String[] args) {

		// System.out.println("Null: " + containsUniqueCharacters(null));
		// System.out.println("Empty: " + containsUniqueCharacters(""));
		// System.out.println("One: " + containsUniqueCharacters("A"));
		// System.out.println("Aa: " + containsUniqueCharacters("Aa"));
		// System.out.println("AA: " + containsUniqueCharacters("AA"));

		// System.out.println("Null: " + reverse(null));
		// System.out.println("A: " + reverse("A"));
		// System.out.println("Aa: " + reverse("Aa"));
		// System.out.println("AA: " + reverse("AA"));
		// System.out.println("AB: " + reverse("AB"));
		// System.out.println("ABC: " + reverse("ABC"));
		// System.out.println("ABCD: " + reverse("ABCD"));

		// System.out.println("null, null: " + arePermutations(null, null));
		// System.out.println("null, a: " + arePermutations(null, "a"));
		// System.out.println("abc, cb: " + arePermutations("abc", "cb"));
		// System.out.println("a, A: " + arePermutations("a", "A"));
		// System.out.println("a, a: " + arePermutations("a", "a"));
		// System.out.println("ab, ac: " + arePermutations("ab", "ac"));
		// System.out.println("ab, ba: " + arePermutations("ab", "ba"));
		// System.out.println("abc, acd: " + arePermutations("abc", "acd"));
		// System.out.println("abc, acb: " + arePermutations("abc", "acb"));

		// System.out.println("ABC, null, 0***"
		// + new String(replaceColon("ABC".toCharArray(), null, 0)));
		// System.out.println("'ABC:  ', '%20', 4*****"
		// + new String(replaceColon("ABC:      ".toCharArray(),
		// "%20".toCharArray(), 4)));
		// System.out.println("'A:BC:       ', '%20', 5*****"
		// + new String(replaceColon("A:BC:         ".toCharArray(),
		// "%20".toCharArray(), 5)));
		// System.out.println("'::::              ', '%20', 4*****"
		// + new String(replaceColon("::::              '".toCharArray(),
		// "%20".toCharArray(), 4)));
		// System.out.println("'ABCD              ', '%20', 4*****"
		// + new String(replaceColon("::::              '".toCharArray(),
		// "%20".toCharArray(), 4)));

		System.out.println("null: " + stringCompression(null));
		System.out.println("AA: " + stringCompression("AA"));
		System.out.println("Aa: " + stringCompression("Aa"));
		System.out.println("ABCDE: " + stringCompression("ABCDE"));
		System.out.println("aabbbccccdee: " + stringCompression("Aabbbcccdee"));
		System.out.println("aaaaabbbb: " + stringCompression("aaaaabbbb"));
		System.out.println("aaaaabbbbcccd: " + stringCompression("aaaaabbbbcccd"));

	}

}
