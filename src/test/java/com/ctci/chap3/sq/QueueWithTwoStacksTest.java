package com.ctci.chap3.sq;

import org.junit.Assert;
import org.junit.Test;

public class QueueWithTwoStacksTest {

	@Test
	public void test() {

		QueueWithTwoStacks queue = new QueueWithTwoStacks();
		Assert.assertEquals(0, queue.size());
		queue.add(1);
		Assert.assertEquals(1, queue.size());
		Assert.assertEquals(1, queue.delete());
		Assert.assertEquals(0, queue.size());
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		Assert.assertEquals(5, queue.size());
		Assert.assertEquals(1, queue.delete());
		Assert.assertEquals(4, queue.size());
		queue.add(6);
		queue.add(7);
		queue.add(8);
		queue.add(9);
		queue.add(10);
		Assert.assertEquals(9, queue.size());
		Assert.assertEquals(2, queue.delete());

		
		Assert.assertEquals(8, queue.size());
		Assert.assertEquals(3, queue.delete());

	}

}
