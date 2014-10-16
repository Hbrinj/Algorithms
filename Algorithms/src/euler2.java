
public class euler2 {
	public static int sum = 0;
	public static void main(String argv[]){
		fib(1,1);
		System.out.println(sum);
	}
	
	public static void fib(int i, int j){
		if((i+j) % 2 == 0)
			sum += (i+j);
		if(i+j > 4000000)
			return;
		fib(j,i+j);
	}
}
