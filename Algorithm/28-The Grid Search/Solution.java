import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {
    public static String gridSearch(List<String> G, List<String> P) {
        int R = G.size();       // Rows in grid
        int C = G.get(0).length(); // Columns in grid
        int r = P.size();       // Rows in pattern
        int c = P.get(0).length(); // Columns in pattern

        for (int i = 0; i <= R - r; i++) {
            for (int j = 0; j <= C - c; j++) {
                boolean found = true;

                for (int x = 0; x < r; x++) {
                    if (!G.get(i + x).substring(j, j + c).equals(P.get(x))) {
                        found = false;
                        break;
                    }
                }

                if (found) {
                    return "YES";
                }
            }
        }

        return "NO";
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                int R = Integer.parseInt(firstMultipleInput[0]);
                int C = Integer.parseInt(firstMultipleInput[1]);

                List<String> G = IntStream.range(0, R).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }).collect(Collectors.toList());

                String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                int r = Integer.parseInt(secondMultipleInput[0]);
                int c = Integer.parseInt(secondMultipleInput[1]);

                List<String> P = IntStream.range(0, r).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }).collect(Collectors.toList());

                String result = Result.gridSearch(G, P);
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


