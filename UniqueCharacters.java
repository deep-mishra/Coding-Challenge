
/** Determine if string has all unique character in n timespace
 * 
 * @author Deep
 *
 */

public class UniqueCharacters {
	
	/**
	 * Method returns true if the string contains all unique characters.	 * 
	 * The complexity of program is O(n) with extra space for holding boolean array of charsets	 * 
	 * @param str
	 * @return
	 */
	public static boolean hasUniqueChars(String str) {
		if(str.length() > Character.MAX_VALUE) return false;		
		boolean[] charSet = new boolean[Character.MAX_VALUE];
		for(int i=0; i<str.length(); i++) {
			int utf16 = str.charAt(i);
			if(charSet[utf16]) {
				return false;
			}
			charSet[utf16] = true;
		}		
		return true;
	}
	
	/**
	 * Method returns true if the string contains all unique characters.
	 * The complexity of program is O(n) with LESS extra space
	 * @param str
	 * @return
	 */
	public static boolean hasUniqueCharsBetter(String str) {
		if(str.length() > Character.MAX_VALUE) return false;		
		int checker = 0;
		for(int i=0; i<str.length(); i++) {
			int value = str.charAt(i) - 'a';
			if((checker & (1 << value)) > 0) {
				return false;
			}
			checker |= (1 << value);
		}		
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println("Technique 1:");
		System.out.println("Input: " + "abcded" + " ---- Output: " + hasUniqueChars("abcded"));
		System.out.println("Input: " + "abcdewl" + " ---- Output: " + hasUniqueChars("abcdewl"));
		
		System.out.println("Technique 2:");
		System.out.println("Input: " + "abcded" + " ---- Output: " + hasUniqueCharsBetter("abcded"));
		System.out.println("Input: " + "abcdewl" + " ---- Output: " + hasUniqueCharsBetter("abcdewl"));
	}
}

/**
 * Outputs: 

Technique 1:
Input: abcded ---- Output: false
Input: abcdewl ---- Output: true
Technique 2:
Input: abcded ---- Output: false
Input: abcdewl ---- Output: true
*/