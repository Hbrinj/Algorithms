
public class heapsort3 {
	private static int[] array;
	
	public static void sort(int[] a){
		array = a;
		
		int start, end;
		
		for(start = (a.length -2)/2 ; start >= 0; start--){
			siftdown(start, a.length);
		}
		
		for(end = a.length-1; end >0; end--){
			swap(end,0);
			siftdown(0,end);
		}
	}
	
	private static void siftdown(int start, int end){
		int root = start;
		while(root*2+1 < end){
			int child = root*2+1;
			if(child+1 < end && array[child] > array[child+1])
				child++;
				
			if(array[root] > array[child]){
				swap(root,child);
				root = child;
			}else{
				return;
			}
		}
	}
	
	private static void swap(int i, int j){
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
}
