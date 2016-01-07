package com.ctci.chap4.trees;

public class LinkedBinarySearchTree<E extends Comparable<E>> extends LinkedBinaryTree<E> implements BinarySearchTree<E> {

	public LinkedBinarySearchTree(E[] elements, boolean sorted) {

		if (!sorted) {
			create(elements);
		} else {
			create(elements, 0, elements.length - 1);
		}

	}

	public LinkedBinarySearchTree() {
	}

	private void create(E[] elements) {
		for (int i = 0; i < elements.length; i++) {
			addElement(elements[i]);
		}
	}

	private void create(E[] elements, int start, int end) {
		if (end - start == 0) {
			addElement(elements[start]);
			return;
		} else if (end - start == 1) {
			addElement(elements[start]);
			addElement(elements[end]);
			return;
		} else {
			int mid = (int) Math.floor((start + end) / 2);
			addElement(elements[mid]);
			create(elements, start, mid - 1);
			create(elements, mid + 1, end);
		}

	}
//
//	private Position<E> create(E[] elements, int start, int end) {
//		
//		if(start > end){
//			return null;
//		}
//		int mid = (int) Math.floor((start + end) / 2);
//		Position<E> root = null;
//		if(isEmpty()){
//			root = addRoot(elements[mid]);
//		}else{
//			root = createNode(parent, left, right, element);
//		}
//		
//
//	}

	private Position<E> add(Position<E> parent, boolean left, E element) {
		if (left) {
			return addLeft(parent, element);
		} else {
			return addRight(parent, element);
		}
	}

	@Override
	public Position<E> addElement(E element) {
		if (isEmpty()) {
			return addRoot(element);
		}
		Node<E> parent = validate(root);
		Node<E> position = parent;
		boolean isLeft = false;
		while (position != null) {
			parent = position;
			if (position.getElement().compareTo(element) < 0) {
				position = position.right;
				isLeft = false;
			} else if (position.getElement().compareTo(element) > 0) {
				position = position.left;
				isLeft = true;
			} else {
				throw new RuntimeException("Duplicate Element");
			}
		}
		if (isLeft) {
			return addLeft(parent, element);
		} else {
			return addRight(parent, element);
		}
	}

	@Override
	public Position<E> next(Position<E> position) {

		if (position == null) {
			return null;
		}
		// if (isRoot(position) && right(position) == null) {
		// return null;
		// }
		return nextInternal_v1(position);
	}

	private Position<E> nextInternal_v1(Position<E> position) {

		if (right(position) == null) {
			// If the position does not has right child, next is one of the
			// following :
			// 1. null, if position's parent is a root
			// 2. Its parent, if it is the left child of its parent
			// 3. The nearest ancestor of the position where the position
			// belongs to the the left side grand children
			if (parent(position) == null) {
				return null;
			}
			while (parent(position) != null) {
				Position<E> positionParent = parent(position);
				if (left(positionParent) == position) {
					return positionParent;
				}
				position = positionParent;
			}
			return null;
		} else {
			// If position has a right child, then the next is either the
			// right child or the left most node of the subtree, headed by
			// the right child
			Position<E> positionRightChild = right(position);
			Position<E> next = positionRightChild;
			while (left(next) != null) {
				next = left(next);
			}
			return next;
		}

	}

	private Position<E> nextInternal(Position<E> position) {

		Position<E> parent = parent(position);
		// Position is a left child of its parent
		if (left(parent) == position) {
			if (right(position) == null) {
				// If position does not has right child, its parent is the next
				// node
				return parent;
			} else {
				// If position has a right child, then the next is either the
				// right child or the left most node of the subtree, headed by
				// the right child
				Position<E> positionRightChild = right(position);
				Position<E> next = positionRightChild;
				while (left(next) != null) {
					next = left(next);
				}
				return next;
			}
			// Position is a right child of its parent
		} else if (right(parent) == position) {
			if (right(position) == null) {
				// TODO
				// If the position does not has right child, next is the parent
				// of the closest ancestor of position.
				// Ancestor should be the left child of its parent
				Position<E> positionParent = parent(position);

				while (parent(positionParent) != null && left(parent(parent(positionParent))) != parent(positionParent)) {
					positionParent = parent(positionParent);
				}
				if (parent(positionParent) == null) {
					return null;
				} else {
					return parent(positionParent);
				}
			} else {
				// If position has a right child, then the next is either the
				// right child or the left most node of the subtree, headed by
				// the right child
				Position<E> positionRightChild = right(position);
				Position<E> next = positionRightChild;
				while (left(next) != null) {
					next = left(next);
				}
				return next;
			}
		} else {
			// Error
		}

		return null;
	}

}
