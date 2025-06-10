import java.io.*;
import java.util.*;

public class Solution {

    static class DSU {
        int[] parent, size;

        DSU(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]]; // path compression
                x = parent[x];
            }
            return x;
        }

        void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB) {
                if (size[rootA] < size[rootB]) {
                    int temp = rootA;
                    rootA = rootB;
                    rootB = temp;
                }
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            }
        }

        int getSize(int x) {
            return size[find(x)];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int maxNode = 0;
        int[][] edges = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().trim().split(" ");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            edges[i][0] = u;
            edges[i][1] = v;
            if (u > maxNode) maxNode = u;
            if (v > maxNode) maxNode = v;
        }

        DSU dsu = new DSU(maxNode);

        for (int i = 0; i < n; i++) {
            dsu.union(edges[i][0], edges[i][1]);
        }

        Set<Integer> seen = new HashSet<>();
        List<Integer> componentSizes = new ArrayList<>();

        for (int i = 1; i <= maxNode; i++) {
            int root = dsu.find(i);
            if (!seen.contains(root)) {
                seen.add(root);
                int compSize = dsu.size[root];
                if (compSize > 1) { // exclude single nodes
                    componentSizes.add(compSize);
                }
            }
        }

        if (componentSizes.isEmpty()) {
            System.out.println("0 0");
            return;
        }

        int minSize = Collections.min(componentSizes);
        int maxSize = Collections.max(componentSizes);

        System.out.println(minSize + " " + maxSize);
    }
}
