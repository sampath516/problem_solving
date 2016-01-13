package com.ci.chap3.ds.lists;

import java.util.ArrayList;

import com.ctci.chap2.lists.List;
import com.ctci.chap2.lists.SingleLinkedList.Node;

public class ListUtil {

	/**
	 * <b>Question 13:</b> Please implement a function to print a list from its
	 * tail to head.
	 */
	public static java.util.List<Integer> printTailToHeadRecursive(List<Integer> singleLinedList) {
		java.util.List<Integer> snapshot = new ArrayList<Integer>();
		if (singleLinedList == null || singleLinedList.isEmpty()) {
			return snapshot;
		}

		printTailToHeadRecursive(singleLinedList.getHeader().getNext(), snapshot);
		return snapshot;
	}

	private static void printTailToHeadRecursive(Node<Integer> node, java.util.List<Integer> snapshot) {
		if (node == null) {
			return;
		}
		printTailToHeadRecursive(node.getNext(), snapshot);
		snapshot.add(node.getData());

	}

	/**
	 * <b>Question 16:</b> How do you check whether there is a loop in a linked
	 * list? For example, the list in Figure 3-9 contains a loop.
	 * 
	 * Floyd’s Cycle-Finding Algorithm
	 */
	public static Node<Integer> detectLoopInSingleLinkedList(Node<Integer> head) {

		if (head == null || head.getNext() == null) {
			return null;
		}

		Node<Integer> slowPointer = head;
		Node<Integer> fastPointer = head;

		while (fastPointer != null ) {
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext();
			if(fastPointer != null){
				fastPointer = fastPointer.getNext();
			}			
			if (slowPointer == fastPointer) {
				break;
			}
		}
		return fastPointer;
	}

}
