import java.io.*;
import java.util.*;

public class Solution {

    private static final int[] dRow = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] dCol = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] line = bufferedReader.readLine().trim().split(" ");
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(Integer.parseInt(line[j]));
            }
            matrix.add(row);
        }
        bufferedReader.close();

        System.out.println(connectedCell(matrix));
    }

    public static int connectedCell(List<List<Integer>> matrix) {
        int n = matrix.size();
        if (n == 0) return 0;
        int m = matrix.get(0).size();

        boolean[][] visited = new boolean[n][m];
        int maxRegion = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 1 && !visited[i][j]) {
                    int size = dfs(matrix, visited, i, j, n, m);
                    maxRegion = Math.max(maxRegion, size);
                }
            }
        }
        return maxRegion;
    }

    private static int dfs(List<List<Integer>> matrix, boolean[][] visited, int row, int col, int n, int m) {
        visited[row][col] = true;
        int count = 1;

        for (int k = 0; k < 8; k++) {
            int newRow = row + dRow[k];
            int newCol = col + dCol[k];

            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                if (matrix.get(newRow).get(newCol) == 1 && !visited[newRow][newCol]) {
                    count += dfs(matrix, visited, newRow, newCol, n, m);
                }
            }
        }
        return count;
    }
}
