

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * 
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * @author Deep
 *
 *
 */

public class LongestSubstring {

	/**
	 * Find longest substring without any repetition
	 * 
	 * @param s
	 * @return
	 */
	public static String lengthOfLongestSubstring(String s) {
		
		StringBuilder subSeq = new StringBuilder();				//Holds the longest subsequence without repetition
		String longestSubseq = null;
		boolean repeated = false;
		int backoffOfset = 0;
		int maxLen = 0;
		int i=0;
		while(i<s.length()) {
			char c = s.charAt(i);
			
			for(int j=0;j<subSeq.length();j++) {
				if(c == subSeq.charAt(j)) {
					repeated = true;
					backoffOfset = subSeq.length()-1-j;
				}
			}
			
			if(repeated) {
				if(subSeq.length()>maxLen) {
					maxLen = subSeq.length();
					longestSubseq = subSeq.toString();
				}
				repeated = false;
				subSeq.setLength(0);
				i = i - backoffOfset;
			} else {
				subSeq.append(c);
				i++;				
			}
		}
		
		if (subSeq.length() > maxLen) { // If last character was not repeated and it increased the subseq length
			maxLen = subSeq.length();
			longestSubseq = subSeq.toString();
		}
		
		return longestSubseq;
	}

	public static void main(String[] args) {

		String input = "abcabcbb";
		String result = lengthOfLongestSubstring(input);
		System.out.println("Case 1:");
		System.out.println("Input: " + input + " ---- Output Substring: " + result + " length: " + result.length());
		
		input = "bbbbb";
		result = lengthOfLongestSubstring(input);
		System.out.println("Case 2:");
		System.out.println("Input: " + input + " ---- Output Substring: " + result + " length: " + result.length());
		
		input = "pwwkew";
		result = lengthOfLongestSubstring(input);
		System.out.println("Case 3:");
		System.out.println("Input: " + input + " ---- Output Substring: " + result + " length: " + result.length());
		
		input = "c";
		result = lengthOfLongestSubstring(input);
		System.out.println("Case 4:");
		System.out.println("Input: " + input + " ---- Output Substring: " + result + " length: " + result.length());
		
		
		input = "dvdf";
		result = lengthOfLongestSubstring(input);
		System.out.println("Case 5:");
		System.out.println("Input: " + input + " ---- Output Substring: " + result + " length: " + result.length());
		
		
		
		input = "anviaj";
		result = lengthOfLongestSubstring(input);
		System.out.println("Case 6:");
		System.out.println("Input: " + input + " ---- Output Substring: " + result + " length: " + result.length());
		
	}

}


/**
 * Output:

Case 1:
Input: abcabcbb ---- Output Substring: abc length: 3
Case 2:
Input: bbbbb ---- Output Substring: b length: 1
Case 3:
Input: pwwkew ---- Output Substring: wke length: 3
Case 4:
Input: c ---- Output Substring: c length: 1
Case 5:
Input: dvdf ---- Output Substring: vdf length: 3
Case 6:
Input: anviaj ---- Output Substring: nviaj length: 5


*/
