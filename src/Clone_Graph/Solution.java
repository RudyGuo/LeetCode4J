package Clone_Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}

public class Solution {
	Map<UndirectedGraphNode,UndirectedGraphNode> map  = new HashMap<>();
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		if(map.containsKey(node)){
			return map.get(node);
		}
		UndirectedGraphNode ug = new UndirectedGraphNode(node.label);
		map.put(node, ug);
		for (int i = 0; i < node.neighbors.size(); i++) {
				ug.neighbors.add(cloneGraph(node.neighbors.get(i)));
		}
		return ug;
	}
}
