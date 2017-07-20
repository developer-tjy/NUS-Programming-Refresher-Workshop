// This program aims to determine the total number of
// Christmas presents received in n days, determined by
// the lyric of the Christmas song "The Twelve Days of Christmas".
import java.util.*;

public class Exe14 {

    // The main program is called with an integer argument
    // denoting the "n-th" day on which the number of presents
    // will be determined.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter the number of days: ");
        int n = sc.nextInt();

        System.out.println("You have entered the number of days as: " + n);

        if (n == 1) {
            System.out.println("The number of presents received in 1 day is "
                    + present_thru_days(1) + ".");
        }
        else { // n > 1
            System.out.println("The number of presents received in "
                    + n + " days is " + present_thru_days(n) + ".");
        }
    }

    // This function determines the number of presents to be received
    // throughout n days.
    // Pre-condition: n >= 1
    public static int present_thru_days(int n) {
        if(n > 1){
            return presents(n) + present_thru_days(n-1);
        }else{
            return 1;
        }

    }

    public static int presents(int n){
        if(n > 1){
            return n + presents(n-1);
        }else{
            return 1;
        }
    }
}
