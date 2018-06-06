
/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * @author Deep
 *
 */

public class AddStringNumber {

	public static String addStrings(String num1, String num2) {

		StringBuilder sum = new StringBuilder();
		int carry = 0;
		int n1, n2, s;

		for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
			
			n1 = (i>=0)?num1.charAt(i)-'0':0;
            n2 = (j>=0)?num2.charAt(j)-'0':0;
			s = n1 + n2 + carry;
			carry = s / 10;
			sum.append(s % 10);
		}

		if (carry > 0) {
			sum.append(carry);
		}

		return sum.reverse().toString();

	}

	public static void main(String[] args) {

		System.out.println(addStrings("1", "1"));
		System.out.println(addStrings("123", "33"));

	}
}

/** Output:
 *
2
156
*
*/
