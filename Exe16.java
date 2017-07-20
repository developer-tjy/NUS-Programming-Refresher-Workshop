//This program reads a non-negative number in any base between 2 and 10
//and its base. Numbers with valid base will be convert to decimal numbers.
//Otherwise the program will abort with an error message.
import java.util.*;

public class Exe16{

    public static void main(String[] args) {
        int     n, b; //n = non-negative number, b = base b which is a number between 2 and 10
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a base b : ");
        b = sc.nextInt();

        System.out.print("Enter a base-b number : ");
        n = sc.nextInt();

        //Fill in your code for testing validity of the number
        if(!check_n(n, b)){
            System.out.println("Error!! " + n + " is not a number of base " + b + ".");
        }else{
            System.out.println("The corresponding base-10 number is : "+convertToDecimal(n,b));
        }

    }

    //This function parameters are number and its base
    public static int convertToDecimal(int n, int b)
    {

        //Fill in your code for converting from base b to decimal
        int pow = 0, d = 0, sum = 0;
        while(n > 0){
            d = n % 10;
            n = n /10;
            sum += d * Math.pow(b,pow);
            pow++;
        }

        return sum;
    }

	//check if n is a valid base b number
    public static Boolean check_n(int n, int b){
        int d = 0;
        while(n > 0){
            d = n % 10;
            if(d > b)
                return false;
            n = n / 10;
        }

        return true;
    }
}
