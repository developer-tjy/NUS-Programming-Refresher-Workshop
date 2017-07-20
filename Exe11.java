// This program determines if a polygon is convex or not.
import java.util.*;

public class Exe11 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();
        int[][] matrix = new int[n+2][2];

        System.out.println("Enter vertices: ");

        for(int i = 0; i < n; i++){
            for(int x = 0; x < 2; x++){
                matrix[i][x] = sc.nextInt();
            }
        }

		//sets the extra last two row of the array to the first two row of the array
        matrix[n][0] = matrix[0][0];
        matrix[n][1] = matrix[0][1];
        matrix[n+1][0] = matrix[1][0];
        matrix[n+1][1] = matrix[1][1];

        if (isConvex(matrix))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    // Returns true if polygon is convex, else returns false.
    // A polygon is convex if walking along its boundary,
    // we always encounter right turns (or left turns).
    public static boolean isConvex(int[][] matrix) {
        double determinant = 0;
        determinant = (matrix[0][0] * matrix[1][1]) - (matrix[0][0] * matrix[2][1]) - (matrix[0][1] * matrix[1][0]) + (matrix[0][1] * matrix[2][0]) + (matrix[1][0] * matrix[2][1]) - (matrix[1][1] * matrix[2][0]);
		// if determinant is < 0, starts with a right turn.
		if(determinant < 0){
            for(int r = 1; r < matrix.length - 2; r++){
                determinant = (matrix[r][0] * matrix[r+1][1]) - (matrix[r][0] * matrix[r+2][1]) - (matrix[r][1] * matrix[r+1][0]) + (matrix[r][1] * matrix[r+2][0]) + (matrix[r+1][0] * matrix[r+2][1]) - (matrix[r+1][1] * matrix[r+2][0]);
                if(determinant > 0){
                    return false;
                }
            }
        }else if(determinant > 0){
            for(int r = 1; r < matrix.length - 2; r++){
                determinant = (matrix[r][0] * matrix[r+1][1]) - (matrix[r][0] * matrix[r+2][1]) - (matrix[r][1] * matrix[r+1][0]) + (matrix[r][1] * matrix[r+2][0]) + (matrix[r+1][0] * matrix[r+2][1]) - (matrix[r+1][1] * matrix[r+2][0]);
                if(determinant < 0){
                    return false;
                }
            }
        }
        return true;
    }
}
