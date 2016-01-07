package com.ctci.chap2.lists;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class SingleLinkedList<E extends Comparable<E>> implements List<E> {

	private Node<E> header = null;
	private Node<E> tail = null;
	private int size = 0;

	public SingleLinkedList() {
		Node<E> dummyNode = new Node<E>();
		header = tail = dummyNode;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public List<E> add(E element) {
		Node<E> node = new Node<E>(element);
		tail.next = node;
		tail = node;
		size++;
		return this;
	}

	@Override
	public E get(int index) {
		if ((index < 0) || (index >= size)) {
			throw new IndexOutOfBoundsException("Index: " + index + ", "
					+ "Size: " + size);
		}
		Node<E> pointer = header;
		int i = 0;
		while (i <= index) {
			pointer = pointer.next;
			i++;
		}
		return pointer.data;
	}

	@Override
	public boolean isEmpty() {
		return (size <= 0);
	}

	@Override
	public List<E> add(int index, E element) {
		if ((index < 0) || (index > size)) {
			throw new IndexOutOfBoundsException("Index: " + index + ", "
					+ "Size: " + size);
		}
		Node<E> pointer = header;
		int i = 0;
		while (i < index) {
			pointer = pointer.next;
			i++;
		}
		Node<E> node = new Node<E>(element);
		node.next = pointer.next;
		pointer.next = node;
		size++;
		if (node.next == null) {
			tail = node;
		}
		return this;
	}

	@Override
	public String toString() {
		if (header.next == null) {
			return "";
		}
		Node<E> temp = header.next;
		StringBuilder str = new StringBuilder();
		str.append("[");
		while (temp != null) {
			str.append(temp.data).append(", ");
			temp = temp.next;
		}
		str.delete(str.length() - 2, str.length() - 1);
		str.append("]");
		return str.toString();
	}

	@Override
	public E remove(int index) {
		if ((index < 0) || (index >= size)) {
			throw new IndexOutOfBoundsException("Index: " + index + ", "
					+ "Size: " + size);
		}
		Node<E> current = header;
		Node<E> previous = header;
		int i = 0;
		while (i <= index) {
			previous = current;
			current = current.next;
			i++;
		}
		E data = current.data;
		previous.next = current.next;
		size--;
		return data;
	}

	@Override
	public void display() {
		System.out.println(toString());

	}

	@Override
	public boolean contains(E element) {
		return indexOf(element) >= 0;
	}

	@Override
	public int indexOf(E element) {
		Node<E> pointer = header.next;
		if (element != null) {
			for (int i = 0; i < size; i++) {
				if (pointer.data.equals(element)) {
					return i;
				}
				pointer = pointer.next;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (pointer.data == element) {
					return i;
				}
				pointer = pointer.next;
			}
		}
		return -1;
	}

	/**
	 * Write code to remove duplicates from an unsorted linked list.
	 */
	@Override
	public void removeDuplicates() {
		Set<E> set = new HashSet<E>();
		Node<E> current = header.next;
		Node<E> previous = header;
		while (current != tail) {
			if (set.contains(current.data)) {
				previous.next = current.next;
				size--;
			} else {
				set.add(current.data);
				previous = current;
			}
			current = current.next;
		}
		if (set.contains(current.data)) {
			previous.next = null;
			tail = previous;
		}
	}

	/**
	 * Implement an algorithm to find the nth to last element of a singly linked
	 * list.
	 */
	@Override
	public E findTheElementFromEnd(int offset) {

		if (offset < 1) {
			throw new RuntimeException("Offset " + offset
					+ " is lees than one ");
		}
		Node<E> pointer = header.next;
		for (int i = 1; i < offset && pointer != null; i++, pointer = pointer.next) {

		}
		if (pointer == null) {
			throw new RuntimeException("List size is less than " + offset);
		}

		Node<E> pointer2 = header.next;
		while (pointer.next != null) {
			pointer2 = pointer2.next;
			pointer = pointer.next;
		}

		return pointer2.data;

	}

	/**
	 * Implement an algorithm to delete a node in the middle of a single linked
	 * list, given only access to that node.
	 */
	@Override
	public void deleteElementInMiddle(E data) {
		Node<E> node = nodeOf(data);
		node.data = node.next.data;
		node.next = node.next.next;
	}

	@Override
	public void partitionListAround(E data) {

		if (header.next == null) {
			throw new RuntimeException("List is Empty");
		}
		if (header.next.next == null) {
			return;
		}
		Node<E> beforeListHead = new Node<E>();
		Node<E> beforeListTail = beforeListHead;
		Node<E> afterListHead = new Node<E>();
		Node<E> afterListTail = afterListHead;
		Node<E> p = header.next;
		Node<E> t = null;
		while (p != null) {
			t = p;
			p = p.next;
			t.next = null;
			if (t.data.compareTo(data) < 0) {
				beforeListTail.next = t;
				beforeListTail = t;
			} else if (t.data.compareTo(data) > 0) {
				afterListTail.next = t;
				afterListTail = t;
			} else {
				t.next = afterListHead.next;
				afterListHead.next = t;
				if (afterListHead == afterListTail) {
					afterListTail = t;
				}
			}
		}
		if (beforeListHead.next != null && afterListHead.next != null) {
			header.next = beforeListHead.next;
			beforeListTail.next = afterListHead.next;
			tail = afterListTail;
		} else if (beforeListHead.next == null && afterListHead.next != null) {
			header.next = afterListHead.next;
			tail = afterListTail;
		} else if (beforeListHead.next != null && afterListHead.next == null) {
			header.next = beforeListHead.next;
			tail = afterListTail;
		}

		beforeListHead = null;
		beforeListTail = null;
		afterListHead = null;
		afterListTail = null;

	}

	@Override
	public boolean isPalindrome() {

		if (header.next == null || header.next.next == null) {
			return true;
		}
		Node<E> p = header.next;
		int size = 0;
		while (p != null) {
			size++;
			p = p.next;
		}
		int firstHalfEnd = size / 2;
		int secondHalfStart = 0;
		if (size % 2 == 0) {
			secondHalfStart = firstHalfEnd + 1;
		} else {
			secondHalfStart = firstHalfEnd + 2;
		}
		p = header.next;
		int k = 1;
		Stack<E> stack = new Stack<E>();
		while (k <= size) {
			if (k <= firstHalfEnd) {
				stack.push(p.data);
			} else if (k >= secondHalfStart) {
				E v = stack.pop();
				if (!v.equals(p.data)) {
					return false;
				}
			}
			p = p.next;
			k++;
		}
		return true;
	}

	public Node<E> getHeader() {
		return header;
	}

	public Node<E> getTail() {
		return tail;
	}

	private Node<E> nodeOf(E element) {
		Node<E> pointer = header.next;
		if (element != null) {
			for (int i = 0; i < size; i++) {
				if (pointer.data.equals(element)) {
					return pointer;
				}
				pointer = pointer.next;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (pointer.data == element) {
					return pointer;
				}
				pointer = pointer.next;
			}
		}
		return null;
	}

	public static class Node<E> {
		E data;
		Node<E> next;

		public Node() {
			this.data = null;
			this.next = null;
		}

		public Node(E data) {
			this.data = data;
			this.next = null;

		}

		public E getData() {
			return data;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setData(E data) {
			this.data = data;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

	}

}
