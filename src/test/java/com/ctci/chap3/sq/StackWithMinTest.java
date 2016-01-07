package com.ctci.chap3.sq;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StackWithMinTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void popShouldThrowExceptionWhenStackIsEmpty() {
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Stack is Empty");
		StackWithMin stack = new StackWithMin();
		stack.pop();

	}

	@Test
	public void pushShouldThrowExceptionWhenStackIsFull() {
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Stack is Full");
		StackWithMin stack = new StackWithMin();
		for (int i = 1; i <= 10; i++) {
			stack.push(i);
		}
		stack.push(11);
	}
	@Test
	public void test(){
		StackWithMin stack = new StackWithMin();
		
		stack.push(1);
		Assert.assertEquals(1, stack.size());
		Assert.assertEquals(1, stack.min());
		Assert.assertEquals(1, stack.pop());		
		Assert.assertEquals(0, stack.size());
		
		
		stack.push(5);
		stack.push(6);
		Assert.assertEquals(2, stack.size());
		Assert.assertEquals(5, stack.min());
		Assert.assertEquals(6, stack.pop());		
		Assert.assertEquals(1, stack.size());
		
		
	}

}
