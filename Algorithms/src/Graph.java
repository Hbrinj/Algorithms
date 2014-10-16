
public class Graph {
	GraphNode root;

	public Graph(GraphNode n) {
		root = n;
	}

	public void DFS() {
		
		GraphNode current = root;
		Stack<GraphNode> st = new Stack<GraphNode>(10);
		current.me = GraphNode.Colour.grey;
		st.push(current);
		while (!st.isEmpty()) {
			if (current.me != GraphNode.Colour.black) {
				for (int j = current.adjacent.length - 1; j >= 0; j--) {
					if (current.adjacent[j] != null) {
						//System.out.print(current.adjacent[j].L);
						//System.out.print(" ");
						st.push(current.adjacent[j]);
					}
				}
				//System.out.println("----");
				System.out.println(current.L);
				current.me = GraphNode.Colour.black;
			}
			current = st.pop();
		}

	}
	
	public void BFS() {
		GraphNode current = root;
		Stack<GraphNode> st = new Stack<GraphNode>(10);
		st.push(current);
		while (!st.isEmpty()) {
			if (current.me != GraphNode.Colour.white) {
				for (int j = current.adjacent.length - 1; j >= 0; j--) {
					if (current.adjacent[j] != null) {
						st.push(current.adjacent[j]);
					}
				}
				current.me = GraphNode.Colour.white;
			}
			current = st.pop();
		}
		
		Queue<GraphNode> Q = new Queue<GraphNode>();
		Q.enqueue(root);
		while(!Q.isEmpty()){
			current = Q.pop();
			if(current.me != GraphNode.Colour.black)
			{
				for(GraphNode n : current.adjacent){
					if(n != null && n.me != GraphNode.Colour.black)
						Q.enqueue(n);
				}
				current.me = GraphNode.Colour.black;
				System.out.println(current.L);
			}
			
		}
	}

}
