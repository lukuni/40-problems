import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'timeInWords' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER h
     *  2. INTEGER m
     */

    public static String timeInWords(int h, int m) {
        String[] words = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "quarter", "sixteen",
            "seventeen", "eighteen", "nineteen", "twenty", "twenty one", "twenty two",
            "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven",
            "twenty eight", "twenty nine", "half"
        };

        if (m == 0) {
            return words[h] + " o' clock";
        } else if (m == 15) {
            return "quarter past " + words[h];
        } else if (m == 30) {
            return "half past " + words[h];
        } else if (m == 45) {
            return "quarter to " + words[h + 1];
        } else if (m < 30) {
            return words[m] + (m == 1 ? " minute past " : " minutes past ") + words[h];
        } else {
            return words[60 - m] + ((60 - m) == 1 ? " minute to " : " minutes to ") + words[h + 1];
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = Integer.parseInt(bufferedReader.readLine().trim());
        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
