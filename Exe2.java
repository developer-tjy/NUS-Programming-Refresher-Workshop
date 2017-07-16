//Program get 2 input, the weight and height of the user and output a message based on the BMI categories of the user 
import java.util.*;

public class Exe2 {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            // read input, compute BMI and output
            int gender = sc.nextInt();
            double weight = sc.nextDouble();
            double height = sc.nextDouble();

            double bmi = cal_bmi(weight, height);

            if (gender == 0 && bmi <= 19 || gender == 1 && bmi <= 20) {
                System.out.println("You are underweight. Stuff yourself with more food!");
            } else if (gender == 0 && bmi <= 24 || gender == 1 && bmi <= 25) {
                System.out.println("Your weight is perfect. Maintain it!");
            }else if(gender == 0 && bmi > 24 || gender == 1 && bmi > 25){
                System.out.println("You are overweight, time to join the gym!");
            }else{
                System.out.println("Invalid Gender Type");
            }
        }
    }

    //Calculates the BMI of the user
	//Pre-Con: Height > 0
	public static double cal_bmi(double weight, double height){
        double bmi;
        bmi = weight / Math.pow(height,2);
        return bmi;
    }
}
