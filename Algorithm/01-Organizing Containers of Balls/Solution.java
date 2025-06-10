import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

class Result {

    public static String organizingContainers(List<List<Integer>> container) {
        int n = container.size();
        int[] rowSums = new int[n]; // total balls in each container
        int[] colSums = new int[n]; // total balls of each type

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = container.get(i).get(j);
                rowSums[i] += val;
                colSums[j] += val;
            }
        }

        Arrays.sort(rowSums);
        Arrays.sort(colSums);

        for (int i = 0; i < n; i++) {
            if (rowSums[i] != colSums[i]) {
                return "Impossible";
            }
        }

        return "Possible";
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> container = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        container.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                String result = Result.organizingContainers(container);
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
