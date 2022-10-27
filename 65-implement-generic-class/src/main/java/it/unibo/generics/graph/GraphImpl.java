package it.unibo.generics.graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {
	
	private final Map<N,Set<N>> graph = new HashMap<>();

	@Override
	public void addNode(N node) {
		if(node != null && !this.DoesNodeExist(node)) {
			graph.put(node, new HashSet<N>() );
		}
		
	}

	@Override
	public void addEdge(N source, N target) {
		if(source != null && target != null) {
			var g = graph.get(source);
			g.add(target);
		}		
	}

	@Override
	public Set<N> nodeSet() {
		return new HashSet<>(graph.keySet());
	}

	@Override
	public Set<N> linkedNodes(N node) {
		// TODO Auto-generated method stub
		return new HashSet<>(graph.get(node));
	}

	@Override
	public List<N> getPath(N source, N target) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean DoesNodeExist(N key) {
		return graph.containsKey(key);
	}

}
