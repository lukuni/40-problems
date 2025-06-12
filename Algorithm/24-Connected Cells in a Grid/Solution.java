import java.io.*;
import java.util.*;

class Result {

    static final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static int connectedCell(List<List<Integer>> matrix) {
        if (matrix == null || matrix.isEmpty() || matrix.get(0).isEmpty()) return 0;

        int n = matrix.size();
        int m = matrix.get(0).size();
        boolean[][] visited = new boolean[n][m];
        int maxRegion = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 1 && !visited[i][j]) {
                    int size = bfs(matrix, visited, i, j);
                    maxRegion = Math.max(maxRegion, size);
                }
            }
        }
        return maxRegion;
    }

    private static int bfs(List<List<Integer>> matrix, boolean[][] visited, int x, int y) {
        int n = matrix.size();
        int m = matrix.get(0).size();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int size = 0;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            size++;

            for (int dir = 0; dir < 8; dir++) {
                int nx = cell[0] + dx[dir];
                int ny = cell[1] + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m &&
                    matrix.get(nx).get(ny) == 1 && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return size;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int m = Integer.parseInt(br.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().trim().split(" ");
            List<Integer> rowList = new ArrayList<>();
            for (String s : row) {
                rowList.add(Integer.parseInt(s));
            }
            matrix.add(rowList);
        }

        int result = Result.connectedCell(matrix);
        System.out.println(result);
    }
}


