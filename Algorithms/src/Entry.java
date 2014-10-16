
public class Entry<K,V> {
	private static final int BASE = 16;
	public K k;
	public V v;
	public boolean deleted = false;
	
	public Entry()
	{
		this.k = null;
		this.v = null;
	}
	public Entry(K key, V value){
		this.k = key;
		this.v = value;
	}
	
	public int getKey(K k){
		String t = k.toString();
		int key = 0;
		for(int i = 0; i < t.length(); i++){
			char c = t.charAt(i);
			key += Character.getNumericValue(c) * i * BASE;
		}
		return key;
	}
}
