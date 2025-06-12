import java.io.*;
import java.util.*;

class Result {
    static class Edge {
        int from, to;
        Edge(int u, int v) {
            this.from = u;
            this.to = v;
        }
    }

    public static int crabGraphs(int n, int t, List<List<Integer>> graph) {
        int maxVirtualHeads = n * t;
        int totalNodes = n + maxVirtualHeads + 1; // +1 for 1-based indexing
        List<Integer>[] adj = new ArrayList[totalNodes];
        for (int i = 0; i < totalNodes; ++i)
            adj[i] = new ArrayList<>();

        int virtualHeadId = n + 1;

        // Create virtual head nodes for each head (up to t copies)
        for (List<Integer> edge : graph) {
            int u = edge.get(0);
            int v = edge.get(1);

            for (int i = 0; i < t; ++i) {
                adj[virtualHeadId + (u - 1) * t + i].add(v);
            }

            for (int i = 0; i < t; ++i) {
                adj[virtualHeadId + (v - 1) * t + i].add(u);
            }
        }

        int[] match = new int[n + 1]; // Foot node matched to which virtual head
        Arrays.fill(match, -1);

        boolean[] visited;
        int result = 0;

        for (int u = virtualHeadId; u < virtualHeadId + n * t; ++u) {
            visited = new boolean[n + 1]; // Only for feet nodes
            if (dfs(u, visited, adj, match)) {
                result++;
            }
        }

        return result;
    }

    private static boolean dfs(int u, boolean[] visited, List<Integer>[] adj, int[] match) {
        for (int v : adj[u]) {
            if (visited[v]) continue;
            visited[v] = true;
            if (match[v] == -1 || dfs(match[v], visited, adj, match)) {
                match[v] = u;
                return true;
            }
        }
        return false;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int c = Integer.parseInt(bufferedReader.readLine().trim());

        for (int cItr = 0; cItr < c; cItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            int n = Integer.parseInt(firstMultipleInput[0]);
            int t = Integer.parseInt(firstMultipleInput[1]);
            int m = Integer.parseInt(firstMultipleInput[2]);

            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                String[] edgeInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                int u = Integer.parseInt(edgeInput[0]);
                int v = Integer.parseInt(edgeInput[1]);
                graph.add(Arrays.asList(u, v));
            }

            int result = Result.crabGraphs(n, t, graph);
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}



