
public class Queue<T> {
	private static int BASE = 20;
	private T Q[];
	private int head;
	private int tail;
	private int size;
	private boolean flipped;
	public Queue()
	{
		Q = (T[]) new Object[BASE];
		this.size = BASE;
		head = 0;
		tail = 0;
		flipped = false;
	}
	
	public Queue(int size)
	{
		Q = (T[]) new Object[size];
		head = 0;
		tail = 0;
		this.size = size;
		flipped = false;
	}
	
	public void enqueue(T a)
	{
		if(flipped)
		{
			if(tail < head)
			{
				Q[tail] = a;
				tail++;
			}else{
				System.out.println("ERROR QUEUE FULL");
			}
		} else {
			Q[tail] = a;
			tail++;
		}
		
		if(tail >= size){
			tail = 0;
			flipped = !flipped;
		}
		
	}
	
	public T dequeue()
	{
		return Q[head];
	}
	
	public T pop(){
		T temp = Q[head];
		Q[head] = null;
		if(flipped)
		{
				head++;
		}else{
			
			if (head < tail)
				head++;
			else
				System.out.println("ERROR QUEUE FULL");
		}
		
		if(head >= size){
			head = 0;
			flipped = !flipped;
		}
		
		return temp;
	}
	public boolean isEmpty()
	{
		return (head == tail);
	}
}
