import java.util.Scanner;


public class ReadIn {
	public static void main(String argv[]){
		Scanner in = new Scanner(System.in);
		int i = 0;
		int num = in.nextInt();
		int a[] = new int[num];
		for(i = 0; i < num; i++)
		{
			a[i] = in.nextInt();
		}
		
		for(int j : a)
			System.out.println(j);
	}
}
