//Shows the number of candles that can be burned in total
import java.util.*;

class Exe5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k; // n = no. of candles; k = residuals to roll out a new candle

        System.out.print("Enter n and k: ");
        n = sc.nextInt();
        k = sc.nextInt();

        System.out.println("Total candles burnt = " + totalCandles(n, k) );
    }

    // Write your method below.
    // What is the pre-condition?
    //Takes n and k and output the number of candles that can be burned
    //Pre-Con: n and k > 0, n and k to be int value
    public static int totalCandles(int candlesAvailable, int noOfCandlesToMakeNew){
        int total = 0;
        int quotion = 0, remainder = 0;
        if(candlesAvailable < noOfCandlesToMakeNew || noOfCandlesToMakeNew == 0)
			//Check if residuals is more than the original candles or if the residuals is 0
            total = candlesAvailable;
        while(candlesAvailable >= noOfCandlesToMakeNew) {
			//quotion: gets new candles form by the residuals
			//remainder: gets the remainder of the candle from the original candles which cannot make any residuals
			//total: add the total candles - the remainder
			//candlesAvailable: set the number of full candles
            quotion = candlesAvailable / noOfCandlesToMakeNew;
            remainder = candlesAvailable % noOfCandlesToMakeNew;
            total += candlesAvailable - remainder;
            candlesAvailable = quotion + remainder;
        }
		//After not able to make candles from residuals, the remainder and the candles formed by the residuals will be added to the total number of candles
        total += quotion + remainder;
        return total;
    }
}
