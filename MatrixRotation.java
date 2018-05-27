
/**
 * Rotate N X N matrix to right
 * @author Deep
 *
 */

public class MatrixRotation {
	
	/**
	 * Rotate the matrix elements to right
	 * @param mat
	 */
	public static void rotateMatrix(int[][] mat) {
		int n = mat.length;		
		for(int i=0; i<n/2; i++) {
			int first = i;
			int last = n-1-i;
			for(int j=first; j<last; j++) {
				int offset = j - first;
				int temp = mat[first][j];        //Store the top left
				mat[first][j] = mat[last-offset][first];    // Move bottom left to top left
				mat[last-offset][first] = mat[last][last-offset]; // Move bottom right to left 
				mat[last][last-offset] = mat[j][last];        // Move right to bottom
				mat[j][last] = temp;                 // Move top to right
			}
		}
		
	}
	
	public static void display(int[][] mat) {
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat.length; j++) {
				System.out.print(mat[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		
		int[][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		System.out.println("CASE1:");
		System.out.println("Input Matrix");
		display(mat);		
		System.out.println("Rotated Matrix");
		rotateMatrix(mat);
		display(mat);	
		
		System.out.println();
		System.out.println("CASE2:");
		int[][] mat2 = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		System.out.println("Input Matrix");
		display(mat2);		
		System.out.println("Rotated Matrix");
		rotateMatrix(mat2);
		display(mat2);
	}
}
