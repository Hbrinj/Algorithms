import java.math.BigInteger;
import java.util.ArrayList;

public class euler3 {
	public static void main(String argv[]) {
		long t = 600851475143l;

		for (int i = 2; i <= t; i++) {
			while (t % i == 0) {
				System.out.println(i);
				t /= i;
			}
		}
	}

	public static boolean isPrime(int x) {
		for (int div = 2; div <= Math.sqrt(x); div++)
			if (x % div == 0)
				return false;
		System.out.println(x);
		return true;
	}
}
