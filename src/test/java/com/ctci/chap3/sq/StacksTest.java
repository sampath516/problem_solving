package com.ctci.chap3.sq;

import org.junit.Assert;
import org.junit.Test;

import com.ctci.chap3.sq.Stacks.StackNo;

public class StacksTest {
	@Test
	public void testIsEmptyAndSize() {
		Stacks stacks = new Stacks();
		Assert.assertTrue(stacks.isEmpty(StackNo.One));
		Assert.assertTrue(stacks.isEmpty(StackNo.Two));
		Assert.assertTrue(stacks.isEmpty(StackNo.Three));
		Assert.assertEquals(0, stacks.getSize(StackNo.One));
		Assert.assertEquals(0, stacks.getSize(StackNo.Two));
		Assert.assertEquals(0, stacks.getSize(StackNo.Three));

		stacks = new Stacks();
		stacks.push(StackNo.One, 11);
		Assert.assertFalse(stacks.isEmpty(StackNo.One));
		Assert.assertTrue(stacks.isEmpty(StackNo.Two));
		Assert.assertTrue(stacks.isEmpty(StackNo.Three));
		Assert.assertEquals(1, stacks.getSize(StackNo.One));
		Assert.assertEquals(0, stacks.getSize(StackNo.Two));
		Assert.assertEquals(0, stacks.getSize(StackNo.Three));
		
		stacks = new Stacks();
		stacks.push(StackNo.One, 11);
		stacks.push(StackNo.Two, 21);
		Assert.assertFalse(stacks.isEmpty(StackNo.One));
		Assert.assertFalse(stacks.isEmpty(StackNo.Two));
		Assert.assertTrue(stacks.isEmpty(StackNo.Three));
		Assert.assertEquals(1, stacks.getSize(StackNo.One));
		Assert.assertEquals(1, stacks.getSize(StackNo.Two));
		Assert.assertEquals(0, stacks.getSize(StackNo.Three));
		
		stacks = new Stacks();
		stacks.push(StackNo.One, 11);
		stacks.push(StackNo.Two, 21);
		stacks.push(StackNo.Three, 31);
		Assert.assertFalse(stacks.isEmpty(StackNo.One));
		Assert.assertFalse(stacks.isEmpty(StackNo.Two));
		Assert.assertFalse(stacks.isEmpty(StackNo.Three));
		Assert.assertEquals(1, stacks.getSize(StackNo.One));
		Assert.assertEquals(1, stacks.getSize(StackNo.Two));
		Assert.assertEquals(1, stacks.getSize(StackNo.Three));
		
		stacks = new Stacks();
		stacks.push(StackNo.One, 11);
		stacks.push(StackNo.Two, 21);
		stacks.push(StackNo.Three, 31);
		stacks.pop(StackNo.One);
		Assert.assertTrue(stacks.isEmpty(StackNo.One));
		Assert.assertFalse(stacks.isEmpty(StackNo.Two));
		Assert.assertFalse(stacks.isEmpty(StackNo.Three));
		Assert.assertEquals(0, stacks.getSize(StackNo.One));
		Assert.assertEquals(1, stacks.getSize(StackNo.Two));
		Assert.assertEquals(1, stacks.getSize(StackNo.Three));
		
		stacks = new Stacks();
		stacks.push(StackNo.One, 11);
		stacks.push(StackNo.Two, 21);
		stacks.push(StackNo.Three, 31);
		stacks.pop(StackNo.One);
		stacks.pop(StackNo.Two);
		Assert.assertTrue(stacks.isEmpty(StackNo.One));
		Assert.assertTrue(stacks.isEmpty(StackNo.Two));
		Assert.assertFalse(stacks.isEmpty(StackNo.Three));
		Assert.assertEquals(0, stacks.getSize(StackNo.One));
		Assert.assertEquals(0, stacks.getSize(StackNo.Two));
		Assert.assertEquals(1, stacks.getSize(StackNo.Three));
		
		stacks = new Stacks();
		stacks.push(StackNo.One, 11);
		stacks.push(StackNo.Two, 21);
		stacks.push(StackNo.Three, 31);
		stacks.pop(StackNo.One);
		stacks.pop(StackNo.Two);
		stacks.pop(StackNo.Three);
		Assert.assertTrue(stacks.isEmpty(StackNo.One));
		Assert.assertTrue(stacks.isEmpty(StackNo.Two));
		Assert.assertTrue(stacks.isEmpty(StackNo.Three));
		Assert.assertEquals(0, stacks.getSize(StackNo.One));
		Assert.assertEquals(0, stacks.getSize(StackNo.Two));
		Assert.assertEquals(0, stacks.getSize(StackNo.Three));

		
		stacks = new Stacks();
		stacks.push(StackNo.One, 11);
		stacks.push(StackNo.One, 12);
		stacks.push(StackNo.One, 13);
		stacks.push(StackNo.One, 14);
		stacks.push(StackNo.One, 15);
		stacks.push(StackNo.One, 16);
		stacks.push(StackNo.One, 17);
		stacks.push(StackNo.Two, 28);
		stacks.push(StackNo.Three, 31);
		stacks.pop(StackNo.Two);
		stacks.pop(StackNo.Three);
		Assert.assertFalse(stacks.isEmpty(StackNo.One));
		Assert.assertTrue(stacks.isEmpty(StackNo.Two));
		Assert.assertTrue(stacks.isEmpty(StackNo.Three));
		Assert.assertEquals(7, stacks.getSize(StackNo.One));
		Assert.assertEquals(0, stacks.getSize(StackNo.Two));
		Assert.assertEquals(0, stacks.getSize(StackNo.Three));

	}

}
