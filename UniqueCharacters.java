
/** Determine if string has all unique character in n timespace
 * 
 * @author Deep
 *
 */

public class UniqueCharacters {
	
	/**
	 * Method returns true if the string contains all unique characters.
	 * 
	 * The complexity of program is O(n) with extra space for holding boolean array of charsets
	 * 
	 * @param str
	 * @return
	 */
	public static boolean hasUniqueChars(String str) {
		if(str.length() > 256) return false;		
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
	
	public static void main(String[] args) {
		
		System.out.println("Input: " + "abcded" + " ---- Output: " + hasUniqueChars("abcded"));
		System.out.println("Input: " + "abcdewl" + " ---- Output: " + hasUniqueChars("abcdewl"));
	}
}

/**
 * Outputs: 

Input: abcded ---- Output: false
Input: abcdewl ---- Output: true
*/