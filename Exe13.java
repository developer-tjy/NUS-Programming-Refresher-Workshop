//This program computes the number of north-east paths.
import java.util.*;

public class Exe13{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows and columns apart: ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        System.out.println("Rows and columns apart: " + rows + " " + cols);

        System.out.println("Number of NE-paths = " + ne(rows, cols));
    }

    // Compute the number of north-east paths given two points
    // x rows and y columns apart.
    // Pre-con: x>=0, y>=0
    public static int ne(int x, int y) {
        if(x == 0 || y == 0){
           return 1;
        }else{
            return ne(x-1, y) + ne(x, y - 1);
        }
    }
}
