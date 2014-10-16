
public interface HashMap<K,V> {
	public void put(Entry <K,V> e);
	public Entry<K,V> get(K k);
	public Entry<K,V> delete(K k);
}
