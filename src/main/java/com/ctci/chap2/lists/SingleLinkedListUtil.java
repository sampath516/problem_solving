package com.ctci.chap2.lists;

import com.ctci.chap2.lists.SingleLinkedList.Node;

public class SingleLinkedListUtil {

	public static List<Integer> sum(List<Integer> list1, List<Integer> list2) {
		List<Integer> sumList = new SingleLinkedList<Integer>();
		Node<Integer> list1Pointer = list1.getHeader().next;
		Node<Integer> list2Pointer = list2.getHeader().next;
		int sum = 0;
		int temp = 0;
		boolean flag = false;
		while (list1Pointer != null && list2Pointer != null) {
			sum = list1Pointer.getData() + list2Pointer.getData();
			flag = false;
			if (sum >= 10) {
				sum = sum % 10;
				flag = true;
			}
			sumList.add(sum + temp);
			temp = (flag) ? 1 :0;
			list1Pointer = list1Pointer.next;
			list2Pointer = list2Pointer.next;
		}

		if (list1Pointer == null && list2Pointer != null) {
			sum = list2Pointer.getData() + temp;
			add(sumList, sum);
		} else if (list1Pointer != null && list2Pointer == null) {
			sum = list1Pointer.getData() + temp;
			add(sumList, sum);
		} else if (temp == 1) {
			sumList.add(1);
		}
		return sumList;
	}

	private static void add(List<Integer> list, int sum) {
		if (sum == 10) {
			list.add(0);
			list.add(1);
		} else {
			list.add(sum);
		}
	}
}
