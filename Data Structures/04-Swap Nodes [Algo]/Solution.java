import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'swapNodes' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY indexes
     *  2. INTEGER_ARRAY queries
     */
    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
        int n = indexes.size();

        // Store children for each node (1-based index)
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];

        for (int i = 0; i < n; i++) {
            left[i + 1] = indexes.get(i).get(0);
            right[i + 1] = indexes.get(i).get(1);
        }

        // Calculate depth for each node using BFS
        int[] depth = new int[n + 1];
        Arrays.fill(depth, 0);
        depth[1] = 1;  // root depth = 1
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (left[node] != -1) {
                depth[left[node]] = depth[node] + 1;
                queue.add(left[node]);
            }
            if (right[node] != -1) {
                depth[right[node]] = depth[node] + 1;
                queue.add(right[node]);
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        // For each query k, swap subtrees of nodes at depths multiple of k
        for (int k : queries) {
            for (int i = 1; i <= n; i++) {
                if (depth[i] != 0 && depth[i] % k == 0) {
                    // Swap children of node i
                    int temp = left[i];
                    left[i] = right[i];
                    right[i] = temp;
                }
            }

            List<Integer> traversal = new ArrayList<>();
            inorderTraversal(1, left, right, traversal);
            result.add(traversal);
        }

        return result;
    }

    // Standard inorder traversal that skips null nodes (-1)
    private static void inorderTraversal(int node, int[] left, int[] right, List<Integer> output) {
        if (node == -1) return;

        inorderTraversal(left[node], left, right, output);
        output.add(node);
        inorderTraversal(right[node], left, right, output);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> indexes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> row = Arrays.stream(bufferedReader.readLine().trim().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
            indexes.add(row);
        }

        int t = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> queries = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            queries.add(Integer.parseInt(bufferedReader.readLine().trim()));
        }

        List<List<Integer>> result = Result.swapNodes(indexes, queries);

        // Print the output as requested: each traversal on its own line, values space-separated
        for (List<Integer> traversal : result) {
            for (int i = 0; i < traversal.size(); i++) {
                if (i > 0) bufferedWriter.write(" ");
                bufferedWriter.write(String.valueOf(traversal.get(i)));
            }
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
