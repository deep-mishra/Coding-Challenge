package com;

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
		int maxLen = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			for (int j = 0; j < subSeq.length(); j++) {
				if (c == subSeq.charAt(j)) {
					repeated = true;
				}
			}
			if (repeated == false) {
				subSeq.append(c);
			} else {
				if (subSeq.length() > maxLen) {
					repeated = false;
					maxLen = subSeq.length();
					longestSubseq = subSeq.toString();
					subSeq.setLength(0);
					subSeq.append(c);
				}
			}
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

*/
