package com.ctci.chap4.trees;

public abstract class AbstractTree<E extends Comparable<E>> implements Tree<E> {

	@Override
	public boolean isExternal(Position<E> position) throws IllegalArgumentException {
		return numChildren(position) == 0;
	}

	@Override
	public boolean isInernal(Position<E> position) throws IllegalArgumentException {
		return numChildren(position) > 0;
	}

	@Override
	public boolean isRoot(Position<E> position) throws IllegalArgumentException {
		return position == root();
	}

	@Override
	public int depth(Position<E> position) {
		if (isRoot(position)) {
			return 0;
		}
		return 1 + depth(parent(position));

	}

	@Override
	public int height(Position<E> position) {
		if (position == null) {
			return 0;
		}
		int height = 1;

		for (Position<E> c : children(position)) {
			height = Math.max(height, 1 + height(c));
		}
		return height;
	}

}
