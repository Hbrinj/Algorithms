
public class reverseString2 {
	public static void main(String argv[]){
		String s = "Hello!";
		System.out.println(iterRev(s));
		System.out.println(recurRev(s));
	}
	
	public static String iterRev(String s){
		int i = 0;
		int j = s.length()-1;
		char[] c = s.toCharArray();
		for(; i < (s.length()-1) /2; i++){
			char t = c[i];
			c[i] = c[j];
			c[j] = t;
			j--;
		}
		return new String(c);
	}
	
	public static String recurRev(String s){
		if(s.length() == 0)
			return s;
		return recurRev(s.substring(1)) + s.charAt(0);
	}
}
