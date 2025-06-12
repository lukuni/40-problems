import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    public static int surfaceArea(List<List<Integer>> A) {
        int H = A.size();
        int W = A.get(0).size();

        int surfaceArea = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                int current = A.get(i).get(j);

                if (current > 0) {
                    // Top and bottom faces
                    surfaceArea += 2;

                    // Adjacent cells: up, down, left, right
                    int up = (i > 0) ? A.get(i - 1).get(j) : 0;
                    int down = (i < H - 1) ? A.get(i + 1).get(j) : 0;
                    int left = (j > 0) ? A.get(i).get(j - 1) : 0;
                    int right = (j < W - 1) ? A.get(i).get(j + 1) : 0;

                    surfaceArea += Math.max(current - up, 0);
                    surfaceArea += Math.max(current - down, 0);
                    surfaceArea += Math.max(current - left, 0);
                    surfaceArea += Math.max(current - right, 0);
                }
            }
        }

        return surfaceArea;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = bufferedReader.readLine().trim().split(" ");
        int H = Integer.parseInt(firstLine[0]);
        int W = Integer.parseInt(firstLine[1]);

        List<List<Integer>> A = new ArrayList<>();

        for (int i = 0; i < H; i++) {
            String[] row = bufferedReader.readLine().trim().split(" ");
            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < W; j++) {
                rowList.add(Integer.parseInt(row[j]));
            }
            A.add(rowList);
        }

        int result = Result.surfaceArea(A);
        System.out.println(result);

        bufferedReader.close();
    }
}
