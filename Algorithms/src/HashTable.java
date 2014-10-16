
public class HashTable<K, V> {
	private DoublyLinkedList<Entry<K,V>>[] table;
	private static final int SIZE = 128;
	
	public HashTable(){
		table = new DoublyLinkedList[SIZE];
		for(int i = 0; i < SIZE; i++){
			table[i] = null;
		}
	}
	
	private int hash(long key){
		return (int)(key % SIZE);
	}
	
	public void put(Entry<K, V> n){
		int k = hash(getKey((K) n.k));
		System.out.println(k);
		if(table[k] != null){
			DoublyLinkedList<Entry<K,V>> t = table[k];
			while(t.next != null){
				t = t.next;
			}
			DoublyLinkedList<Entry<K,V>> d = new DoublyLinkedList<Entry<K,V>>(n,null,t);
			t.next = d;
		}else{
			DoublyLinkedList<Entry<K,V>> d = new DoublyLinkedList<Entry<K,V>>(n);
			table[k] = d;
		}
	}
	
	public Entry<K, V> get(K key){
		int k = hash(getKey(key));
		
		if(table[k].en.k != key){
			//System.out.println("found this: "+ table[k].en.v);
			DoublyLinkedList<Entry<K,V>> t = table[k];
			while(t != null){
				//System.out.println(t.en.v);
				
				if(t.en.k == key)
					return t.en;
				else
					t = t.next;
			}
			return null;
		}else{
			return table[k].en;
		}
		
	}
	
	public long getKey(K k){
		String t = k.toString();
		long hash = 5381;
		for(int i = 0; i < t.length(); i++){
			char c = t.charAt(i);
			hash = ((hash << 5) + hash) + c;
		}
		return hash;
	}
	
}
