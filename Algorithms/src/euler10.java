
public class euler10 {
	public static void main(String argv[]){
		long count = 5;
		int max = 2000000;
		for(int i = 1; ;i++){
			if(isPrime((i*6)-1)){
				if((i*6)-1 > max){
					break;
				}
				count += (i*6)+1;
				
			}
			if(isPrime((i*6)+1)){
				if((i*6)+1 > max){
					break;
				}
				count += (i*6)+1;
			}
		}
		System.out.println(count);
	}
	
	public static boolean isPrime(int x){
		for(int div = 2; div <= Math.sqrt(x); div++)
			if(x % div == 0) return false;
		//System.out.println(x);
		return true;
	}
}
