// This program constructs a sequence of numbers
// following the Kaprekar's routine.
import java.text.DecimalFormat;
import java.util.*;

public class Exe17 {

    public static void main(String[] args) {
        int n, input; // n = # of test inputs
        boolean valid = true;
        int old_num = 0;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            input = sc.nextInt();
            if(input % 1111 == 0)
                valid = false;
            else
                valid = true;

            if (!valid)
                System.out.printf("%04d Invalid input. All four digits are the same\n", input);
            else {
                // repeatedly constuct new number and output
                old_num = input;

                DecimalFormat df = new DecimalFormat("0000");

                int new_num = cal_diff(old_num);
                while(old_num != new_num){
                    System.out.print(df.format(old_num) + " ");
                    old_num = new_num;
                    new_num = cal_diff(new_num);
                }

                System.out.println(df.format(new_num));
            }
        }

    }

    public static int cal_diff(int num) {
        int diff = 0, min = 0, max = 0, digit = 0;
        int [] arr = new int [4];
        int counter = 0;
;
        while (num > 0){
            digit = num % 10;
            arr[counter] = digit;
            num = num / 10;
            counter++;
        }

        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++){
            min = arr[i] + min * 10;
        }

        for(int i = arr.length - 1; i >=0 ; i--) {
            max = arr[i] + max * 10;
        }

        diff = max - min;
        return diff;
    }
}
