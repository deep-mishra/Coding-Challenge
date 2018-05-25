
/** Program to find if a string is permuation of other other string
 * 
 * @author Deep
 *
 */

public class PermutationString {
	
	/**
	 * Method returns true if str1 is permutation of str2. It makes use of
	 * integer array to track if all the chars from str1 is present in str2.
	 * It works in O(n) time space.
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean isPermutation(String str1, String str2) {
		if(str1.length() != str2.length()) return false;
		int[] charSet = new int[Character.MAX_VALUE];
		for(int i=0; i<str1.length(); i++) {
			charSet[str1.charAt(i)]++;
		}
		for(int j=0; j<str2.length(); j++) {
			if(--charSet[str2.charAt(j)] < 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		System.out.println("CASE1:");
		String str1 = "abcde";
		String str2 = "decab";
		System.out.println("Is: " + str1 + " permuation of: " + str2 + " Result: " + isPermutation(str1, str2));
	
		System.out.println("CASE2:");
		str1 = "abcde";
		str2 = "dec";
		System.out.println("Is: " + str1 + " permuation of: " + str2 + " Result: " + isPermutation(str1, str2));
	
		System.out.println("CASE3:");
		str1 = "def";
		str2 = "abcdef";
		System.out.println("Is: " + str1 + " permuation of: " + str2 + " Result: " + isPermutation(str1, str2));
	
	}

}

/** Output:
 *
CASE1:
Is: abcde permuation of: decab Result: true
CASE2:
Is: abcde permuation of: dec Result: false
CASE3:
Is: def permuation of: abcdef Result: false

*/