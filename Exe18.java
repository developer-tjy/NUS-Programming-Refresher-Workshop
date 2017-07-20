//This program is to calculate the sum of two numbers of any
//base from 2 to 10
//the sum will be in the same base as the two numbers
import java.util.Scanner;

public class Exe18{

    public static void main (String[] args) {
        int numA, numB, base;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a base b : ");
        base = scan.nextInt();

        System.out.print("Enter the first number : ");
        numA = scan.nextInt();

        System.out.print("Enter the second number : ");
        numB = scan.nextInt();

        //Fill in your code
        System.out.println("The sum is : " + sum(numA, numB, base));
    }

    //Fill in your code
    // Calculate the sum of the 2 numbers in their bases
    // Pre-Con: n1 > n2, n1 & n2 are valid base digits number, b is between 2 and 10 inclusive
    public static int sum(int n1, int n2, int b){
        int d1, d2, sum = 0, power = 0;
        if(n1 == 0)
            return n2;
        else if(n2 == 0)
            return n1;

        //Checks which number is larger
		if(n1 > n2){
            while(n1 > 0) {
                d1 = n1 % 10;
                d2 = n2 % 10;
                n1 = n1 / 10;
                n2 = n2 / 10;

                if ((d1 + d2) >= b) {
                    n1 += 1;
                    sum += (d1 + d2 - b) * Math.pow(10, power);
                } else {
                    sum += (d1 + d2) * Math.pow(10, power);
                }
                power++;
            }
        }else{
            while(n2 > 0) {
                d1 = n1 % 10;
                d2 = n2 % 10;
                n1 = n1 / 10;
                n2 = n2 / 10;

                if ((d1 + d2) >= b) {
                    n2 += 1;
                    sum += (d1 + d2 - b) * Math.pow(10, power);
                } else {
                    sum += (d1 + d2) * Math.pow(10, power);
                }
                power++;
            }
        }

        return sum;
    }
}
