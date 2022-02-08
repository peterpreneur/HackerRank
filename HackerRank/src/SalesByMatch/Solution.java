package SalesByMatch;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {
    public static void main(String[] args) throws IOException {
    	String home = System.getProperty("user.home");
    	File fIn = new File(home + File.separator + "Desktop" + File.separator + "JavaIn.txt");    	
    	File fOut = new File(home + File.separator + "Desktop" + File.separator + "JavaOut.txt");    	

    	//BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fIn));
        
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fOut));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

class Result {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        // Sort the original array
        Collections.sort(ar);
        int res = 0;
        int i = 0; 
 
        while (i < n) {
            // take first number
            int number = ar.get(i);
            int count = 1;
            i++;
 
            // Count all duplicates
            while (i < n && ar.get(i) == number) {
                count++;
                i++;
            }
             
            // If we spotted number just 2 times, increment result
            if (count >= 2) {
                res = res + count / 2;
            }
        }
        return res;
    }
}
