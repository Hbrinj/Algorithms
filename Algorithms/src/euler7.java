
public class euler7 {
	public static void main(String argv[]){
		int count = 2;
		int TheOne = 10001;
		for(int i = 1; ;i++){
			if(isPrime((i*6)-1)){
				count++;
				if(count > TheOne){
					//System.out.println(i*6-1);
					break;
				}
			}
			if(isPrime((i*6)+1)){
				count++;
				if(count >= TheOne){
					//System.out.println(i*6-1);
					break;
				}
			}
		}
	}
	
	public static boolean isPrime(int x){
		for(int div = 2; div <= Math.sqrt(x); div++)
			if(x % div == 0) return false;
		System.out.println(x);
		return true;
	}
}
