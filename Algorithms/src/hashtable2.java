public class hashtable2<K, V> {
	private DoublyLinkedList<Entry<K,V>>[] table;
	private static final double RESIZE_FACTOR = 0.7;
	private int size = 10;
	private int entries;
	private boolean resizing = false;

	public hashtable2() {
		table = new DoublyLinkedList[size];
		entries = 0;
	}

	public void put(Entry<K, V> e) {
		int k = hash(e.k); // get hash
		System.out.println(k);
		if (!resizing) {
			entries++; // update entries;
			System.out.println((double) entries / size);
			if ((double) entries / size > RESIZE_FACTOR) 
				resize();
		}

		// collision has occured
		if (table[k] != null) {
			DoublyLinkedList<Entry<K,V>> current = table[k];
			// find the end of the list
			while (current.next != null) {
				current = current.next;
			}
			DoublyLinkedList<Entry<K,V>> temp = new DoublyLinkedList<Entry<K,V>>(e, null, current);
			current.next = temp;
			// no collision
		} else {
			table[k] = new DoublyLinkedList<Entry<K,V>>(e);
		}
	}

	public Entry<K, V> get(K key) {
		int k = hash(key);
		if (table[k] != null) {
			if (!table[k].en.k.equals(key)) {
				DoublyLinkedList<Entry<K,V>> current = table[k].next;
				while (current != null) {
					if (current.en.k.equals(key))
						return current.en;
					else
						current = current.next;
				}
				return null;
			} else {
				return table[k].en;
			}
		} else {
			return null;
		}

	}

	public Entry<K, V> delete(K key) {
		int k = hash(key);
		entries--;
		if (entries / size > RESIZE_FACTOR)
			resize();

		if (!table[k].en.k.equals(key)) {
			DoublyLinkedList<Entry<K,V>> current = table[k].next;
			while (current != null) {
				if (current.en.k.equals(key))
					break;
				else
					current = current.next;
			}
			current.next.previous = current.previous;
			current.previous.next = current.next;
			return current.en;
		} else {
			DoublyLinkedList<Entry<K,V>> current = table[k];
			if (current.previous != null)
				current.previous.next = current.next;
			if (current.next != null)
				current.next.previous = current.previous;

			table[k] = null;
			return current.en;
		}
	}

	private int hash(K k) {
		long hash = 5381;

		String t = k.toString();
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			hash = ((hash << 5) + hash) + c;
		}
		return (int) (hash % size);
	}

	private void resize() {
		resizing = true;
		System.out.println("Resizing the hashtable");
		size = size * 2;
		DoublyLinkedList<Entry<K,V>>[] oldTable = table;
		table = new DoublyLinkedList[size];
		for (int i = 0; i < size; i++) {
			table[i] = null;
		}

		for (int i = 0; i < size / 2; i++) {
			if (oldTable[i] != null) {
				DoublyLinkedList<Entry<K,V>> d = oldTable[i];
				put(d.en);
				d = d.next;
				while (d != null) {
					put(d.en);
					d = d.next;
				}
			}
		}
		resizing = false;
	}

}
