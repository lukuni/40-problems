import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    public static int maxMin(int k, List<Integer> arr) {
        Collections.sort(arr);
        int minUnfairness = Integer.MAX_VALUE;

        for (int i = 0; i <= arr.size() - k; i++) {
            int unfairness = arr.get(i + k - 1) - arr.get(i);
            minUnfairness = Math.min(minUnfairness, unfairness);
        }

        return minUnfairness;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        int k = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());

        int result = Result.maxMin(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
