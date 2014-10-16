 
public class HashTableLinearProbing<K,V> implements HashMap<K, V> {
	private int size = 128;
	private Entry<K,V>[]  table;
	private int entries = 0;
	private boolean resizing = false;
	private static final double LOAD_FACTOR = 0.7;
	
	public HashTableLinearProbing()
	{
		table = new Entry[size];
	}
	
	public void put(Entry<K,V> e){
		int key = hash(e.k);
		System.out.println(key);
		if(!resizing)
		{
			entries++;
			if((double) entries / size > LOAD_FACTOR)
				resize();
		}
		
		
		if(table[key] == null || table[key].deleted){
			table[key] = e;
			return;
		}
		
		int index = key;
		index = (index + 1) % size;
		while(index != key){
			if(table[index] == null || table[index].deleted)
			{
				table[index] = e;
				return;
			}
			index = (index + 1) % size;
		}
	}
	
	public Entry<K,V> get(K k){
		int key = hash(k);
		
		if(table[key] != null || !table[key].deleted)
			if(table[key].k.equals(k))
				return table[key];
		
		
		int index = key;
		index = (index + 1) % size;
		while( index != key){
			if(table[index] != null || !table[index].deleted)
			{
				if(table[index].k.equals(k))
					return table[index];
			}
			index = (index + 1) % size;

		}
		return null;
	}
	
	public Entry<K,V> delete (K k){
		int key = hash(k);
		entries--;
		if(table[key] != null || !table[key].deleted)
			if(table[key].k.equals(k)){
				Entry<K,V> en = table[key];
				table[key].deleted = true;
				return en;
			}
		
		
		int index = key;
		index = (index + 1) % size;
		while( index != key){
			if(table[index] != null || !table[index].deleted)
			{
				if(table[index].k.equals(k)){
					Entry<K,V> en = table[index];
					table[index].deleted = true;
					return en;
				}
			}
			index = (index + 1) % size;
		}
		return null;
	}
	
	private void resize(){
		resizing = true;
		
		Entry<K,V>[] oldTable = table;
		size = size*2;
		table = new Entry[size];
		
		for(int i = 0; i < size/2; i++){
			if(oldTable[i] != null && !oldTable[i].deleted){
				put(oldTable[i]);
			}
		}
		resizing = false;
		
	}

	private int hash(K key){
		long hash = 5381;
		String s = key.toString();
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			hash = ((hash << 5) + c) + hash;
		}
		return (int) hash % size;
	}
}
