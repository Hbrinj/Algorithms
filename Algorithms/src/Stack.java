
public class Stack<T> {
	private static int BASE = 20;
	private T st[];
	private int head;
	private int size;
	public Stack()
	{
		st = (T[]) new Object[BASE];
		this.size = BASE;
		head = -1;
	}
	
	public Stack(int s)
	{
		st = (T[]) new Object[s];
		this.size = s;
		head = -1;
	}
	
	public void push(T t)
	{
		if(head < size-1){
			head++;
			st[head] = t;
		}
		else
			System.out.println("STACK FULL trying to push: " + t);
	}
	
	public T pop()
	{
		if(isEmpty())
			System.out.println("STACK IS EMPTY");
		else{
			T temp = st[head];
			head --;
			return temp;
		}
		return null;
	}
	
	public T peek()
	{
		if(isEmpty())
			return null;
		return st[head];
	}
	
	public boolean isEmpty()
	{
		if(head == -1)
			return true;
		else
			return false;
	}
}
