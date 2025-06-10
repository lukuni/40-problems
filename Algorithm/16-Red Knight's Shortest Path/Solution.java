import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
        // Directions in order of priority:
        String[] moves = {"UL", "UR", "R", "LR", "LL", "L"};
        int[] dRow = {-2, -2, 0, 2, 2, 0};
        int[] dCol = {-1, 1, 2, 1, -1, -2};

        boolean[][] visited = new boolean[n][n];
        // To reconstruct path, store previous cell and move that led here
        int[][] prevRow = new int[n][n];
        int[][] prevCol = new int[n][n];
        String[][] prevMove = new String[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(prevRow[i], -1);
            Arrays.fill(prevCol[i], -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i_start, j_start});
        visited[i_start][j_start] = true;

        boolean found = false;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            if (r == i_end && c == j_end) {
                found = true;
                break;
            }

            for (int k = 0; k < moves.length; k++) {
                int nr = r + dRow[k];
                int nc = c + dCol[k];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    prevRow[nr][nc] = r;
                    prevCol[nr][nc] = c;
                    prevMove[nr][nc] = moves[k];
                    queue.add(new int[]{nr, nc});
                }
            }
        }

        if (!found) {
            System.out.println("Impossible");
            return;
        }

        // Reconstruct path by backtracking from end to start
        List<String> path = new ArrayList<>();
        int cr = i_end, cc = j_end;

        while (cr != i_start || cc != j_start) {
            path.add(prevMove[cr][cc]);
            int pr = prevRow[cr][cc];
            int pc = prevCol[cr][cc];
            cr = pr;
            cc = pc;
        }

        Collections.reverse(path);

        System.out.println(path.size());
        System.out.println(String.join(" ", path));
    }
}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int i_start = Integer.parseInt(firstMultipleInput[0]);

        int j_start = Integer.parseInt(firstMultipleInput[1]);

        int i_end = Integer.parseInt(firstMultipleInput[2]);

        int j_end = Integer.parseInt(firstMultipleInput[3]);

        Result.printShortestPath(n, i_start, j_start, i_end, j_end);

        bufferedReader.close();
    }
}
