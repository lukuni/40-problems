import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int[] remainderCounts = new int[k];

        // Count how many numbers have each remainder
        for (int num : s) {
            remainderCounts[num % k]++;
        }

        int result = 0;

        // At most one number with remainder 0 can be included
        if (remainderCounts[0] > 0) {
            result++;
        }

        // Loop from 1 to k/2 (inclusive only when k is even)
        for (int i = 1; i <= k / 2; i++) {
            if (i == k - i) {
                // If k is even, only one element from remainder k/2 can be chosen
                result += 1;
            } else {
                // Pick the larger count between remainder i and k-i
                result += Math.max(remainderCounts[i], remainderCounts[k - i]);
            }
        }

        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
