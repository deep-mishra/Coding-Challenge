
public class ReverseString {
	
	/** Reverse the string in O(n) times
	 * @param str
	 * @return
	 */
	public static String reverse(String str) {
		
		StringBuilder tempStr = new StringBuilder(str);
		for(int i=0,j=tempStr.length()-1; i<=j; j--,i++) {
			char ch = tempStr.charAt(i);
			tempStr.setCharAt(i, tempStr.charAt(j));
			tempStr.setCharAt(j, ch);
		}
		return tempStr.toString();		
	}
	
	public static void main(String[] args) {
		
		System.out.println("Reverse of :" + "abcde" + " is : " + reverse("abcde"));
		System.out.println("Reverse of :" + "dakwes" + " is : " + reverse("dakwes"));
		System.out.println("Reverse of :" + "ade swd" + " is : " + reverse("ade swd"));
		System.out.println("Reverse of :" + "sw swedsa" + " is : " + reverse("sw swedsa"));
	}
}


/**
 * Output:
Reverse of :abcde is : edcba
Reverse of :dakwes is : sewkad
Reverse of :ade swd is : dws eda
Reverse of :sw swedsa is : asdews ws
*/