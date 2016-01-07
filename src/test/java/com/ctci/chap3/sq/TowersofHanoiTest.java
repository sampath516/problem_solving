package com.ctci.chap3.sq;

import org.junit.Assert;
import org.junit.Test;

public class TowersofHanoiTest {

	@Test
	public void testForOneAndTwoDisks() {
		TowersofHanoi toh = new TowersofHanoi(1, "A", "B", "C");
		Assert.assertEquals("A-C*", toh.solution());

		toh = new TowersofHanoi(2, "A", "B", "C");
		Assert.assertEquals("A-B*A-C*B-C*", toh.solution());
	}

	@Test
	public void test() {
		TowersofHanoi toh = new TowersofHanoi(3, "A", "B", "C");
		Assert.assertEquals("A-C*A-B*C-B*A-C*B-A*B-C*A-C*", toh.solution());

	}

}
