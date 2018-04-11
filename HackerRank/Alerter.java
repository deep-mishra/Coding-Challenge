
//Generate alert if the response time in inputs array is greater than allowedInc from windows avg in all the window it appears
// or if the window avg is greater than the allowedInc from previous window average
public class Alerter {
	
	static boolean alert(int[] inputs, int windowSize, float allowedInc) {

		float[] winAvg = new float[inputs.length - windowSize + 1];
		int k = 0;
		for (int i = 0; i < inputs.length - windowSize + 1; i++) {

			// Find window average in each step
			float sum = 0;
			for (int j = i; j < i + windowSize; j++) {
				sum += inputs[j];
			}
			winAvg[k++] = (float) sum / windowSize;

			// Check window with previous window
			if (i != 0) {
				// Checks if the previous window avg is much lesser than allowed
				if (winAvg[k - 1] > winAvg[k - 2] * allowedInc) {
					System.out
							.println("win "
									+ k
									+ " avg is greater than previous win than allowed ");
					return true;
				}
			}

			// Checks if the individual is greater than allowed for each window
			// it fall
			boolean isExceeding = false;
			for (int j = k - 1; j >= 0 && j > k - 1 - windowSize; j--) {
				if (inputs[i] > winAvg[j] * allowedInc) {
					isExceeding = true;
				} else {
					isExceeding = false;
					break;
				}
			}
			if (isExceeding) {
				System.out.println("value " + inputs[i]
						+ " greater than avg in all windows");
				return true;
			}

		}

		return false;
	}

	public static void main(String[] args) {
	
		System.out.println(alert(new int[]{1,2,100,2,2},3,(float)1.5)); //true - 100 is > than avg in all win it appears
		System.out.println(alert(new int[]{1,2,4,2,2},3,(float)2)); // highest value 4 is within limit in all win it appears
		System.out.println(alert(new int[]{1,2,100,2,2},2,(float)2.5)); // win 3 avg is greater than 2 than allowed value
	
	}
}
