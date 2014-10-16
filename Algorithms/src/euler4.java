
public class euler4 {
	public static void main(String argv[]){
		int max = 0;
		for(int i = 100; i < 999; i++){
			for(int j = 100; j < 999; j++){
				String s = Integer.toString(i*j);
				String r = reverse(s);
				//System.out.println(s +" "+ r);
				if(s.equals(r))
					max = i*j;
			}
		}
		System.out.println(max);
	}
	
	public static String reverse (String s){
		StringBuilder sb = new StringBuilder();
		for(int i = s.length()-1; i >= 0; i--){
			sb.append(s.charAt(i));
		}
		//System.out.println(sb.toString());
		return sb.toString();
	}
}
