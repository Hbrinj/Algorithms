import java.util.ArrayList;

public class findOnce {
	static int a[] = { 10, 10,3, 500, 2, 3, 4, 3, 2, 13, 98, 500, 500, 500 };

	public static void main(String argv[]) {
		// strategy sort, create remove dups array, use BST to find ranges of
		// numbers
		Integer leastOccoured = 0;
		int occurred = Integer.MAX_VALUE;
		heapsort();
		Integer[] nodups = removeDups();
		for (Integer i : nodups) {
			int l = findLowHigh(i, false);
			int h = findLowHigh(i, true);
			if ((h - l) + 1 < occurred){
				leastOccoured = i;
				occurred = (h - l) + 1;
			}
		}
		System.out.println(leastOccoured
				+ " is the least occuring number in the array having occurred only "+ occurred);

	}

	private static void heapsort() {
		int start, end;

		for (start = (a.length - 2) / 2; start >= 0; start--)
			siftdown(start, a.length - 1);

		for (end = a.length - 1; end > 0; end--) {
			swap(end, 0);
			siftdown(0, end);
		}
	}

	private static void swap(int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static void siftdown(int s, int e) {
		int root = s;
		while ((root * 2) + 1 < e) {
			int child = (root * 2) + 1;
			if (child + 1 < e && a[child] < a[child + 1])
				child++;

			if (a[root] < a[child]) {
				swap(root, child);
				root = child;
			} else {
				return;
			}
		}
	}

	private static Integer[] removeDups() {
		ArrayList<Integer> l = new ArrayList<Integer>();
		int current = a[0];
		l.add(current);
		for (int j : a) {
			if (j != current) {
				current = j;
				l.add(j);
			}
		}
		Integer[] b = l.toArray(new Integer[l.size()]);

		return b;
	}

	private static int findLowHigh(Integer i, boolean b) {

		int l = 0;
		int r = a.length - 1;
		int pos = -1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (a[mid] == i) {
				pos = mid;
				if (b)
					l = mid + 1;
				else
					r = mid - 1;
			} else if (i < a[mid])
				r = mid - 1;
			else
				l = mid + 1;
		}
		return pos;
	}

}
