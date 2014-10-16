
public class GraphNode {
	public static enum Colour {white,grey,black};
	Colour me;
	char L;
	GraphNode adjacent[];
	int i;
	
	public GraphNode(char z,int childSize){
		me = Colour.white;
		L = z;
		adjacent = new GraphNode[childSize];
		i = 0;
	}
	
	public void addChild(GraphNode n){
		if(i < adjacent.length){
			adjacent[i] =n;
			i++;
		}
	}
}
