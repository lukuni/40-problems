import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Result {

    public static void almostSorted(List<Integer> arr) {
        int n = arr.size();
        List<Integer> sorted = new ArrayList<>(arr);
        Collections.sort(sorted);

        List<Integer> diffIndices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!arr.get(i).equals(sorted.get(i))) {
                diffIndices.add(i);
            }
        }

        if (diffIndices.isEmpty()) {
            System.out.println("yes");
        } else if (diffIndices.size() == 2) {
            System.out.println("yes");
            System.out.println("swap " + (diffIndices.get(0) + 1) + " " + (diffIndices.get(1) + 1));
        } else {
            int l = diffIndices.get(0);
            int r = diffIndices.get(diffIndices.size() - 1);

            List<Integer> reversed = new ArrayList<>(arr);
            while (l < r) {
                int temp = reversed.get(l);
                reversed.set(l, reversed.get(r));
                reversed.set(r, temp);
                l++;
                r--;
            }

            if (reversed.equals(sorted)) {
                System.out.println("yes");
                System.out.println("reverse " + (diffIndices.get(0) + 1) + " " + (diffIndices.get(diffIndices.size() - 1) + 1));
            } else {
                System.out.println("no");
            }
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().trim().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        Result.almostSorted(arr);

        bufferedReader.close();
    }
}
