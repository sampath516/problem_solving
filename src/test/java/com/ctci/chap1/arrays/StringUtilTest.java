package com.ctci.chap1.arrays;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {
	
	@Test
	public void removeDuplicateTest(){
		Assert.assertEquals("a", StringUtil.removeDuplicateChars("a"));
		Assert.assertEquals("a", StringUtil.removeDuplicateChars("aa"));
		Assert.assertEquals("a", StringUtil.removeDuplicateChars("aaa"));
		Assert.assertEquals("ab", StringUtil.removeDuplicateChars("abb"));
		Assert.assertEquals("ab", StringUtil.removeDuplicateChars("abba"));
		Assert.assertEquals("abcde", StringUtil.removeDuplicateChars("abcde"));
		Assert.assertEquals("abcde", StringUtil.removeDuplicateChars("abcdeee"));

//		Assert.assertEquals("a", StringUtil.removeDuplicateChars_v1("a"));
//		Assert.assertEquals("a", StringUtil.removeDuplicateChars_v1("aa"));
//		Assert.assertEquals("a", StringUtil.removeDuplicateChars_v1("aaa"));
//		Assert.assertEquals("ab", StringUtil.removeDuplicateChars_v1("abb"));
//		Assert.assertEquals("ab", StringUtil.removeDuplicateChars_v1("abba"));
//		Assert.assertEquals("abcde", StringUtil.removeDuplicateChars_v1("abcde"));
//		Assert.assertEquals("abcde", StringUtil.removeDuplicateChars_v1("abcdeee"));


	}
	@Test
	public void areAnargmasTest(){
		Assert.assertFalse(StringUtil.arePermutations(null, null));
		Assert.assertFalse(StringUtil.arePermutations("ab", "a"));
		Assert.assertFalse(StringUtil.arePermutations("a", "b"));
		Assert.assertTrue(StringUtil.arePermutations("a", "a"));
		Assert.assertFalse(StringUtil.arePermutations("ab", "ca"));
		Assert.assertTrue(StringUtil.arePermutations("ab", "ba"));
		Assert.assertTrue(StringUtil.arePermutations("abc", "cba"));
		Assert.assertTrue(StringUtil.arePermutations("abc", "cab"));
		Assert.assertTrue(StringUtil.arePermutations("abc", "bac"));
		Assert.assertTrue(StringUtil.arePermutations("abc", "bca"));
		Assert.assertTrue(StringUtil.arePermutations("abc", "abc"));
		Assert.assertTrue(StringUtil.arePermutations("abc", "acb"));
	}

}
