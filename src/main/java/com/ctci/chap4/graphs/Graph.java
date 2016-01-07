package com.ctci.chap4.graphs;

import java.util.List;
import java.util.Map;

public interface Graph<V, E> {

	public int numVertices();

	public Iterable<Vertex<V>> vertices();

	public int numEdges();

	public Iterable<Edge<E>> edges();

	public List<Edge<E>> outGoingEdges(Vertex<V> v);

	public List<Edge<E>> incomingEdges(Vertex<V> v);

	public Edge<E> getEdge(Vertex<V> u, Vertex<V> v);

	public Vertex<V> insertVertex(V element);

	public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E element);

	public List<Vertex<V>> bfs(Vertex<V> s);
	
	public List<Vertex<V>> dfs(Vertex<V> s);
	
	public Map<Vertex<V>, Boolean> dfsRecursive(Vertex<V> s);
	
	public Boolean path(Vertex<V> u, Vertex<V> v);
}
