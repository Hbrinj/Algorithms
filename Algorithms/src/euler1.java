
public class euler1 {
	public static void main(String argv[]){
		int sum3 = 0;
		int sum5 = 0;
		for(int i = 0; i < 1000; i++)
		{
			if(i % 3 == 0)
				sum3 += i;
			else if(i % 5 == 0)
				sum5+=i;
		}
		System.out.println(sum3 + sum5);
	}
}
