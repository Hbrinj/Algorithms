
public class Fibonacci {
	public static void main(String argv[]){
		System.out.println(iterFib(20));
		System.out.println(recurFib(20));
	}
	
	public static int iterFib(int n){
		int x = 0;
		int y = 1;
		for(int i = 0; i < n-1; i++){
			int t = x+y;
			x = y;
			y = t;
		}
		return y;
	}
	
	public static int recurFib(int i){
		if(i == 1 || i == 0)
			return i;
		return recurFib(i-1) + recurFib(i-2);
	}
}
