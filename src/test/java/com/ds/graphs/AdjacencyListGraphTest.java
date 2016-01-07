package com.ds.graphs;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.ctci.chap4.graphs.AdjacencyListGraph;
import com.ctci.chap4.graphs.Vertex;

public class AdjacencyListGraphTest {

	@Test
	public void testCreation() {
		AdjacencyListGraph<String, Integer> graph = new AdjacencyListGraph<String, Integer>(true);
		Assert.assertTrue(graph.isDirected());
		Assert.assertEquals(0, graph.numVertices());
		Assert.assertEquals(0, graph.numEdges());
		Assert.assertFalse(graph.edges().iterator().hasNext());
		Assert.assertFalse(graph.vertices().iterator().hasNext());

		Vertex<String> v1 = graph.insertVertex("1");
		Vertex<String> v2 = graph.insertVertex("2");
		Vertex<String> v3 = graph.insertVertex("3");
		Vertex<String> v4 = graph.insertVertex("4");

		graph.insertEdge(v1, v2, 12);
		graph.insertEdge(v2, v3, 23);
		graph.insertEdge(v4, v3, 43);
		graph.insertEdge(v4, v1, 41);

		Assert.assertEquals(4, graph.numVertices());
		Assert.assertEquals(4, graph.numEdges());

		Assert.assertEquals(1, graph.incomingEdges(v1).size());
		Assert.assertEquals(1, graph.incomingEdges(v2).size());
		Assert.assertEquals(2, graph.incomingEdges(v3).size());
		Assert.assertEquals(0, graph.incomingEdges(v4).size());

		Assert.assertEquals(1, graph.outGoingEdges(v1).size());
		Assert.assertEquals(1, graph.outGoingEdges(v2).size());
		Assert.assertEquals(0, graph.outGoingEdges(v3).size());
		Assert.assertEquals(2, graph.outGoingEdges(v4).size());

		Assert.assertNotNull(graph.getEdge(v1, v2));
		Assert.assertNotNull(graph.getEdge(v2, v3));
		Assert.assertNotNull(graph.getEdge(v4, v3));
		Assert.assertNotNull(graph.getEdge(v4, v1));

		Assert.assertNull(graph.getEdge(v2, v2));
		Assert.assertNull(graph.getEdge(v3, v2));
		Assert.assertNull(graph.getEdge(v3, v4));
		Assert.assertNull(graph.getEdge(v1, v4));
	}

	@Test
	public void testBfsAndDfs() {

		AdjacencyListGraph<String, Integer> graph = new AdjacencyListGraph<String, Integer>(false);
		Vertex<String> v1 = graph.insertVertex("1");
		Vertex<String> v2 = graph.insertVertex("2");
		Vertex<String> v3 = graph.insertVertex("3");
		Vertex<String> v4 = graph.insertVertex("4");
		Vertex<String> v5 = graph.insertVertex("5");
		Vertex<String> v6 = graph.insertVertex("6");
		Vertex<String> v7 = graph.insertVertex("7");
		Vertex<String> v8 = graph.insertVertex("8");

		graph.insertEdge(v1, v2, 12);
		graph.insertEdge(v1, v3, 13);

		graph.insertEdge(v2, v4, 24);
		graph.insertEdge(v2, v5, 25);

		graph.insertEdge(v3, v6, 36);
		graph.insertEdge(v3, v7, 37);

		graph.insertEdge(v4, v8, 48);
		graph.insertEdge(v5, v8, 58);
		graph.insertEdge(v6, v8, 68);
		graph.insertEdge(v7, v8, 78);
		
		Assert.assertArrayEquals(new String[]{"1", "2", "3", "4", "5", "6", "7", "8"}, transform(graph.bfs(v1))); 
		Assert.assertArrayEquals(new String[]{"1", "3", "7", "8", "6", "5", "2", "4"}, transform(graph.dfs(v1))); 
		Assert.assertArrayEquals(new String[]{"1", "2", "4", "8", "5", "6", "3", "7"}, transform(graph.dfsRecursive(v1))); 
	}
	

