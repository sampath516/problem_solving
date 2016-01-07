package com.ctci.chap4.trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LinkedBinaryTree<E extends Comparable<E>> extends AbstractBinaryTree<E> {

	protected Position<E> root;

	protected int size;

	protected static class Node<E> implements Position<E> {

		Node<E> parent;

		Node<E> left;

		Node<E> right;

		E element;
		
		int data;

		public Node(Node<E> parent, Node<E> left, Node<E> right, E element, int data) {
			this.element = element;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}

		@Override
		public E getElement() {
			return element;
		}
		
		@Override
		public int getData() {
			return data;
		}

		public Node<E> getParent() {
			return parent;
		}

		public void setParent(Node<E> parent) {
			this.parent = parent;
		}

		public Node<E> getLeft() {
			return left;
		}

		public void setLeft(Node<E> left) {
			this.left = left;
		}

		public Node<E> getRight() {
			return right;
		}

		public void setRight(Node<E> right) {
			this.right = right;
		}

		public void setElement(E element) {
			this.element = element;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((element == null) ? 0 : element.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (element == null) {
				if (other.element != null) {
					return false;
				}
			} else if (!element.equals(other.element)) {
				return false;
			}

			return true;
		}

	}

	protected Node<E> createNode(Node<E> parent, Node<E> left, Node<E> right, E element) {
		return new Node<E>(parent, left, right, element, 0);
	}
	
	protected Node<E> createNode(Node<E> parent, Node<E> left, Node<E> right, E element, int data) {
		return new Node<E>(parent, left, right, element, data);
	}

	protected Node<E> validate(Position<E> position) throws IllegalArgumentException {
		if (!(position instanceof Node<?>)) {
			throw new IllegalArgumentException("Not a valid Position type");
		}

		Node<E> node = (Node<E>) position;
		if (node.parent == node) {
			throw new IllegalArgumentException("Position is no longer in three");
		}

		return node;
	}

	@Override
	public Position<E> left(Position<E> position) throws IllegalArgumentException {
		Node<E> node = validate(position);
		return node.left;
	}

	@Override
	public Position<E> right(Position<E> position) throws IllegalArgumentException {
		Node<E> node = validate(position);
		return node.right;
	}

	@Override
	public Position<E> root() {
		return root;
	}

	@Override
	public Position<E> parent(Position<E> position) throws IllegalArgumentException {
		Node<E> node = validate(position);
		return node.parent;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Position<E>> poistions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> addRoot(E element) throws IllegalStateException {
		if (!isEmpty()) {
			throw new IllegalStateException("Tree is not empty");
		}
		root = createNode(null, null, null, element);
		size++;
		return root;
	}

	@Override
	public Position<E> addLeft(Position<E> position, E element) throws IllegalArgumentException {
		Node<E> node = validate(position);
		if (node.left != null) {
			throw new IllegalArgumentException("position already has a left child");
		}
		Node<E> left = createNode(node, null, null, element);
		node.left = left;
		return left;
	}

	@Override
	public Position<E> addRight(Position<E> position, E element) throws IllegalArgumentException {
		Node<E> node = validate(position);
		if (node.right != null) {
			throw new IllegalArgumentException("position already has a left child");
		}
		Node<E> right = createNode(node, null, null, element);
		node.right = right;
		return right;
	}

	@Override
	public void attach(Position<E> position, Tree<E> left, Tree<E> right) throws IllegalArgumentException {
		// TODO Auto-generated method stub

	}

	@Override
	public E set(Position<E> position, E newValue) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(Position<E> position) throws IllegalArgumentException {
		Node<E> node = validate(position);
		if (numChildren(node) == 2) {
			throw new IllegalArgumentException("position has two childrens");
		}
		Node<E> parent = node.parent;
		Node<E> child = node.left != null ? node.left : node.right;
		if (child != null) {
			child.parent = parent;
		}
		if (node == root) {
			root = child;
		} else {
			if (left(parent) == node) {
				parent.left = child;
			} else {
				parent.right = child;
			}
		}
		size--;
		E temp = node.getElement();
		node.parent = node;
		node.left = null;
		node.right = null;
		node.element = null;

		return temp;
	}

	@Override
	public List<Position<E>> inOrder() {
		java.util.List<Position<E>> snapshot = new ArrayList<Position<E>>();
		if (!isEmpty()) {
			inOrderSubTree(root, snapshot);
		}
		return snapshot;
	}

	private void inOrderSubTree(Position<E> position, java.util.List<Position<E>> snapshot) {
		if (left(position) != null) {
			inOrderSubTree(left(position), snapshot);
		}
		snapshot.add(position);
		if (right(position) != null) {
			inOrderSubTree(right(position), snapshot);
		}
	}

	@Override
	public List<Position<E>> preOrder() {
		java.util.List<Position<E>> snapshot = new ArrayList<Position<E>>();
		if (!isEmpty()) {
			preOrderSubTree(root, snapshot);
		}
		return snapshot;
	}

	private void preOrderSubTree(Position<E> position, List<Position<E>> snapshot) {
		snapshot.add(position);
		if (left(position) != null) {
			preOrderSubTree(left(position), snapshot);
		}
		if (right(position) != null) {
			preOrderSubTree(right(position), snapshot);
		}
	}

	@Override
	public List<Position<E>> postOrder() {
		java.util.List<Position<E>> snapshot = new ArrayList<Position<E>>();
		if (!isEmpty()) {
			postOrderSubTree(root, snapshot);
		}
		return snapshot;
	}

	private void postOrderSubTree(Position<E> position, List<Position<E>> snapshot) {
		if (left(position) != null) {
			postOrderSubTree(left(position), snapshot);
		}
		if (right(position) != null) {
			postOrderSubTree(right(position), snapshot);
		}
		snapshot.add(position);
	}

	@Override
	public boolean isBalanced() {
		if (isEmpty()) {
			return true;
		}
		return heightIfBalanced(root) != -1 && isBalancedSubTree(root);
	}

	@Override
	public boolean isBinarySearchTree() {
		if (isEmpty()) {
			return true;
		}
		return isBinarySearchTree_v5(root, null) != null;
	}

	@Override
	public boolean isBinarySearchTree_v1() {
		if (isEmpty()) {
			return true;
		}
		return isBinarySearchTree_v4(root, null) != null;
	}

	private Position<E> isBinarySearchTree_v5(Position<E> position, Position<E> previous) {

		Position<E> newPrevious = previous;
		if (left(position) != null) {
			newPrevious = isBinarySearchTree_v4(left(position), newPrevious);
			if (newPrevious == null) {
				return newPrevious;
			}
		}
		// Position<E> parent = parent(position);
		if (newPrevious != null) {
			// if (parent == newPrevious) {
			if (newPrevious.getElement().compareTo(position.getElement()) >= 0) {
				return null;
			}
			// } else {
			// if (newPrevious.getElement().compareTo(position.getElement()) ==
			// 1) {
			// return null;
			// }
			// }
		}
		newPrevious = position;

		if (right(position) != null) {
			newPrevious = isBinarySearchTree_v4(right(position), newPrevious);
			if (newPrevious == null) {
				return newPrevious;
			}
		}
		return newPrevious;
	}

	private Position<E> isBinarySearchTree_v4(Position<E> position, Position<E> previous) {

		Position<E> newPrevious = previous;
		if (left(position) != null) {
			newPrevious = isBinarySearchTree_v4(left(position), newPrevious);
			if (newPrevious == null) {
				return newPrevious;
			}
		}
		Position<E> parent = parent(position);
		if (newPrevious != null) {
			if (parent == newPrevious) {
				if (newPrevious.getElement().compareTo(position.getElement()) >= 0) {
					return null;
				}
			} else {
				if (newPrevious.getElement().compareTo(position.getElement()) == 1) {
					return null;
				}
			}
		}
		newPrevious = position;

		if (right(position) != null) {
			newPrevious = isBinarySearchTree_v4(right(position), newPrevious);
			if (newPrevious == null) {
				return newPrevious;
			}
		}
		return newPrevious;
	}

	private boolean isBalancedSubTree(Position<E> position) {
		if (position == null) {
			return true;
		}
		int lh = height(left(position));
		int rh = height(right(position));
		if (Math.abs(lh - rh) <= 1) {
			return isBalancedSubTree(left(position)) && isBalancedSubTree(right(position));
		}
		return false;
	}

	private int heightIfBalanced(Position<E> position) {
		if (position == null) {
			return 0;
		}
		int leftChildHeight = heightIfBalanced(left(position));
		if (leftChildHeight == -1) {
			return -1;
		}

		int rightChildHeight = heightIfBalanced(right(position));
		if (rightChildHeight == -1) {
			return -1;
		}

		if (Math.abs(leftChildHeight - rightChildHeight) > 1) {
			return -1;
		} else {
			return Math.max(leftChildHeight, rightChildHeight) + 1;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int height() {
		return height(root);
	}

	@Override
	public List<List<Position<E>>> elementsByDepth() {

		List<List<Position<E>>> elementsByDepth = new ArrayList<List<Position<E>>>();
		elementsByDepthInternal(root, 0, elementsByDepth);
		return elementsByDepth;
	}

	private void elementsByDepthInternal(Position<E> position, int depth, List<List<Position<E>>> elementsByDepth) {
		if (elementsByDepth.size() < depth + 1) {
			List<Position<E>> positionList = new ArrayList<Position<E>>();
			elementsByDepth.add(positionList);
		}
		elementsByDepth.get(depth).add(position);
		Node<E> node = (Node<E>) position;
		if (node.left != null) {
			elementsByDepthInternal(node.left, depth + 1, elementsByDepth);
		}
		if (node.right != null) {
			elementsByDepthInternal(node.right, depth + 1, elementsByDepth);
		}

	}

	@Override
	public boolean subTree(BinaryTree<E> subTree) {
		if (subTree == null) {
			return false;
		}
		if (isEmpty() && subTree.isEmpty()) {
			return true;
		}
		if (size() < subTree.size()) {
			return false;
		}

		List<Position<E>> inOrderList = inOrder();
		List<Position<E>> preOrderList = preOrder();
		List<Position<E>> subTreeInOrderList = subTree.inOrder();
		List<Position<E>> subTreePreOrderList = subTree.preOrder();
		return (isSubList(inOrderList, subTreeInOrderList) && isSubList(preOrderList, subTreePreOrderList));
	}

	private boolean isSubList(List<Position<E>> s, List<Position<E>> t) {
		int i = 0, j = 0;
		for (; i < s.size() && j < t.size(); i++, j++) {
			if (!s.get(i).getElement().equals(t.get(j).getElement())) {
				j = -1;
			}
		}
		if (j < t.size()) {
			return false;
		}
		return true;
	}

	@Override
	public Set<List<Position<E>>> pathsWithSum(int sum) {

		Set<List<Position<E>>> paths = new HashSet<List<Position<E>>>();

		return null;
	}

	private Set<List<Position<E>>> pathsWithSum(Node<E> position, Set<List<Position<E>>> paths, List<Position<E>> path, int sum) {
		if (path == null) {
			path = new ArrayList<Position<E>>();
		}
		path.add(position);
		sum =  sum+position.getData();
		for(Position<E> p : path){
			
		}
		if(position.left != null){
		
		}
		
		return null;
	}

}
