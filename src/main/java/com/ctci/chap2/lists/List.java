/**
 * 
 */
package com.ctci.chap2.lists;

import com.ctci.chap2.lists.SingleLinkedList.Node;

/**
 * @author sampath
 * 
 */
public interface List<E extends Comparable<E>> {
	public List<E> add(E element);

	public List<E>  add(int index, E element);

	public E get(int index);

	public boolean isEmpty();

	public E remove(int index);

	public void display();

	public boolean contains(E element);

	public int indexOf(E element);

	public int getSize();

	public void removeDuplicates();
	
	public E findTheElementFromEnd(int offset);
	
	public void deleteElementInMiddle(E data);
	
	public void partitionListAround(E data);
	
	public boolean isPalindrome();
	
	public Node<E> getHeader();
	
	public Node<E> getTail();
}
