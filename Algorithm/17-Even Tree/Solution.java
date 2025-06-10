import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {

    static int evenForest(int t_nodes, int t_edges, List<Integer> t_from, List<Integer> t_to) {
        // Build the undirected graph (tree)
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= t_nodes; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < t_edges; i++) {
            int u = t_from.get(i);
            int v = t_to.get(i);
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        boolean[] visited = new boolean[t_nodes + 1];
        int[] removableEdges = {0};

        dfs(1, tree, visited, removableEdges);

        return removableEdges[0];
    }

    private static int dfs(int node, List<List<Integer>> tree, boolean[] visited, int[] removableEdges) {
        visited[node] = true;
        int subtreeNodeCount = 1;

        for (int neighbor : tree.get(node)) {
            if (!visited[neighbor]) {
                int childCount = dfs(neighbor, tree, visited, removableEdges);
                if (childCount % 2 == 0) {
                    removableEdges[0]++;
                } else {
                    subtreeNodeCount += childCount;
                }
            }
        }

        return subtreeNodeCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] tNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int tNodes = Integer.parseInt(tNodesEdges[0]);
        int tEdges = Integer.parseInt(tNodesEdges[1]);

        List<Integer> tFrom = new ArrayList<>();
        List<Integer> tTo = new ArrayList<>();

        IntStream.range(0, tEdges).forEach(i -> {
            try {
                String[] tFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                tFrom.add(Integer.parseInt(tFromTo[0]));
                tTo.add(Integer.parseInt(tFromTo[1]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = evenForest(tNodes, tEdges, tFrom, tTo);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
