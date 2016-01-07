package com.ctci.chap4.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyListGraph<V, E> implements Graph<V, E> {

	private boolean isDirected;
	private List<Vertex<V>> vertices = new LinkedList<Vertex<V>>();
	private List<Edge<E>> edges = new LinkedList<Edge<E>>();

	public AdjacencyListGraph(boolean isDirected) {
		this.isDirected = isDirected;
	}

	public boolean isDirected() {
		return isDirected;
	}

	@Override
	public int numVertices() {
		return vertices.size();
	}

	@Override
	public Iterable<Vertex<V>> vertices() {
		return vertices;
	}

	@Override
	public int numEdges() {
		return edges.size();
	}

	@Override
	public Iterable<Edge<E>> edges() {
		return edges;
	}

	@Override
	public List<Edge<E>> outGoingEdges(Vertex<V> v) {
		InnerVertex<V> iv = validate(v);
		return iv.getOutgoingEdges();
	}

	@Override
	public List<Edge<E>> incomingEdges(Vertex<V> v) {
		InnerVertex<V> iv = validate(v);
		return iv.getIncomingEdges();
	}

	@Override
	public Edge<E> getEdge(Vertex<V> u, Vertex<V> v) {
		InnerVertex<V> origin = validate(u);
		List<Edge<E>> edges = origin.getOutgoingEdges();
		for (Edge<E> e : edges) {
			InnerEdge<E> ie = (InnerEdge<E>) e;
			if (ie.getEndpoints()[1].getElement().equals(v.getElement())) {
				return e;
			}
		}
		return null;
	}

	@Override
	public Vertex<V> insertVertex(V element) {
		InnerVertex<V> v = new InnerVertex<V>(element, isDirected);
		vertices.add(v);
		return v;
	}

	@Override
	public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E element) {
		InnerVertex<V> iu = validate(u);
		InnerVertex<V> iv = validate(v);
		InnerEdge<E> ie = null;
		if (getEdge(u, v) == null) {
			ie = new InnerEdge<E>(iu, iv, element);
			edges.add(ie);
			iu.getOutgoingEdges().add(ie);
			iv.getIncomingEdges().add(ie);
		} else {
			throw new IllegalArgumentException("Edge from u to v exists");
		}
		return ie;
	}

	private class InnerVertex<V> implements Vertex<V> {

		private V element;
		private List<Edge<E>> incomingEdges, outgoingEdges;

		public InnerVertex(V element, boolean graphIsDirected) {
			this.element = element;
			outgoingEdges = new ArrayList<Edge<E>>();
			if (graphIsDirected) {
				incomingEdges = new ArrayList<Edge<E>>();
			} else {
				incomingEdges = outgoingEdges;
			}
		}

		@Override
		public V getElement() {
			return element;
		}

		public List<Edge<E>> getIncomingEdges() {
			return incomingEdges;
		}

		public List<Edge<E>> getOutgoingEdges() {
			return outgoingEdges;
		}

		public boolean validate(Graph<V, E> graph) {
			return (AdjacencyListGraph.this == graph && AdjacencyListGraph.this.vertices.contains(this));
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
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
			InnerVertex other = (InnerVertex) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (element == null) {
				if (other.element != null)
					return false;
			} else if (!element.equals(other.element))
				return false;
			return true;
		}

		private AdjacencyListGraph getOuterType() {
			return AdjacencyListGraph.this;
		}

	}

	private class InnerEdge<E> implements Edge<E> {

		private E element;
		private Vertex<V>[] endpoints;

		public InnerEdge(Vertex<V> u, Vertex<V> v, E element) {
			this.element = element;
			endpoints = (Vertex<V>[]) new Vertex[] { u, v };
		}

		@Override
		public E getElement() {
			return element;
		}

		public Vertex<V>[] getEndpoints() {
			return endpoints;
		}

		public boolean validate(Graph<V, E> graph) {
			return (AdjacencyListGraph.this == graph && AdjacencyListGraph.this.edges.contains(this));
		}

	}

	private InnerVertex<V> validate(Vertex<V> v) {
		if (!(v instanceof InnerVertex)) {
			throw new IllegalArgumentException("Invalid Vertex");
		}
		InnerVertex<V> iv = (InnerVertex<V>) v;
		if (!iv.validate(this)) {
			throw new IllegalArgumentException("Invalid Vertex");
		}
		return iv;
	}

	private InnerEdge<E> validate(Edge<E> e) {
		if (!(e instanceof InnerEdge)) {
			throw new IllegalArgumentException("Invalid Edge");
		}
		InnerEdge<E> ie = (InnerEdge<E>) e;
		if (!ie.validate(this)) {
			throw new IllegalArgumentException("Invalid Edge");
		}
		return ie;
	}

	@Override
	public List<Vertex<V>> bfs(Vertex<V> start) {
		InnerVertex<V> startInner = validate(start);
		Map<V, Boolean> visited = new HashMap<V, Boolean>();
		List<Vertex<V>> bfsList = new ArrayList<Vertex<V>>();
		Queue<Vertex<V>> queue = new LinkedList<Vertex<V>>();
		queue.add(startInner);
		visited.put(start.getElement(), true);
		while (!queue.isEmpty()) {
			InnerVertex<V> u = (InnerVertex<V>) queue.remove();
			bfsList.add(u);
			for (Edge<E> e : u.outgoingEdges) {
				Vertex<V> v = ((InnerEdge<E>) e).endpoints[1];
				if (v.getElement().equals(u.getElement())) {
					v = ((InnerEdge<E>) e).endpoints[0];
				}
				if (visited.get(v.getElement()) == null) {
					queue.add(v);
					visited.put(v.getElement(), true);
				}
			}
		}
		return bfsList;
	}

	@Override
	public List<Vertex<V>> dfs(Vertex<V> start) {
		InnerVertex<V> startInner = validate(start);
		Map<V, Boolean> visited = new HashMap<V, Boolean>();
		List<Vertex<V>> dfsList = new ArrayList<Vertex<V>>();
		Stack<Vertex<V>> stack = new Stack<Vertex<V>>();
		stack.push(startInner);
		while (!stack.isEmpty()) {
			InnerVertex<V> u = (InnerVertex<V>) stack.pop();
			if (visited.get(u.getElement()) == null) {
				visited.put(u.getElement(), true);
				dfsList.add(u);
			}
			for (Edge<E> e : u.outgoingEdges) {
				Vertex<V> v = ((InnerEdge<E>) e).endpoints[1];
				if (v.getElement().equals(u.getElement())) {
					v = ((InnerEdge<E>) e).endpoints[0];
				}
				if (visited.get(v.getElement()) == null) {
					stack.push(v);
				}
			}
		}
		return dfsList;
	}

	@Override
	public Map<Vertex<V>, Boolean> dfsRecursive(Vertex<V> start) {
		InnerVertex<V> startInner = validate(start);
		Map<Vertex<V>, Boolean> dfsMap = new LinkedHashMap<Vertex<V>, Boolean>();
		return dfsRecursiveInternal(dfsMap, startInner);

	}

	private Map<Vertex<V>, Boolean> dfsRecursiveInternal(Map<Vertex<V>, Boolean> dfsMap, InnerVertex<V> startInner) {
		InnerVertex<V> u = startInner;
		dfsMap.put(u, true);
		for (Edge<E> e : u.getOutgoingEdges()) {
			InnerVertex<V> v = (InnerVertex<V>) ((InnerEdge<E>) e).endpoints[1];
			if (v.getElement().equals(u.getElement())) {
				v = (InnerVertex<V>) ((InnerEdge<E>) e).endpoints[0];
			}
			if (dfsMap.get(v) == null) {
				dfsRecursiveInternal(dfsMap, v);
			}
		}
		return dfsMap;

	}

	@Override
	public Boolean path(Vertex<V> u, Vertex<V> v) {

		InnerVertex<V> ui = validate(u);
		InnerVertex<V> vi = validate(v);
		if(ui.equals(vi)){
			return true;
		}
		Map<V, Boolean> visited = new HashMap<V, Boolean>();
		List<Vertex<V>> bfsList = new ArrayList<Vertex<V>>();
		Queue<Vertex<V>> queue = new LinkedList<Vertex<V>>();
		queue.add(ui);
		visited.put(ui.getElement(), true);
		while (!queue.isEmpty()) {
			InnerVertex<V> x = (InnerVertex<V>) queue.remove();
			bfsList.add(x);
			if(x.equals(vi)){
				return true;
			}
			for (Edge<E> e : x.outgoingEdges) {
				Vertex<V> y = ((InnerEdge<E>) e).endpoints[1];
				if (y.getElement().equals(x.getElement())) {
					y = ((InnerEdge<E>) e).endpoints[0];
				}
				if (visited.get(y.getElement()) == null) {
					queue.add(y);
					visited.put(y.getElement(), true);
				}
			}
		}
		return false;
	
	}
	
	

}
