import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    public static int pairs(int k, List<Integer> arr) {
        Set<Integer> numbers = new HashSet<>(arr);
        int count = 0;

        for (int num : arr) {
            if (numbers.contains(num + k)) {
                count++;
            }
        }

        return count;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().trim().split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().trim().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        int result = Result.pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
