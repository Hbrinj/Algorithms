
public class BST{
	Node<Integer> root;
	
	public BST(){
		this(null);
	}
	
	public BST( Node<Integer> r){
		root = r;
	}
	
	public Node<Integer> insert(int n)
	{
		Node<Integer> node = root;
		Node<Integer> newNode;
		while(true)
		{
			if(n > node.s){
				if(node.right == null){
					newNode =  new Node<Integer>(n,node);
					node.right = newNode;
					break;
				}
				node = node.right;
			}
			else{
				if(node.left == null){
					newNode =  new Node<Integer>(n,node);
					node.left = newNode;
					break;
				}
				node = node.left;
			}
		}
		return newNode;
	}
	
	public Node<Integer> find(int n){
		Node<Integer> node = root;
		while(true)
		{
			if(node.s.equals(n))
				return node;
			
			if(n > node.s){
				if(node.right == null)
					return null;
				node = node.right;
			}
			else{
				if(node.left == null)
					return null;
				node = node.left;
			}
		}
	}
	
	public Node<Integer> delete(int n){
		Node<Integer> node = find(n);
		if(node.left==null)
			return transplant(node,node.right);
		else if(node.right == null)
			return transplant(node,node.left);
		else{
			Node<Integer> y = findMinimum(node.right);
			if(y.parent != node){
				transplant(y, y.right);
				y.right = node.right;
				y.right.parent = y;
			}
			transplant(node, y);
			y.left = node.left;
			y.left.parent = y;
			return y;
		}
	}
	
	private Node<Integer> transplant(Node<Integer> u, Node<Integer> v){
		if(u.parent == null){
			root = v;
		}else if(u.equals(u.parent.left)){
			u.parent.left = v;
		}else{
			u.parent.right = v;
		}
		if(v != null){
			if(v.parent != null)
				v.parent = u.parent;
		}
		return v;
			
	}
	
	public Node<Integer> findMinimum(){
		return findMinimum(root);
	}
	private Node<Integer> findMinimum(Node<Integer> n){
		Node<Integer> current  = n;
		while(current.left!= null){
			current = current.left;
		}
		return current;
	}
	
	public Node<Integer> findMaximum(){
		Node<Integer> current  = root;
		while(current.right != null){
			current = current.right;
		}
		return current;
	}
	
	public Node<Integer> findSuccessor(Node<Integer> n){
		Node<Integer> current;
		if(n.right != null)
			 current = n.right;
		else
			return null;
		
		while(current.left != null){
			current = current.left;
		}
		
		return current;
	}
	
	public Node<Integer> findPredecessor(Node<Integer> n){
		Node<Integer> current;
		if(n.left != null)
			 current = n.left;
		else
			return null;
		
		while(current.right != null){
			current = current.right;
		}
		
		return current;
	}
	
	public void printTree(){
		
	}
	
	public void inorderTraversal(){
		inorderTraversal(root);
	}
	public void inorderTraversal(Node<Integer> N)
	{			
			if(N.left != null)
				inorderTraversal(N.left);
			
			System.out.println(N.s);
			if(N.right != null)
				inorderTraversal(N.right);
	}
}
