
public class DoublyLinkedList<V> {
	DoublyLinkedList<V> next;
	DoublyLinkedList<V> previous;
	V en;
	
	
	
	public DoublyLinkedList(){
		this(null,null,null);
	}
	public DoublyLinkedList(V n){
		this(n,null,null);
	}
	public DoublyLinkedList(V n, DoublyLinkedList<V> next){
		this(n,next,null);
	}
	public DoublyLinkedList(V n, DoublyLinkedList<V> next, DoublyLinkedList<V> previous){
		this.next = next;
		this.previous = previous;
		this.en = n;
	}
	
}
