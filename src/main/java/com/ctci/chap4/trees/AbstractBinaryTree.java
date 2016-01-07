package com.ctci.chap4.trees;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTree<E extends Comparable<E>> extends AbstractTree<E> implements BinaryTree<E> {

	@Override
	public Iterable<Position<E>> children(Position<E> position) throws IllegalArgumentException {
		List<Position<E>> snapshot = new ArrayList<Position<E>>();
		if (position == null) {
			return snapshot;
		}
		if (left(position) != null) {
			snapshot.add(left(position));
		}
		if (right(position) != null) {
			snapshot.add(right(position));
		}
		return snapshot;
	}

	@Override
	public int numChildren(Position<E> position) throws IllegalArgumentException {
		int count = 0;
		if (left(position) != null) {
			count++;
		}
		if (right(position) != null) {
			count++;
		}
		return count;
	}

	@Override
	public Position<E> sibling(Position<E> position) throws IllegalArgumentException {
		Position<E> parent = parent(position);
		if (left(parent) == position) {
			return right(parent);
		} else {
			return left(parent);
		}
	}

}
