import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    static class Edge {
        int u, v, weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    static class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n + 1]; // nodes are 1-based
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // path compression
            }
            return parent[x];
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }

        boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < gFrom.size(); i++) {
            edges.add(new Edge(gFrom.get(i), gTo.get(i), gWeight.get(i)));
        }

        // Sort by weight; tie-break by (u + v + weight)
        edges.sort((e1, e2) -> {
            if (e1.weight != e2.weight) {
                return e1.weight - e2.weight;
            } else {
                int sum1 = e1.u + e1.v + e1.weight;
                int sum2 = e2.u + e2.v + e2.weight;
                return sum1 - sum2;
            }
        });

        DSU dsu = new DSU(gNodes);
        int totalWeight = 0;
        int edgesUsed = 0;

        for (Edge edge : edges) {
            if (!dsu.connected(edge.u, edge.v)) {
                dsu.union(edge.u, edge.v);
                totalWeight += edge.weight;
                edgesUsed++;
                if (edgesUsed == gNodes - 1) {
                    break;
                }
            }
        }

        return totalWeight;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int gNodes = Integer.parseInt(gNodesEdges[0]);
        int gEdges = Integer.parseInt(gNodesEdges[1]);

        List<Integer> gFrom = new ArrayList<>();
        List<Integer> gTo = new ArrayList<>();
        List<Integer> gWeight = new ArrayList<>();

        for (int i = 0; i < gEdges; i++) {
            String[] edgeData = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            gFrom.add(Integer.parseInt(edgeData[0]));
            gTo.add(Integer.parseInt(edgeData[1]));
            gWeight.add(Integer.parseInt(edgeData[2]));
        }

        int result = Result.kruskals(gNodes, gFrom, gTo, gWeight);
        System.out.println(result);
    }
}
