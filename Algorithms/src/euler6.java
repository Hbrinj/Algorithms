
public class euler6 {
	public static void main(String argv[]){
		int sum1 = 0;
		int sum2 = 0;
		int i =0;
		for(i = 0; i <101;i++)
			sum1 += i;
		sum1= sum1*sum1;
		for(i = 0; i < 101;i++)
			sum2 += (i*i);
		
		System.out.println(sum2 - sum1);
	}
}
