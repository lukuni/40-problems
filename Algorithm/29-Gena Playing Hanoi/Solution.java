import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    public static int hanoi(List<Integer> posts) {
        return move(posts.size(), posts, 1, 2, 3, 4);
    }

    private static int move(int n, List<Integer> posts, int src, int aux1, int aux2, int dest) {
        if (n == 0) return 0;

        int pos = posts.get(n - 1);
        if (pos == src) {
            return move(n - 1, posts, src, dest, aux1, aux2);
        } else if (pos == dest) {
            return (1 << (n - 1)) + move(n - 1, posts, aux2, src, aux1, dest);
        } else {
            
            throw new IllegalStateException("Disk is in an unexpected rod: " + pos);
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> loc = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        int res = Result.hanoi(loc);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}




