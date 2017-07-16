//Counts the number of up slopes in the input given by the user
import java.util.*;

public class Exe4 {

    public static void main(String[] args) {

        System.out.println("Enter data:");

        System.out.println("Number of up-slopes = " + compute_upslopes());
    }

    // This function reads the input data, computes the number
    // of up-slopes and returns the answer.
    public static int compute_upslopes() {
        int up_slopes = 0;
        Scanner sc = new Scanner(System.in);
        double currentNum = sc.nextDouble();
        if (currentNum <= 0) return up_slopes;
        double nextNum = sc.nextDouble();
        while(nextNum >= 0){
            /*
				Changes that can be made:
					Use a boolean flag, "onUpSlope", to check if you are on an up slope
					If you are starting to go on a up slope, change flag to true, increment up up slope
					Change the flag back to false when height is less than or equals to previous height
			*/
			//Loops increment the up slope after all the if the slopes starts to go down or flatten
			while(currentNum < nextNum){
                currentNum = nextNum;
                nextNum = sc.nextDouble();
                if(nextNum <= 0) {
                    up_slopes += 1;
                    return up_slopes;
                }
				//If it is going down slope or same plane, after the continuous up slope
                if(currentNum >= nextNum) {
                    up_slopes += 1;
                }
            }
            currentNum = nextNum;
            nextNum = sc.nextDouble();
            if (nextNum <= 0) break;
            //continue;
        }
        // The return value below is to be replaced by the correct answer
        return up_slopes;
    }
}
