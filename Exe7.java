//This program performs a non-linear search on a sorted, rotated array.
import java.util.*;

public class Exe7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // read sorted, rotated sequence of values and key value k
        System.out.println("Enter data:");
        List<Integer> list = new ArrayList<Integer>();
        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }

        int[] x = new int[list.size()-1];
        for (int i = 0; i < list.size()-1; i++)
            x[i] = list.get(i);
        int k = list.get(list.size()-1);
        int max_index = find_max_index(list);

        // perform non-linear search
        int idx = search(x, k, (max_index + 1));

        // output the search result
        if (idx == -1)
            System.out.println("Not found");
        else
            System.out.println(idx);
    }

    //Returns the search value's index
    //Pre-con: array to be in rotated and sorted in ascending order
    public static int search(int[] x, int k, int min_index) {
        int arr_length = x.length - 1;
        int low = 0, high = arr_length;
		//Checks to search from the right or left
        if(k < x[min_index] && k > x[0] || k > x[min_index] && k > x[arr_length]){
            high = min_index - 1;
        }else if (k > x[min_index] && k < x[arr_length]){
            low = min_index + 1;
        }else if(k == x[min_index]){
            return min_index;
        }
		
		//Binary Search Algorithm
        int mid = (low + high) / 2;
        while((low <= high) && (x[mid] != k)){
            if(k < x[mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
            mid = (low + high) / 2;
        }

        if(low > high)
            return -1;
        else
            return mid;
    }

    public static int find_max_index(List<Integer> list){
        //Get the highest value in the arraylist
		int max = Collections.max(list);
		//Get the index of the highest value in an arraylist
        int max_index = list.indexOf(max);
        return max_index;
    }
}
