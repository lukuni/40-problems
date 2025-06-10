import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {
    private static int totalSum = 0;
    private static int minDiff = Integer.MAX_VALUE;
    private static List<List<Integer>> adj;
    private static int[] subtreeSum;

    public static int cutTheTree(List<Integer> data, List<List<Integer>> edges) {
        int n = data.size();

        totalSum = data.stream().mapToInt(i -> i).sum();

        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0) - 1;
            int v = edge.get(1) - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        subtreeSum = new int[n];

        dfs(0, -1, data);

        return minDiff;
    }

    private static int dfs(int node, int parent, List<Integer> data) {
        int currentSum = data.get(node);

        for (int child : adj.get(node)) {
            if (child != parent) {
                currentSum += dfs(child, node, data);
            }
        }

        subtreeSum[node] = currentSum;

        if (node != 0) {
            int diff = Math.abs(totalSum - 2 * currentSum);
            minDiff = Math.min(minDiff, diff);
        }

        return currentSum;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // Use System.out for local testing instead of file output
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> data = Stream.of(bufferedReader.readLine().trim().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        List<List<Integer>> edges = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            List<Integer> edge = Stream.of(bufferedReader.readLine().trim().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
            edges.add(edge);
        }

        int result = Result.cutTheTree(data, edges);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
