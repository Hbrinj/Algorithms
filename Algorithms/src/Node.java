
public class Node<T> {
	public Node<T> left;
	public Node<T> right;
	public Node<T> parent;
	public T s;
	public int height;
	
	public Node(){
		this(null,null,null,null);
	}
	
	public Node(T s){
		this(s,null,null,null);
	}
	
	public Node(T s, Node<T> parent){
		this(s,parent,null,null);
	}
	
	public Node(T s,Node<T> parent,Node<T> left, Node<T> right){
		this.left = left;
		this.right = right;
		this.parent = parent;
		this.s = s;
	}
	
	
	
}