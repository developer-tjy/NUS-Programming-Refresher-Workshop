//Program get a multiple 3 digits input from the user will output the hidden 4th digit to the user
import java.util.*;

public class Exe1 {

    public static void main(String[] args)
    {		
       	int d1;
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            int[] entry = new int [3];

            entry[0] = sc.nextInt();
			//Checks if user wants to break the input
            if(entry[0] == -1){
                break;
            }
            entry[1] = sc.nextInt();
            entry[2] = sc.nextInt();

            System.out.print(findHiddenNum(entry) + "\n");
        }
    }

    //To find hidden number from 3 user input
    //Pre-Con: user_inputs > 0
    public static int findHiddenNum(int[] user_inputs){
        int sum = 0;
        int results = 0;
		//Loops through the 3 digits which is stored in an array
        for(int i = 0; i < user_inputs.length; i++){
            sum += user_inputs[i];
        }

        //Performs a loop till the sum is less than 9
		while(sum > 9){
            int quotient = sum / 10;
            int remainder = sum % 10;
            sum = quotient + remainder;
        }

        if (sum == 9) {
            results = sum;
        }else {
            results = 9 - sum;
        }

        return results;
    }
}

