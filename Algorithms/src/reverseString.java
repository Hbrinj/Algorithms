
public class reverseString {
	public static void main(String argv[]){
		String s = "Hello!";
		String c = iter(s);
		String q = recur(s);
		System.out.println(c);
		System.out.println(q);
	}
	
	public static String iter (String s){
		char[] c = s.toCharArray();
		int j = c.length-1;
		for(int i = 0; i < c.length/2; i++){
			char t = c[i];
			c[i] = c[j];
			c[j] = t;
			j--;
		}
		return new String(c);
	}
	
	public static String recur(String s){
		if(s.length() == 0)
			return s;
		return recur(s.substring(1)) + s.charAt(0);
	}
}