	public void testDfs() {

		AdjacencyListGraph<String, Integer> graph = new AdjacencyListGraph<String, Integer>(false);
		Vertex<String> v1 = graph.insertVertex("1");
		Vertex<String> v2 = graph.insertVertex("2");
		Vertex<String> v3 = graph.insertVertex("3");
		Vertex<String> v4 = graph.insertVertex("4");

		graph.insertEdge(v1, v2, 12);
		graph.insertEdge(v1, v3, 13);

		graph.insertEdge(v2, v4, 24);
		graph.insertEdge(v3, v4, 34);
	
		
		Assert.assertArrayEquals(new String[]{"1", "2", "3", "4"}, transform(graph.bfs(v1))); 
		Assert.assertArrayEquals(new String[]{"1", "3", "4", "2"}, transform(graph.dfs(v1))); 
		Assert.assertArrayEquals(new String[]{"1", "2", "4", "3"}, transform(graph.dfsRecursive(v1))); 
		
		graph = new AdjacencyListGraph<String, Integer>(false);
		v1 = graph.insertVertex("1");
		v2 = graph.insertVertex("2");
		v3 = graph.insertVertex("3");
		v4 = graph.insertVertex("4");
		Vertex<String> v5 =  graph.insertVertex("5");

		graph.insertEdge(v1, v2, 12);
		graph.insertEdge(v1, v3, 13);
		graph.insertEdge(v1, v4, 14);

		graph.insertEdge(v2, v5, 25);
		graph.insertEdge(v3, v5, 35);
		graph.insertEdge(v4, v5, 45);
	
		
		Assert.assertArrayEquals(new String[]{"1", "2", "3", "4", "5"}, transform(graph.bfs(v1))); 
		Assert.assertArrayEquals(new String[]{"1", "4", "5", "3", "2"}, transform(graph.dfs(v1))); 
		Assert.assertArrayEquals(new String[]{"1", "2", "5", "3", "4"}, transform(graph.dfsRecursive(v1)));
		
		graph = new AdjacencyListGraph<String, Integer>(false);
		v1 = graph.insertVertex("1");
		v2 = graph.insertVertex("2");
		v3 = graph.insertVertex("3");
		v4 = graph.insertVertex("4");
		v5 =  graph.insertVertex("5");
		Vertex<String> v6 =  graph.insertVertex("6");
		Vertex<String> v7 =  graph.insertVertex("7");
		Vertex<String> v8 =  graph.insertVertex("8");
		
		graph.insertEdge(v1, v2, 12);
		graph.insertEdge(v1, v3, 13);
		
		graph.insertEdge(v2, v4, 24);
		graph.insertEdge(v2, v5, 25);
		
		graph.insertEdge(v3, v6, 36);
		graph.insertEdge(v3, v7, 37);


		graph.insertEdge(v4, v8, 48);
		graph.insertEdge(v5, v8, 58);
		graph.insertEdge(v6, v8, 68);
		graph.insertEdge(v7, v8, 78);
	
		
		Assert.assertArrayEquals(new String[]{"1", "2", "3", "4", "5", "6", "7", "8"}, transform(graph.bfs(v1))); 
		Assert.assertArrayEquals(new String[]{"1", "3", "7", "8", "6", "5", "2", "4"}, transform(graph.dfs(v1))); 
		Assert.assertArrayEquals(new String[]{"1", "2", "4", "8", "5", "6", "3", "7"}, transform(graph.dfsRecursive(v1))); 


	}
	@Test
	public void testPath(){


		AdjacencyListGraph<String, Integer> graph = new AdjacencyListGraph<String, Integer>(true);
		Vertex<String> v1 = graph.insertVertex("1");
		Vertex<String> v2 = graph.insertVertex("2");
		Vertex<String> v3 = graph.insertVertex("3");
		Vertex<String> v4 = graph.insertVertex("4");
		Vertex<String> v5 = graph.insertVertex("5");
		Vertex<String> v6 = graph.insertVertex("6");
		Vertex<String> v7 = graph.insertVertex("7");
		Vertex<String> v8 = graph.insertVertex("8");

		graph.insertEdge(v1, v2, 12);
		graph.insertEdge(v1, v3, 13);

		graph.insertEdge(v2, v4, 24);
		graph.insertEdge(v2, v5, 25);

		graph.insertEdge(v3, v7, 37);

		graph.insertEdge(v4, v8, 48);
		
		graph.insertEdge(v5, v4, 54);
		graph.insertEdge(v5, v8, 58);
		
		
		graph.insertEdge(v6, v3, 63);
		graph.insertEdge(v6, v7, 67);
		graph.insertEdge(v6, v8, 68);
		
		
		graph.insertEdge(v7, v8, 78);
		
	
		Assert.assertArrayEquals(new String[]{"1", "2", "3", "4", "5", "7", "8"}, transform(graph.bfs(v1))); 
		Assert.assertArrayEquals(new String[]{"1", "3", "7", "8", "2", "5", "4"}, transform(graph.dfs(v1))); 
		Assert.assertArrayEquals(new String[]{"1", "2", "4", "8", "5", "3", "7"}, transform(graph.dfsRecursive(v1))); 
		Assert.assertTrue(graph.path(v1, v2));
		Assert.assertTrue(graph.path(v1, v3));
		
		Assert.assertTrue(graph.path(v2, v4));
		Assert.assertTrue(graph.path(v2, v5));
		
		Assert.assertFalse(graph.path(v3, v6));
		Assert.assertTrue(graph.path(v3, v7));
		
		Assert.assertFalse(graph.path(v4, v5));
		Assert.assertTrue(graph.path(v4, v8));
		
		Assert.assertFalse(graph.path(v5, v2));
		Assert.assertTrue(graph.path(v5, v4));
		Assert.assertTrue(graph.path(v5, v8));
		
		Assert.assertTrue(graph.path(v6, v8));
		
		Assert.assertTrue(graph.path(v7, v8));
		Assert.assertFalse(graph.path(v7, v6));
		
		Assert.assertFalse(graph.path(v8, v6));
		
		Assert.assertTrue(graph.path(v1, v8));
		
		Assert.assertFalse(graph.path(v3, v5));
	
	}

	private String[] transform(List<Vertex<String>> verticesIn) {
		String[] vertices = new String[verticesIn.size()];
		int i = 0;
		for (Vertex<String> v : verticesIn) {
			vertices[i++] = v.getElement();
			System.out.print(v.getElement()+" ");
		}
		System.out.println();
		return vertices;

	}
	
	private String[] transform(Map<Vertex<String>, Boolean> verticesIn) {
		String[] vertices = new String[verticesIn.size()];
		int i = 0;
		Set<Vertex<String>> verticesSetIn = verticesIn.keySet();
		for (Vertex<String> v : verticesSetIn) {
			vertices[i++] = v.getElement();
			System.out.print(v.getElement()+" ");
		}
		System.out.println();
		return vertices;

	}

}
