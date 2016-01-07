package com.ctci.chap2.lists;

import org.junit.Assert;
import org.junit.Test;

public class SingleLinkedListTest {
	
	public void testAddElementAtIndex(){
		List<Integer> list = new SingleLinkedList<>();
		list.add(0, 1).add(1, 2).add(3).add(0, 0).add(4, 4).add(5); 
		System.out.println(list);
		
	}
	@Test
	public void testSumLinkedLists(){
		List<Integer> list1 = new SingleLinkedList<>();
		List<Integer> list2 = new SingleLinkedList<>();
		list1.add(1);
		List<Integer> sumList =SingleLinkedListUtil.sum(list1, list2);
		Assert.assertEquals(1, sumList.getSize());
		Assert.assertEquals(1, sumList.get(0).intValue());
		
		list1 = new SingleLinkedList<>();
		list2 = new SingleLinkedList<>();
		list1.add(9);
		list2.add(9);
		sumList =SingleLinkedListUtil.sum(list1, list2);
		Assert.assertEquals(2, sumList.getSize());
		Assert.assertEquals(1, sumList.get(1).intValue());
		Assert.assertEquals(8, sumList.get(0).intValue());
		
		list1 = new SingleLinkedList<>();
		list2 = new SingleLinkedList<>();
		list1.add(9).add(9);
		list2.add(9).add(9);
		sumList =SingleLinkedListUtil.sum(list1, list2);
		Assert.assertEquals(3, sumList.getSize());
		Assert.assertEquals(1, sumList.get(2).intValue());
		Assert.assertEquals(9, sumList.get(1).intValue());
		Assert.assertEquals(8, sumList.get(0).intValue());

	}

}
