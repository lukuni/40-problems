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

class Result {

    public static String biggerIsGreater(String w) {
        char[] chars = w.toCharArray();
        int i = chars.length - 2;

        // Step 1: Find the first decreasing element from the end
        while (i >= 0 && chars[i] >= chars[i + 1]) {
            i--;
        }

        if (i < 0) {
            return "no answer"; // No next permutation
        }

        // Step 2: Find the smallest character on right of i and greater than chars[i]
        int j = chars.length - 1;
        while (chars[j] <= chars[i]) {
            j--;
        }

        // Step 3: Swap
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;

        // Step 4: Reverse the substring after position i
        int start = i + 1;
        int end = chars.length - 1;
        while (start < end) {
            temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }

        return new String(chars);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = Result.biggerIsGreater(w);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}