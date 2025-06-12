import java.io.*;
import java.util.*;

class Result {

    // Directions for knight moves (both (a,b) and (b,a))
    static int[][] getMoves(int a, int b) {
        return new int[][]{
            { a,  b}, { a, -b}, {-a,  b}, {-a, -b},
            { b,  a}, { b, -a}, {-b,  a}, {-b, -a}
        };
    }

    // BFS to find the minimum steps to reach (n-1, n-1)
    static int bfs(int n, int a, int b) {
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        visited[0][0] = true;

        int[][] moves = getMoves(a, b);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], steps = current[2];

            if (x == n - 1 && y == n - 1) {
                return steps;
            }

            for (int[] move : moves) {
                int nx = x + move[0];
                int ny = y + move[1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, steps + 1});
                }
            }
        }
        return -1;
    }

    public static List<List<Integer>> knightlOnAChessboard(int n) {
        List<List<Integer>> result = new ArrayList<>();

        for (int a = 1; a < n; a++) {
            List<Integer> row = new ArrayList<>();
            for (int b = 1; b < n; b++) {
                row.add(bfs(n, a, b));
            }
            result.add(row);
        }

        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> result = Result.knightlOnAChessboard(n);

        for (List<Integer> row : result) {
            for (int i = 0; i < row.size(); i++) {
                bufferedWriter.write(row.get(i) + (i == row.size() - 1 ? "\n" : " "));
            }
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}