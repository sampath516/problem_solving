package com.ctci.chap3.sq;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SetOfStacksTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void popShouldThrowExceptionWhenStackIsEmpty() {
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Stack is Empty");
		SetOfStacks stack = new SetOfStacks();
		stack.pop();
	}
	
	@Test
	public void test(){
		SetOfStacks stack = new SetOfStacks();
		
		stack.push(1);
		Assert.assertEquals(1, stack.size());
		Assert.assertEquals(1, stack.stacksSize());		
		Assert.assertEquals(1, stack.pop());
		Assert.assertEquals(0, stack.size());
		Assert.assertEquals(0, stack.stacksSize());	
		stack.push(2);
		Assert.assertEquals(1, stack.size());
		Assert.assertEquals(1, stack.stacksSize());	
		Assert.assertEquals(2, stack.pop());
		Assert.assertEquals(0, stack.size());
		Assert.assertEquals(0, stack.stacksSize());
		
		stack.push(11);
		stack.push(12);
		stack.push(13);
		Assert.assertEquals(3, stack.size());
		Assert.assertEquals(1, stack.stacksSize());	
		stack.push(21);
		Assert.assertEquals(4, stack.size());
		Assert.assertEquals(2, stack.stacksSize());
		Assert.assertEquals(21, stack.pop());
		Assert.assertEquals(3, stack.size());
		Assert.assertEquals(1, stack.stacksSize());
		stack.push(211);
		Assert.assertEquals(4, stack.size());
		Assert.assertEquals(2, stack.stacksSize());

	}

}
