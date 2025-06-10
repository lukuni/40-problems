import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int test = 0; test < t; test++) {
            String[] dims = sc.nextLine().split(" ");
            int n = Integer.parseInt(dims[0]);
            int m = Integer.parseInt(dims[1]);

            List<String> matrix = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                matrix.add(sc.nextLine());
            }

            int k = Integer.parseInt(sc.nextLine());

            String result = Result.countLuck(matrix, k);
            System.out.println(result);
        }
    }
}

class Result {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static String countLuck(List<String> matrix, int k) {
        int n = matrix.size();
        int m = matrix.get(0).length();
        char[][] grid = new char[n][m];
        boolean[][] visited = new boolean[n][m];

        int startX = 0, startY = 0;

        for (int i = 0; i < n; i++) {
            String row = matrix.get(i);
            for (int j = 0; j < m; j++) {
                grid[i][j] = row.charAt(j);
                if (grid[i][j] == 'M') {
                    startX = i;
                    startY = j;
                }
            }
        }

        int waves = dfs(grid, visited, startX, startY, 0);
        return waves == k ? "Impressed" : "Oops!";
    }

    static int dfs(char[][] grid, boolean[][] visited, int x, int y, int count) {
        if (grid[x][y] == '*') return count;

        visited[x][y] = true;
        List<int[]> options = new ArrayList<>();

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length &&
                grid[nx][ny] != 'X' && !visited[nx][ny]) {
                options.add(new int[]{nx, ny});
            }
        }

        if (options.size() > 1) count++;

        for (int[] opt : options) {
            int result = dfs(grid, visited, opt[0], opt[1], count);
            if (result != -1) return result;
        }

        return -1;
    }
}
