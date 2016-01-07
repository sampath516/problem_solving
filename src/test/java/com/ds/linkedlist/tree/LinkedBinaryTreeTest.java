package com.ds.linkedlist.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import org.junit.Assert;
import org.junit.Test;

import com.ctci.chap4.trees.BinarySearchTree;
import com.ctci.chap4.trees.BinaryTree;
import com.ctci.chap4.trees.LinkedBinarySearchTree;
import com.ctci.chap4.trees.LinkedBinaryTree;
import com.ctci.chap4.trees.Position;

public class LinkedBinaryTreeTest {

	@Test
	public void testInOrder() {
		Integer[] elements = new Integer[] { 100, 70, 120, 130, 110, 50, 60 };
		BinaryTree<Integer> tree = constructCompleteBinaryTree(Arrays.asList(elements));
		Position<Integer>[] inOrderArray = new Position[7];
		inOrderArray = tree.inOrder().toArray(inOrderArray);
		Integer[] expectedInOrderArray = new Integer[] { 130, 70, 110, 100, 50, 120, 60 };
		Integer[] inOrderIntArray = new Integer[7];
		Assert.assertArrayEquals(expectedInOrderArray, transfrom(inOrderArray, inOrderIntArray));
	}

	@Test
	public void testPreOrder() {
		Integer[] elements = new Integer[] { 100, 70, 120, 130, 110, 50, 60 };
		BinaryTree<Integer> tree = constructCompleteBinaryTree(Arrays.asList(elements));
		Position<Integer>[] preOrderArray = new Position[7];
		preOrderArray = tree.preOrder().toArray(preOrderArray);
		Integer[] expectedPreOrderArray = new Integer[] { 100, 70, 130, 110, 120, 50, 60 };
		Integer[] preOrderIntArray = new Integer[7];
		Assert.assertArrayEquals(expectedPreOrderArray, transfrom(preOrderArray, preOrderIntArray));
	}

	@Test
	public void testPostOrder() {
		Integer[] elements = new Integer[] { 100, 70, 120, 130, 110, 50, 60 };
		BinaryTree<Integer> tree = constructCompleteBinaryTree(Arrays.asList(elements));
		Position<Integer>[] postOrderArray = new Position[7];
		postOrderArray = tree.postOrder().toArray(postOrderArray);
		Integer[] expectedPostOrderArray = new Integer[] { 130, 110, 70, 50, 60, 120, 100 };
		Integer[] postOrderIntArray = new Integer[7];
		Assert.assertArrayEquals(expectedPostOrderArray, transfrom(postOrderArray, postOrderIntArray));
	}

	@Test
	public void testNodeDepth() {
		Integer[] elements = new Integer[] { 100, 70, 120, 130, 110, 50, 60 };
		BinaryTree<Integer> tree = constructCompleteBinaryTree(Arrays.asList(elements));
		List<Position<Integer>> inOrderList = tree.inOrder();
		Assert.assertEquals(2, tree.depth(inOrderList.get(0)));
		Assert.assertEquals(1, tree.depth(inOrderList.get(1)));
		Assert.assertEquals(2, tree.depth(inOrderList.get(2)));
		Assert.assertEquals(0, tree.depth(inOrderList.get(3)));
		Assert.assertEquals(2, tree.depth(inOrderList.get(4)));
		Assert.assertEquals(1, tree.depth(inOrderList.get(5)));
		Assert.assertEquals(2, tree.depth(inOrderList.get(6)));
	}

