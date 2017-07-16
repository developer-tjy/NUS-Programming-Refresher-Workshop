//Returns the root of a polynomial equation
import java.util.*;
import java.text.*;

class Exe6 {
    // EPSILON = difference between the two endpoint values;
    //           the threshold for loop to stop
    public static final double EPSILON = 0.0001;

    public static void main(String[] args) {
        int     c3, c2, c1, c0; // coefficients of polynomial
        double  a, b,           // endpoints
                pA, pB;         // function values at endpoints
        double  m, pM;          // midpoint and function value at midpoint

        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.000000");

        // Read inputs
        System.out.print("Enter coefficients (c3,c2,c1,c0) of polynomial: ");
        c3 = sc.nextInt();
        c2 = sc.nextInt();
        c1 = sc.nextInt();
        c0 = sc.nextInt();

        System.out.print("Enter endpoints a and b: ");
        a = sc.nextDouble();
        b = sc.nextDouble();

        // Fill in the computation below
        m = cal_root(a, b, c3, c2, c1, c0);
        pM = polynomial(m, c3, c2, c1, c0);
        // Print out answers
        System.out.println("root = " + df.format(m));
        System.out.println("p(root) = " + df.format(pM));
    }

    // This method returns the value of the polynomial
    //    p(x) = c3*x^3 + c2*x^2 + c1*x + c0
    public static double polynomial(double x, int c3, int c2, int c1, int c0) {

        // Replace the return value below with the correct expression
        double result = (c3 * Math.pow(x, 3)) + (c2 * Math.pow(x, 2)) + (c1 * x) + c0;
        return result;
    }

    //Find the root of the 2 numbers
    //Pre-Con: a and b > 0
    public static double cal_root(double a, double b, int c3, int c2, int c1, int c0){
        System.out.print(a + " " + b + " " + c1 + " " + c2 + " " + c3 + " "+ c0;
		double d = a - b;
        double m = (a+b) / 2;
		//Loops while the difference is always bigger than the threshold 
        while(Math.abs(d) > EPSILON){
            if(polynomial(m, c3, c2 ,c1, c0) == 0){
				break;
			
			//Check polynomial of a and mid value, and replace the value of a with mid has the same sign
			if((polynomial(a, c3, c2 ,c1, c0) > 0 && polynomial(m, c3, c2 ,c1, c0) > 0) || (polynomial(a, c3, c2 ,c1, c0) < 0 && polynomial(m, c3, c2 ,c1, c0) < 0)){
                a = m;
            }else{
                b = m;
            }
			
			//Recalculate the mid value and the difference between point a and b
            m = (a+b) / 2;
            d = a - b;
        }

        return m;
    }
}