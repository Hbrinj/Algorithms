
public class start {
	
	Queue<Tuple> Q;
	Stack<Node<Integer>> st;
	HashMap<String,String> ht;
	Node N;
	public start()
	{
		Q = new Queue<Tuple>(10);
		//addstuff();
		//turnBSTtoArray();
		//createTree();
		//useHash();
		//sortarr();
		//CreateTrie();
		graphThing();
	}
	public static void main(String[] argv)
	{
		start st = new start();
		
	}
	
//	public void addstuff()
//	{
//		for(int i = 0; i < 10; i++)
//		{
//			Q.enqueue(i*3);
//		}
//		Q.enqueue(20);
//	}
	
	public void graphThing(){
		GraphNode A = new GraphNode('A',3);
		GraphNode B = new GraphNode('B',3);
		GraphNode C = new GraphNode('C',2);
		GraphNode D = new GraphNode('D',1);
		GraphNode E = new GraphNode('E',2);
		GraphNode F = new GraphNode('F',2);
		GraphNode G = new GraphNode('G',1);
		
		A.addChild(B);
		A.addChild(C);
		A.addChild(E);
		B.addChild(A);
		B.addChild(D);
		B.addChild(F);
		C.addChild(A);
		C.addChild(G);
		D.addChild(B);
		E.addChild(A);
		E.addChild(F);
		F.addChild(B);
		F.addChild(E);
		G.addChild(C);
		
		Graph g = new Graph(A);
		g.DFS();
		System.out.println();
		g.BFS();
		
		
	}
	
	public void sortarr(){
		int[] a = {0,4,20,15,3,5,19};
		heapsort3.sort(a);
		for(int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}
	}
	
	public void useHash(){
		ht = new HashTableLinearProbing<String,String>();
		
		ht.put(new Entry<String, String>("derp","Oh Hai there")); //
		ht.put(new Entry<String, String>("merp","Oh Hai there1"));//
		ht.put(new Entry<String, String>("flerp","Oh Hai there2"));
		ht.put(new Entry<String, String>("herp","Oh Hai there3"));//
		ht.put(new Entry<String, String>("purp","Oh Hai there4"));//
		ht.put(new Entry<String, String>("200","Oh Hai there5"));
		ht.put(new Entry<String, String>("jib","Oh Hai there6"));
		ht.put(new Entry<String, String>("nerb","Oh Hai there7"));
		ht.put(new Entry<String, String>("perb","Oh Hai there8"));
		
		System.out.println(ht.get("jib").v);
	}
	
	public void createTree()
	{
		N = new Node<Integer>(6);
		AVL T = new AVL(N);
		T.insert(4);
		T.insert(8);
		T.insert(2);
		T.insert(5);
		T.insert(7);
		T.insert(10);
		T.insert(9);
		T.insert(11);
		T.insert(1);
		T.insert(3);
		
		st = new Stack<Node<Integer>>(20);
		//System.out.println(N.left.s);
		//inorderTraversal(N);
		T.inorderTraversal();
		T.delete(8);
		T.inorderTraversal();
		T.insert(30);
		T.insert(40);
		T.insert(50);
		T.inorderTraversal();
		System.out.println(T.getHeight());
		//inorderTraversal(N);
		//preorderTraversal(N);
		//postorderTraversal(N);
	}
	
	public void postorderTraversal(Node<Integer> N)
	{
		if(N == null)
			return;
		
		do{
			
			while(N != null)
			{
				if(N.right != null)
					st.push(N.right);
				st.push(N);
				
				N = N.left;
			}
			
			N = st.pop();
			
			if(N.right != null && st.peek() == N.right)
			{
				st.pop();
				st.push(N);
				N = N.right;
			}else{
				System.out.println(N.s);
				N = null;
			}
		}while(!st.isEmpty());
	
		
//		if(N.left != null){
//			//System.out.println("Going left");
//			postorderTraversal(N.left);
//			
//		}
//			
//		if(N.right != null){
//			//System.out.println("Going right");
//			postorderTraversal(N.right);
//		}
//		System.out.println(N.s);
	}
	
	public void preorderTraversal(Node<Integer> N)
	{
		if(N == null)
			return;
		
		st.push(N);
		
		while(!st.isEmpty())
		{
			Node temp = st.pop();
			System.out.println(temp.s);
			
			if(temp.right != null)
				st.push(temp.right);
			if(temp.left != null)
				st.push(temp.left);
		}
//		if(N.left != null){
//			//System.out.println("Going left");
//			preorderTraversal(N.left);
//			
//		}
//			
//		
//		if(N.right != null){
//			//System.out.println("Going right");
//			preorderTraversal(N.right);
//		}
	}
	
	
	public void inorderTraversal(Node<Integer> N)
	{
//		st.push(N);
//		
//		while(!st.isEmpty())
//		{
//			if(N != null)
//			{
//				st.push(N);
//				N = N.left;
//			}else{
//				N = st.pop();
//				System.out.println(N.s);
//				//if(N.right != null)
//				N = N.right;
//			}
//		}
			
			if(N.left != null)
				inorderTraversal(N.left);
			
			System.out.println(N.s);
			if(N.right != null)
				inorderTraversal(N.right);
	}
	
	public void turnBSTtoArray()
	{
		int a[] = {1,3,5,6,7,8,9,200};
		int b[] = new int[a.length];
		int mid;
		int i = 0;
		Q.enqueue(new Tuple(0,a.length-1));
		while(!Q.isEmpty())
		{
			Tuple t = Q.pop();
			if(t.left <= t.right)
			{
				mid = (t.left + t.right) /2;
				//System.out.println(mid);
				b[i] = a[mid];
				i++;
				Q.enqueue(new Tuple(t.left,mid-1));
				Q.enqueue(new Tuple(mid+1,t.right));
			}
		}
		
		for(i = 0; i < a.length; i++)
		{
			System.out.print(b[i] + " ");
		}
		System.out.println();
		
	}
	
	public void CreateTrie(){
		PrefixTree T = new PrefixTree();
		T.insertWord("all");
		T.insertWord("alas");
		T.insertWord("always");
		T.insertWord("and");
		T.insertWord("anderson");
		T.insertWord("android");
		
		if(T.isPrefix("andro"))
			System.out.println("existed");
		else
			System.out.println("NOPE");
		
		if(T.isPrefix("al"))
			System.out.println("existed");
		else
			System.out.println("NOPE");
	}
	
	
}