	@Test
	public void testNodeHeight() {
		Integer[] elements = new Integer[] { 100, 70, 120, 130, 110, 50, 60 };
		BinaryTree<Integer> tree = constructCompleteBinaryTree(Arrays.asList(elements));
		List<Position<Integer>> inOrderList = tree.inOrder();
		Assert.assertEquals(1, tree.height(inOrderList.get(0)));
		Assert.assertEquals(2, tree.height(inOrderList.get(1)));
		Assert.assertEquals(1, tree.height(inOrderList.get(2)));
		Assert.assertEquals(3, tree.height(inOrderList.get(3)));
		Assert.assertEquals(1, tree.height(inOrderList.get(4)));
		Assert.assertEquals(2, tree.height(inOrderList.get(5)));
		Assert.assertEquals(1, tree.height(inOrderList.get(6)));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testIsBalanced() {
		Integer[] elements = new Integer[] { 100, 70, 120, 130, 110, 50, 60 };
		BinaryTree<Integer> tree = constructCompleteBinaryTree(Arrays.asList(elements));
		Assert.assertTrue(tree.isBalanced());

		TestNode<Integer>[] elements1 = new TestNode[] { node(100, 3), node(20, 3), node(50, 1), node(30, 2),
				node(25, 0), node(70, 3), node(40, 0), node(90, 0), node(80, 0), };
		tree = constructBinaryTree(Arrays.asList(elements1));
		Assert.assertFalse(tree.isBalanced());

		elements1 = new TestNode[] { node(100, 0) };
		tree = constructBinaryTree(Arrays.asList(elements1));
		Assert.assertTrue(tree.isBalanced());

		elements1 = new TestNode[] { node(100, 1), node(20, 0) };
		tree = constructBinaryTree(Arrays.asList(elements1));
		Assert.assertTrue(tree.isBalanced());

		elements1 = new TestNode[] { node(100, 2), node(20, 0) };
		tree = constructBinaryTree(Arrays.asList(elements1));
		Assert.assertTrue(tree.isBalanced());

		elements1 = new TestNode[] { node(100, 3), node(20, 0), node(50, 0) };
		tree = constructBinaryTree(Arrays.asList(elements1));
		Assert.assertTrue(tree.isBalanced());

		elements1 = new TestNode[] { node(100, 1), node(20, 1), node(30, 0) };
		tree = constructBinaryTree(Arrays.asList(elements1));
		Assert.assertFalse(tree.isBalanced());

		elements1 = new TestNode[] { node(100, 2), node(20, 2), node(30, 0) };
		tree = constructBinaryTree(Arrays.asList(elements1));
		Assert.assertFalse(tree.isBalanced());

	}

	@SuppressWarnings("unchecked")
	@Test
	public void testIsBinarySearchTree() {
		TestNode<Integer>[] elements = new TestNode[] { node(100, 0) };
		BinaryTree<Integer> tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertTrue(tree.isBinarySearchTree());

		elements = new TestNode[] { node(100, 1), node(90, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertTrue(tree.isBinarySearchTree());

		elements = new TestNode[] { node(100, 1), node(100, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertFalse(tree.isBinarySearchTree());

		elements = new TestNode[] { node(100, 1), node(101, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertFalse(tree.isBinarySearchTree());

		elements = new TestNode[] { node(60, 2), node(70, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertTrue(tree.isBinarySearchTree());

		elements = new TestNode[] { node(70, 2), node(60, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		print(tree.inOrder());
		Assert.assertFalse(tree.isBinarySearchTree());

		elements = new TestNode[] { node(70, 2), node(70, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		print(tree.inOrder());
		Assert.assertFalse(tree.isBinarySearchTree());

		elements = new TestNode[] { node(100, 3), node(90, 0), node(110, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertTrue(tree.isBinarySearchTree());

		elements = new TestNode[] { node(100, 3), node(100, 0), node(110, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertFalse(tree.isBinarySearchTree());

		elements = new TestNode[] { node(100, 3), node(100, 0), node(100, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertFalse(tree.isBinarySearchTree());

		elements = new TestNode[] { node(100, 1), node(90, 1), node(80, 1), node(70, 1), node(60, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertTrue(tree.isBinarySearchTree());

		elements = new TestNode[] { node(100, 1), node(90, 1), node(80, 1), node(70, 1), node(71, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertFalse(tree.isBinarySearchTree());

		elements = new TestNode[] { node(60, 2), node(70, 2), node(80, 2), node(90, 2), node(100, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertTrue(tree.isBinarySearchTree());

		elements = new TestNode[] { node(60, 2), node(70, 2), node(80, 2), node(90, 2), node(90, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertFalse(tree.isBinarySearchTree());

		elements = new TestNode[] { node(100, 3), node(80, 3), node(110, 3), node(70, 0), node(90, 0), node(105, 0),
				node(115, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertTrue(tree.isBinarySearchTree());

		elements = new TestNode[] { node(100, 3), node(80, 3), node(110, 3), node(70, 0), node(90, 0), node(91, 0),
				node(115, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertFalse(tree.isBinarySearchTree());

		elements = new TestNode[] { node(100, 3), node(80, 3), node(110, 3), node(70, 0), node(101, 0), node(105, 0),
				node(115, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertFalse(tree.isBinarySearchTree());

		elements = new TestNode[] { node(100, 3), node(80, 3), node(110, 3), node(70, 0), node(101, 0), node(91, 0),
				node(115, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertFalse(tree.isBinarySearchTree());

	}
	@SuppressWarnings("unchecked")
	@Test
	public void testIsBinarySearchTree_v1() {
		TestNode<Integer>[] elements = new TestNode[] { node(100, 0) };
		BinaryTree<Integer> tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertTrue(tree.isBinarySearchTree_v1());

		elements = new TestNode[] { node(100, 1), node(90, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertTrue(tree.isBinarySearchTree_v1());

		elements = new TestNode[] { node(100, 1), node(100, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertTrue(tree.isBinarySearchTree_v1());

		elements = new TestNode[] { node(100, 1), node(101, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertFalse(tree.isBinarySearchTree_v1());

		elements = new TestNode[] { node(60, 2), node(70, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertTrue(tree.isBinarySearchTree_v1());

		elements = new TestNode[] { node(70, 2), node(60, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		print(tree.inOrder());
		Assert.assertFalse(tree.isBinarySearchTree_v1());

		elements = new TestNode[] { node(70, 2), node(70, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		print(tree.inOrder());
		Assert.assertFalse(tree.isBinarySearchTree_v1());

		elements = new TestNode[] { node(100, 3), node(90, 0), node(110, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertTrue(tree.isBinarySearchTree_v1());

		elements = new TestNode[] { node(100, 3), node(100, 0), node(110, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertTrue(tree.isBinarySearchTree_v1());

		elements = new TestNode[] { node(100, 3), node(100, 0), node(100, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertFalse(tree.isBinarySearchTree_v1());

		elements = new TestNode[] { node(100, 1), node(90, 1), node(80, 1), node(70, 1), node(60, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertTrue(tree.isBinarySearchTree_v1());

		elements = new TestNode[] { node(100, 1), node(90, 1), node(80, 1), node(70, 1), node(71, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertFalse(tree.isBinarySearchTree_v1());

		elements = new TestNode[] { node(60, 2), node(70, 2), node(80, 2), node(90, 2), node(100, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertTrue(tree.isBinarySearchTree_v1());

		elements = new TestNode[] { node(60, 2), node(70, 2), node(80, 2), node(90, 2), node(90, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertFalse(tree.isBinarySearchTree_v1());

		elements = new TestNode[] { node(100, 3), node(80, 3), node(110, 3), node(70, 0), node(90, 0), node(105, 0),
				node(115, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertTrue(tree.isBinarySearchTree_v1());

		elements = new TestNode[] { node(100, 3), node(80, 3), node(110, 3), node(70, 0), node(90, 0), node(91, 0),
				node(115, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertFalse(tree.isBinarySearchTree_v1());

		elements = new TestNode[] { node(100, 3), node(80, 3), node(110, 3), node(70, 0), node(101, 0), node(105, 0),
				node(115, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertFalse(tree.isBinarySearchTree_v1());

		elements = new TestNode[] { node(100, 3), node(80, 3), node(110, 3), node(70, 0), node(101, 0), node(91, 0),
				node(115, 0) };
		tree = constructBinaryTree(Arrays.asList(elements));
		Assert.assertFalse(tree.isBinarySearchTree_v1());

	}
	@SuppressWarnings("unchecked")
	@Test
	public void testNext() {
		// 100
		
		TestNode<Integer>[] elements = new TestNode[] { node(100, 0) };
		BinarySearchTree<Integer> tree = constructBinarySearchTree(Arrays.asList(elements));
		Assert.assertEquals(null, tree.next(tree.root()));
		//       100
		//   90
		elements = new TestNode[] { node(100, 1), node(90, 0) };
		tree = constructBinarySearchTree(Arrays.asList(elements));
		Position<Integer> root = tree.root();
		Position<Integer> p90 = tree.left(root); 
		Assert.assertEquals(100, tree.next(p90).getElement().intValue());
		
		//       100
		//   90
		elements = new TestNode[] { node(100, 1), node(90, 0) };
		tree = constructBinarySearchTree(Arrays.asList(elements));
		root = tree.root();
		Assert.assertEquals(null, tree.next(root));
		
        //      100
		//         120
		elements = new TestNode[] { node(100, 2), node(120, 0) };
		tree = constructBinarySearchTree(Arrays.asList(elements));
		root = tree.root();
		Position<Integer> p120 = tree.right(root); 
		Assert.assertEquals(null, tree.next(p120));
		
		//      100
		//          120
		elements = new TestNode[] { node(100, 2), node(120, 0) };
		tree = constructBinarySearchTree(Arrays.asList(elements));
		root = tree.root();
		Assert.assertEquals(120, tree.next(root).getElement().intValue());
		
        //                        100
		//                     90     120
		elements = new TestNode[] { node(100, 3), node(90, 0), node(120, 0) };
		tree = constructBinarySearchTree(Arrays.asList(elements));
		root = tree.root();
		Assert.assertEquals(100, tree.next(tree.left(root)).getElement().intValue());
		Assert.assertEquals(null, tree.next(tree.right(root)));
		Assert.assertEquals(120, tree.next(root).getElement().intValue());
		
        //                             200
		//                        100
		//                                 120
        //                            105        125
		//                                  121        126
		
		elements = new TestNode[] { node(200, 1), node(100, 2), node(120, 3), node(105, 0), node(125, 3),node(121, 0),node(126, 0), };
		tree = constructBinarySearchTree(Arrays.asList(elements));
		Position<Integer> p100 = tree.left(tree.root());
		Position<Integer> p125 = tree.right(tree.right(p100));
		Position<Integer> p126 = tree.right(p125);
		Assert.assertEquals(200, tree.next(p126).getElement().intValue());
		Assert.assertEquals(126, tree.next(p125).getElement().intValue());
		Assert.assertEquals(105, tree.next(p100).getElement().intValue());
	}
	
	@Test
	public void testBinarySearchTreeCreate(){
		
		Integer[] elements = new Integer[]{10};
		LinkedBinarySearchTree<Integer> tree = new LinkedBinarySearchTree<Integer>(elements, false);
		Assert.assertArrayEquals(elements, transform_v1(tree.inOrder()));
		
		elements = new Integer[]{10,5};
		tree = new LinkedBinarySearchTree<Integer>(elements, false);
		Assert.assertArrayEquals(new Integer[]{5,10}, transform_v1(tree.inOrder()));
		
		elements = new Integer[]{10,15};
		tree = new LinkedBinarySearchTree<Integer>(elements, false);
		Assert.assertArrayEquals(new Integer[]{10,15},  transform_v1(tree.inOrder()));
		
		elements = new Integer[]{10,15, 5};
		tree = new LinkedBinarySearchTree<Integer>(elements, false);
		Assert.assertArrayEquals(new Integer[]{5,10,15},  transform_v1(tree.inOrder()));
		
		elements = new Integer[]{100,90, 80, 70, 60,50, 40, 30};
		tree = new LinkedBinarySearchTree<Integer>(elements, false);
		Assert.assertArrayEquals(new Integer[]{30,40,50,60,70,80,90,100},  transform_v1(tree.inOrder()));
		
		elements = new Integer[]{30,40,50,60,70,80,90,100};
		tree = new LinkedBinarySearchTree<Integer>(elements, false);
		Assert.assertArrayEquals(new Integer[]{30,40,50,60,70,80,90,100},  transform_v1(tree.inOrder()));	
	}
	
	@Test
	public void testBinarySearchTreeCreateSortedInput() {

		Integer[] elements = new Integer[] { 10 };
		LinkedBinarySearchTree<Integer> tree = new LinkedBinarySearchTree<Integer>(elements, true);
		Assert.assertEquals(1, tree.height());
		Assert.assertArrayEquals(elements, transform_v1(tree.inOrder()));

		elements = new Integer[] { 5, 10 };
		tree = new LinkedBinarySearchTree<Integer>(elements, true);
		Assert.assertTrue(tree.height() == 2);
		Assert.assertArrayEquals(new Integer[] { 5, 10 }, transform_v1(tree.inOrder()));

		elements = new Integer[] { 5,10,15 };
		tree = new LinkedBinarySearchTree<Integer>(elements, true);
		Assert.assertTrue(tree.height() == 2);
		Assert.assertArrayEquals(new Integer[] { 5, 10, 15 }, transform_v1(tree.inOrder()));

		elements = new Integer[] { 5,10,15,20 };
		tree = new LinkedBinarySearchTree<Integer>(elements, true);
		Assert.assertTrue(tree.height() == 3);
		Assert.assertArrayEquals(new Integer[] { 5,10,15,20 }, transform_v1(tree.inOrder()));

		elements = new Integer[] { 5,10,15,20,25 };
		tree = new LinkedBinarySearchTree<Integer>(elements, true);
		Assert.assertTrue(tree.height() == 3);
		Assert.assertArrayEquals(new Integer[] { 5,10,15,20,25 }, transform_v1(tree.inOrder()));
		
		elements = new Integer[] { 5,10,15,20,25,30 };
		tree = new LinkedBinarySearchTree<Integer>(elements, true);
		Assert.assertTrue(tree.height() == 3);
		Assert.assertArrayEquals(new Integer[] { 5,10,15,20,25,30 }, transform_v1(tree.inOrder()));
		
		elements = new Integer[] { 5,10,15,20,25,30 };
		tree = new LinkedBinarySearchTree<Integer>(elements, false);
		Assert.assertTrue(tree.height() == 6);
		Assert.assertArrayEquals(new Integer[] { 5,10,15,20,25,30 }, transform_v1(tree.inOrder()));
	}
	
	@Test
	public void testElementsByDepth() {
		TestNode<Integer>[] elements = new TestNode[] { node(1, 3), node(2, 3), node(3, 3), node(4, 3), node(5, 3),
				node(6, 3), node(7, 3), node(8, 0), node(9, 0), node(10, 0), node(11, 0), node(12, 0), node(13, 0),
				node(14, 0), node(15, 0) };
		BinaryTree<Integer> tree = constructBinaryTree(Arrays.asList(elements));

		Position<Integer>[] inOrderArray = new Position[15];
		inOrderArray = tree.inOrder().toArray(inOrderArray);
		Integer[] expectedInOrderArray = new Integer[] { 8, 4, 9, 2, 10, 5, 11, 1, 12, 6, 13, 3, 14, 7, 15 };
		Integer[] inOrderIntArray = new Integer[15];
		Assert.assertArrayEquals(expectedInOrderArray, transfrom(inOrderArray, inOrderIntArray));

		List<List<Position<Integer>>> elementsByDepth = tree.elementsByDepth();

		Assert.assertEquals(4, elementsByDepth.size());
		
		Assert.assertEquals(1, elementsByDepth.get(0).size());
		Assert.assertEquals(new Integer(1), elementsByDepth.get(0).get(0).getElement());
		
		Assert.assertEquals(2, elementsByDepth.get(1).size());
		Assert.assertEquals(new Integer(3), elementsByDepth.get(1).get(1).getElement());
		
		
		Assert.assertEquals(4, elementsByDepth.get(2).size());
		Assert.assertEquals(new Integer(5), elementsByDepth.get(2).get(1).getElement());
		Assert.assertEquals(new Integer(7), elementsByDepth.get(2).get(3).getElement());
		
		
		Assert.assertEquals(8, elementsByDepth.get(3).size());
		Assert.assertEquals(new Integer(9), elementsByDepth.get(3).get(1).getElement());
		Assert.assertEquals(new Integer(12), elementsByDepth.get(3).get(4).getElement());
		
		elements = new TestNode[] { node(1, 2), node(3, 1), node(6, 3), node(12, 0), node(13, 0)};
	    tree = constructBinaryTree(Arrays.asList(elements));

		inOrderArray = new Position[5];
		inOrderArray = tree.inOrder().toArray(inOrderArray);
		expectedInOrderArray = new Integer[] {1, 12, 6, 13, 3};
		inOrderIntArray = new Integer[5];
		Assert.assertArrayEquals(expectedInOrderArray, transfrom(inOrderArray, inOrderIntArray));

		elementsByDepth = tree.elementsByDepth();

		Assert.assertEquals(4, elementsByDepth.size());
		
		Assert.assertEquals(1, elementsByDepth.get(0).size());
		Assert.assertEquals(new Integer(1), elementsByDepth.get(0).get(0).getElement());
		
		Assert.assertEquals(1, elementsByDepth.get(1).size());
		Assert.assertEquals(new Integer(3), elementsByDepth.get(1).get(0).getElement());
		
		
		Assert.assertEquals(1, elementsByDepth.get(2).size());
		Assert.assertEquals(new Integer(6), elementsByDepth.get(2).get(0).getElement());
		
		Assert.assertEquals(2, elementsByDepth.get(3).size());
		Assert.assertEquals(new Integer(12), elementsByDepth.get(3).get(0).getElement());
		Assert.assertEquals(new Integer(13), elementsByDepth.get(3).get(1).getElement());

	}
	@SuppressWarnings("unchecked")
	@Test
	public void testSubTree(){
		TestNode<Integer>[] elements1 = new TestNode[] { node(1, 3), node(2, 3), node(3, 3), node(4, 3), node(5, 3),
				node(6, 3), node(7, 3), node(8, 0), node(9, 0), node(10, 0), node(11, 0), node(12, 0), node(13, 0),
				node(14, 0), node(15, 0) };
		BinaryTree<Integer> tree1 = constructBinaryTree(Arrays.asList(elements1));
		
		TestNode<Integer>[] elements2 = new TestNode[] { node(4, 3), node(8, 0), node(9, 0)};
		BinaryTree<Integer> tree2 = constructBinaryTree(Arrays.asList(elements2));
		Assert.assertTrue(tree1.subTree(tree2));
		
		TestNode<Integer>[] elements3 = new TestNode[] { node(7, 3), node(14, 0), node(15, 0)};
		BinaryTree<Integer> tree3 = constructBinaryTree(Arrays.asList(elements3));
		Assert.assertTrue(tree1.subTree(tree3));
		
		TestNode<Integer>[] elements4 = new TestNode[] { node(2, 3), node(4, 3), node(5, 3),node(8, 0), node(9, 0), node(10, 0), node(11, 0)};
		BinaryTree<Integer> tree4 = constructBinaryTree(Arrays.asList(elements4));
		Assert.assertTrue(tree1.subTree(tree4));
		
		TestNode<Integer>[] elements5 = new TestNode[] { node(7, 3), node(12, 0), node(13, 0)};
		BinaryTree<Integer> tree5 = constructBinaryTree(Arrays.asList(elements5));
		Assert.assertFalse(tree1.subTree(tree5));
		
		TestNode<Integer>[] elements6 = new TestNode[] { node(8, 2), node(4, 2), node(9, 0)};
		BinaryTree<Integer> tree6 = constructBinaryTree(Arrays.asList(elements6));
		Assert.assertFalse(tree1.subTree(tree6));
	}

	private void print(List<Position<Integer>> list) {
		
		
		for (Position<Integer> p : list) {
			System.out.print(p.getElement() + ", ");
		}
	}

	private TestNode<Integer> node(int v, int children) {
		return new TestNode<Integer>(v, children);
	}

	private Integer[] transfrom(Position<Integer>[] source, Integer[] target) {
		if (target == null) {
			target = new Integer[source.length];
		}
		int i = 0;
		for (Position<Integer> pos : source) {
			target[i++] = pos.getElement();
		}
		return target;
	}

	private Integer[] transform_v1(List<Position<Integer>> source) {
		Integer[]	target = new Integer[source.size()];	
		int i = 0;
		for (Position<Integer> pos : source) {
			target[i++] = pos.getElement();
		}
		return target;
	}
	private BinaryTree<Integer> constructCompleteBinaryTree(List<Integer> elements) {
		BinaryTree<Integer> tree = new LinkedBinaryTree<Integer>();
		Position<Integer> root = tree.addRoot(elements.get(0));
		Queue<Position<Integer>> queue = new ArrayBlockingQueue<Position<Integer>>(50);
		queue.add(root);
		int i = 1;
		while (!queue.isEmpty() && i < elements.size()) {
			Position<Integer> parent = queue.remove();
			Position<Integer> left = tree.addLeft(parent, elements.get(i++));
			queue.add(left);
			Position<Integer> right = tree.addRight(parent, elements.get(i++));
			queue.add(right);
		}

		return tree;
	}

	private BinaryTree<Integer> constructBinaryTree(List<TestNode<Integer>> elements) {
		BinaryTree<Integer> tree = new LinkedBinaryTree<Integer>();
		Map<Position<Integer>, Integer> map = new HashMap<Position<Integer>, Integer>();
		Position<Integer> root = tree.addRoot(elements.get(0).getElement());
		map.put(root, elements.get(0).numChildren());
		Queue<Position<Integer>> queue = new ArrayBlockingQueue<Position<Integer>>(50);
		queue.add(root);
		int i = 1;
		while (!queue.isEmpty() && i < elements.size()) {
			Position<Integer> parent = queue.remove();
			int numChildren = map.get(parent);
			if (numChildren == 3) {
				Position<Integer> left = tree.addLeft(parent, elements.get(i).getElement());
				queue.add(left);
				map.put(left, elements.get(i++).numChildren());
				Position<Integer> right = tree.addRight(parent, elements.get(i).getElement());
				queue.add(right);
				map.put(right, elements.get(i++).numChildren());
			} else if (numChildren == 2) {
				Position<Integer> right = tree.addRight(parent, elements.get(i).getElement());
				queue.add(right);
				map.put(right, elements.get(i++).numChildren());
			} else if (numChildren == 1) {
				Position<Integer> left = tree.addLeft(parent, elements.get(i).getElement());
				queue.add(left);
				map.put(left, elements.get(i++).numChildren());
			}

		}

		return tree;
	}
	
	private BinarySearchTree<Integer> constructBinarySearchTree(List<TestNode<Integer>> elements) {
		BinarySearchTree<Integer> tree = new LinkedBinarySearchTree<Integer>();
		Map<Position<Integer>, Integer> map = new HashMap<Position<Integer>, Integer>();
		Position<Integer> root = tree.addRoot(elements.get(0).getElement());
		map.put(root, elements.get(0).numChildren());
		Queue<Position<Integer>> queue = new ArrayBlockingQueue<Position<Integer>>(50);
		queue.add(root);
		int i = 1;
		while (!queue.isEmpty() && i < elements.size()) {
			Position<Integer> parent = queue.remove();
			int numChildren = map.get(parent);
			if (numChildren == 3) {
				Position<Integer> left = tree.addLeft(parent, elements.get(i).getElement());
				queue.add(left);
				map.put(left, elements.get(i++).numChildren());
				Position<Integer> right = tree.addRight(parent, elements.get(i).getElement());
				queue.add(right);
				map.put(right, elements.get(i++).numChildren());
			} else if (numChildren == 2) {
				Position<Integer> right = tree.addRight(parent, elements.get(i).getElement());
				queue.add(right);
				map.put(right, elements.get(i++).numChildren());
			} else if (numChildren == 1) {
				Position<Integer> left = tree.addLeft(parent, elements.get(i).getElement());
				queue.add(left);
				map.put(left, elements.get(i++).numChildren());
			}

		}

		return tree;
	}

}
