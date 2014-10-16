
public class radixsort {
	private static int BASE = 10;
	public static void sort(int[] a)
	{
		int max = a[0];
		int i;
		int[] b = new int[a.length];
		int ex = 1;
		
		for(i = 0; i< a.length; i++)
			if(a[i] > max)
				max = a[i];
		
		while(max/ex > 0){
			int[] bucket = new int[BASE];
			
			for(i = 0; i < a.length; i++)
				bucket[(a[i]/ex) % BASE]++;
			
			for(i = 1; i < BASE; i++)
				bucket[i] += bucket[i-1];
			
			for(i = 0; i < a.length; i++)
				b[--bucket[(a[i]/ex) % BASE]] = a[i];
			
			for(i = 0; i < a.length; i++)
				a[i] = b[i];
			
			System.out.println(ex);
			ex *= BASE;
		}
		
	}
}
