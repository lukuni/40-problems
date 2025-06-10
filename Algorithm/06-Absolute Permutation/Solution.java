import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {

    public static List<Integer> absolutePermutation(int n, int k) {
        List<Integer> result = new ArrayList<>();

        if (k == 0) {
            for (int i = 1; i <= n; i++) {
                result.add(i);
            }
            return result;
        }

        if (n % (2 * k) != 0) {
            result.add(-1);
            return result;
        }

        boolean add = true;
        for (int i = 1; i <= n; i++) {
            if (add) {
                result.add(i + k);
            } else {
                result.add(i - k);
            }

            if (i % k == 0) {
                add = !add;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        // Example to test:
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int i = 0; i < t; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            List<Integer> res = absolutePermutation(n, k);

            if (res.size() == 1 && res.get(0) == -1) {
                System.out.println("-1");
            } else {
                System.out.println(res.stream().map(Object::toString).collect(Collectors.joining(" ")));
            }
        }

        bufferedReader.close();
    }
}
