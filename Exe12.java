// Minesweeper
// Read a grid representation a minefield with positions of mines,
// and compute the value (number of surrounding mines) in every safe
// square.
import java.util.*;

public class Exe12 {

    public static final char MINE = '*';
    public static final int L1_ROWS = 8;
    public static final int L1_COLS = 8;
    public static final int L2_ROWS = 12;
    public static final int L2_COLS = 16;
    public static final int L3_ROWS = 16;
    public static final int L3_COLS = 30;

    public static void main(String[] args) {

        int[] rowsLimit = {L1_ROWS, L2_ROWS, L3_ROWS};
        int[] colsLimit = {L1_COLS, L2_COLS, L3_COLS};

        Scanner sc = new Scanner(System.in);

        int level = sc.nextInt();
        int rows = rowsLimit[level-1];
        int cols = colsLimit[level-1];

        String[] minefield = new String[rows];
        int[][] values = new int[rows][cols];

        // read grid data
        sc.nextLine(); // skip newline after the first line of input (level)
        for (int r=0; r<minefield.length; r++)
            minefield[r] = sc.nextLine();

        // printMinefield(minefield); // For checking

        fillValues(minefield, values);
        printValues(values);
    }

    // To print the minefield
    // For checking purpose only
    public static void printMinefield(String[] grid) {
        for (int r=0; r<grid.length; r++)
            System.out.println(grid[r]);
    }

    // Fill numeric array arr with values 0-9.
    // 9: mine-filled sqaure
    // 0-8: number of mines surrounding that square
    public static void fillValues(String grid[], int[][] arr) {

        // complete the code
        int [][] sentinel_arr = new int[arr.length + 2][arr[0].length + 2];

        //Unload the 9 into a new array with extra 2 rows and 2 columns
        for(int i = 0; i < grid.length; i++){
            String [] box = grid[i].split("");
            for(int x = 0; x < box.length; x++){
                if(box[x].equals("*")){
                    sentinel_arr[i + 1][x + 1] = 9;
                }
            }
        }

        int sum = 0;
        // sets the array
        for(int r = 1; r < sentinel_arr.length - 1; r++){
            for(int c = 1; c < sentinel_arr[r].length - 1; c++){
                //If it's a bomb, just set the arr to 9 and continue on with the loop
                if(sentinel_arr[r][c] == 9) {
                    arr[r - 1][c - 1] = 9;
                    continue;
                }
                // Checks the top and bottom rows and left and right columns
                for(int x = r - 1; x <= r + 1; x++){
                    for(int y = c - 1; y <= c + 1; y++){
                        if(x == r && y == c)
                            continue;
                        if(sentinel_arr[x][y] == 9){
                            sum++;
                        }
                    }
                }
                arr[r - 1][c - 1] = sum;
                sum = 0;
            }
        }
    }

    // To print the numeric array
    public static void printValues(int[][] arr) {
        // complete the code
        for(int r = 0; r < arr.length; r++){
            for(int c = 0; c < arr[r].length; c++){
                if(c == arr[r].length - 1)
                    System.out.println(arr[r][c]);
				else if(c == 0)
					System.out.print(" " + arr[r][c] + " ");
                else
                    System.out.print(arr[r][c] + " ");
            }
        }
    }
}
