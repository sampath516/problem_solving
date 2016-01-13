package com.ci.chap3.ds.lists;

import org.junit.Assert;
import org.junit.Test;

import com.ctci.chap2.lists.List;
import com.ctci.chap2.lists.SingleLinkedList;
import com.ctci.chap2.lists.SingleLinkedList.Node;

public class ListUtilTest {

	@Test
	public void testPrintTailToHeadRecursive() {
		List<Integer> singleLinedList = null;
		java.util.List<Integer> snapshot = ListUtil.printTailToHeadRecursive(singleLinedList);
		Assert.assertEquals(0, snapshot.size());

		singleLinedList = new SingleLinkedList<Integer>();
		snapshot = ListUtil.printTailToHeadRecursive(singleLinedList);
		Assert.assertEquals(0, snapshot.size());

		singleLinedList = new SingleLinkedList<Integer>();
		singleLinedList.add(1);
		snapshot = ListUtil.printTailToHeadRecursive(singleLinedList);
		Assert.assertEquals(1, snapshot.size());

		singleLinedList = new SingleLinkedList<Integer>();
		singleLinedList.add(1).add(2);
		snapshot = ListUtil.printTailToHeadRecursive(singleLinedList);
		Assert.assertEquals(2, snapshot.size());
		Assert.assertEquals(2, snapshot.get(0).intValue());
		Assert.assertEquals(1, snapshot.get(1).intValue());

		singleLinedList = new SingleLinkedList<Integer>();
		singleLinedList.add(1).add(2).add(3);
		snapshot = ListUtil.printTailToHeadRecursive(singleLinedList);
		Assert.assertEquals(3, snapshot.size());
		Assert.assertEquals(3, snapshot.get(0).intValue());
		Assert.assertEquals(2, snapshot.get(1).intValue());
		Assert.assertEquals(1, snapshot.get(2).intValue());

	}

	@Test
	public void testDetectLoopInSingleLinkedList() {
		List<Integer> singleLinedList = new SingleLinkedList<Integer>();
		Node<Integer> node = ListUtil.detectLoopInSingleLinkedList(singleLinedList.getHeader().getNext());
		Assert.assertNull(node);

		singleLinedList = new SingleLinkedList<Integer>();
		singleLinedList.add(1);
		node = ListUtil.detectLoopInSingleLinkedList(singleLinedList.getHeader().getNext());
		Assert.assertNull(node);

		singleLinedList = new SingleLinkedList<Integer>();
		singleLinedList.add(1).add(2);
		node = ListUtil.detectLoopInSingleLinkedList(singleLinedList.getHeader().getNext());
		Assert.assertNull(node);

		singleLinedList = new SingleLinkedList<Integer>();
		singleLinedList.add(1).add(2).add(3);
		node = ListUtil.detectLoopInSingleLinkedList(singleLinedList.getHeader().getNext());
		Assert.assertNull(node);

		singleLinedList = new SingleLinkedList<Integer>();
		singleLinedList.add(1).add(2).add(3).add(4);
		node = ListUtil.detectLoopInSingleLinkedList(singleLinedList.getHeader().getNext());
		Assert.assertNull(node);

		singleLinedList = new SingleLinkedList<Integer>();
		singleLinedList.add(1);
		Node<Integer> node1 = singleLinedList.getHeader().getNext();
		node1.setNext(node1);
		node = ListUtil.detectLoopInSingleLinkedList(singleLinedList.getHeader().getNext());
		Assert.assertNotNull(node);

		singleLinedList = new SingleLinkedList<Integer>();
		singleLinedList.add(1).add(2);
		Node<Integer> node2 = singleLinedList.getHeader().getNext().getNext();
		node2.setNext(singleLinedList.getHeader().getNext());
		node = ListUtil.detectLoopInSingleLinkedList(singleLinedList.getHeader().getNext());
		Assert.assertNotNull(node);

		singleLinedList = new SingleLinkedList<Integer>();
		singleLinedList.add(1).add(2).add(3).add(4).add(5).add(6).add(7).add(8);
		Node<Integer> node8 = singleLinedList.getHeader().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext();
		node8.setNext(singleLinedList.getHeader().getNext().getNext().getNext());
		node = ListUtil.detectLoopInSingleLinkedList(singleLinedList.getHeader().getNext());
		Assert.assertNotNull(node);

	}

}
