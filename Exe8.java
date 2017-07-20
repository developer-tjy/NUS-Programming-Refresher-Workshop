// This program reads a sequence of n values and efficiently
// computes the sum of values over a partial sequence.
import java.util.*;

public class Exe8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // read n numbers and fill the array
        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++)
            array[i] = sc.nextInt();

        int[] sum_arr = sum_arr(array);

        // read queries and perform efficient addition
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(add(sum_arr, start, end));
        }
    }

	//Perform effiecient adding
	//Pre-con: Ranges provide is in the array
    public static int add(int[] array, int start, int end) {
        if (start == 0){
            return array[end];
        }
        return (array[end] - array[start-1]);
    }

	//Returns the an array which is the sum of all prev num + itself
	//[25, 66, 21, 89, 12, 78] => [25, 91, 112, 201, 213, 291]
	//Pre-con: arr size > 0
    public static int[] sum_arr(int[] array) {
        int[] sum_arr =  new int[array.length];
        sum_arr[0] = array[0];
        for(int i = 1; i < array.length; i++){
            sum_arr[i] = sum_arr[i-1] + array[i];
        }

        return sum_arr;
    }
}
