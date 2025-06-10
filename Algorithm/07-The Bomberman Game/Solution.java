import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static List<String> bomberMan(int n, List<String> grid) {
        if (n == 1) return grid;

        int rows = grid.size();
        int cols = grid.get(0).length();

        List<String> fullGrid = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            char[] row = new char[cols];
            Arrays.fill(row, 'O');
            fullGrid.add(new String(row));
        }

        if (n % 2 == 0) return fullGrid;

        List<String> firstExplosion = detonate(grid);
        if (n % 4 == 3) return firstExplosion;

        return detonate(firstExplosion);
    }

    private static List<String> detonate(List<String> grid) {
        int rows = grid.size();
        int cols = grid.get(0).length();
        char[][] result = new char[rows][cols];

        // Fill with bombs
        for (int i = 0; i < rows; i++) {
            Arrays.fill(result[i], 'O');
        }

        // Detonate bombs from original grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid.get(i).charAt(j) == 'O') {
                    result[i][j] = '.';
                    if (i > 0) result[i - 1][j] = '.';
                    if (i < rows - 1) result[i + 1][j] = '.';
                    if (j > 0) result[i][j - 1] = '.';
                    if (j < cols - 1) result[i][j + 1] = '.';
                }
            }
        }

        List<String> explodedGrid = new ArrayList<>();
        for (char[] row : result) {
            explodedGrid.add(new String(row));
        }

        return explodedGrid;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int r = Integer.parseInt(firstMultipleInput[0]);
        int c = Integer.parseInt(firstMultipleInput[1]);
        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = IntStream.range(0, r).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).collect(toList());

        List<String> result = Result.bomberMan(n, grid);

        bufferedWriter.write(result.stream().collect(joining("\n")) + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
