import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    public static void countSort(List<List<String>> arr) {
        int n = arr.size();
        int half = n / 2;

        // Find max index
        int max = 0;
        for (List<String> pair : arr) {
            int x = Integer.parseInt(pair.get(0));
            if (x > max) {
                max = x;
            }
        }

        // Create buckets
        List<List<String>> buckets = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            buckets.add(new ArrayList<>());
        }

        // Fill buckets with proper values
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(arr.get(i).get(0));
            String value = (i < half) ? "-" : arr.get(i).get(1);
            buckets.get(x).add(value);
        }

        // Print the result
        StringBuilder result = new StringBuilder();
        for (List<String> bucket : buckets) {
            for (String s : bucket) {
                result.append(s).append(" ");
            }
        }

        System.out.println(result.toString().trim());
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                          .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.countSort(arr);

        bufferedReader.close();
    }
}
