package it.unibo.generics.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {
	
	private final Map<N,Set<N>> graph = new HashMap<>();
	private int size;

	@Override
	public void addNode(N node) {
		if(node != null && !this.DoesNodeExist(node)) {
			graph.put(node, new HashSet<N>() );
			this.size++;
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
		List<N>ris = new LinkedList<>();
		LinkedList<N>app = new LinkedList<>();
		Map<N,N> visited = new HashMap<>();
		LinkedList<N>queue = new LinkedList<>();
		
		if(this.DoesNodeExist(target) && this.DoesNodeExist(source)) {	
			queue.add(source);
			visited.put(source, null);
			while(!queue.isEmpty()) {
				source=queue.getFirst();
				queue.remove(source);
				for (var n : graph.get(source)) {
					if(!visited.containsKey(n)){
						visited.put(n, source);
						queue.add(n);
						if(n.equals(target)) {
							queue.clear();
							break;
						}
					}
				}
			}			
		}
		while(null != target) {
			app.add(target);
			target=visited.get(target);
		}
		
		while(!app.isEmpty()) {
			ris.add(app.getLast());
			app.remove(app.size()-1);
		}
		
		return ris;
	}
	
	private boolean DoesNodeExist(N key) {
		return graph.containsKey(key);
	}

}
