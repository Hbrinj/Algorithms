import java.util.ArrayList;


public class findTwoToSum {
	static int a[] = {10,3,500,2,3,4,3,10,2,13,98,7,500,500,500};
	public static void main(String argv[]){
		//strategy  sort, create remove dups array, use BST to find ranges of numbers
		int toMake = 10;
		Integer mostOccoured = 0;
		heapsort();
		Integer[] nodups = removeDups(toMake);
		int f;
		for(Integer i : nodups){
			if((f = find(toMake - i)) != -1)
				System.out.println("(" + i+","+f+")");
		}	
	}
	
	private static void heapsort(){
		int start, end;
		
		for(start = (a.length-2)/2; start >= 0; start--)
			siftdown(start,a.length-1);
		
		for(end = a.length-1; end >0; end--){
			swap(end, 0);
			siftdown(0, end);
		}
	}
	
	private static void swap(int i, int j){
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	private static void siftdown(int s, int e){
		int root = s;
		while((root*2)+1 < e){
			int child = (root*2)+1;
			if(child+1 < e && a[child] < a[child+1])
				child++;
			
			if(a[root] < a[child]){
				swap(root,child);
				root=child;
			}else{
				return;
			}
		}
	}
	
	private static Integer[] removeDups(int max){
		ArrayList<Integer> l = new ArrayList<Integer>();
		int current = a[0];
		l.add(current);
		for(int j : a){
			if(j != current && j <= max){
				current = j;
				l.add(j);
			}
		}
		Integer[] b = l.toArray(new Integer[l.size()]);
		
		return b;
	}
	
	private static int find(Integer i){
		
		int l = 0;
		int r = a.length-1;
		while(l <= r){
			int mid = (l+r)/2;
			if (a[mid] == i){
				return mid;
			}
			else if(i < a[mid])
				r = mid-1;
			else
				l = mid+1;
		}
		return -1;
	}
}
