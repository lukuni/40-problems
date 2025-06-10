import java.io.*;
import java.util.*;
import java.util.stream.*; // Keep this import for the Solution class
import java.util.Deque;    // Add this import for Deque interface
import java.util.ArrayDeque; // Add this import for ArrayDeque implementation

class Result {

    private static List<Integer> generatePrimes(int q) {
        List<Integer> primes = new ArrayList<>();
        int num = 2;
        while (primes.size() < q) {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(num);
            }
            num++;
        }
        return primes;
    }

    public static List<Integer> waiter(List<Integer> number, int q) {
        List<Integer> result = new ArrayList<>();
        List<Integer> primes = generatePrimes(q);

        // Use ArrayDeque instead of Stack for better performance
        Deque<Integer> A = new ArrayDeque<>();
        for (int plate : number) {
            A.push(plate); // push adds to the "top" of the deque
        }

        for (int i = 0; i < q; i++) {
            Deque<Integer> Anew = new ArrayDeque<>(); // New ArrayDeque for each iteration
            Deque<Integer> B = new ArrayDeque<>();
            int prime = primes.get(i);

            while (!A.isEmpty()) {
                int plate = A.pop(); // pop removes from the "top" of the deque
                if (plate % prime == 0) {
                    B.push(plate);
                } else {
                    Anew.push(plate);
                }
            }

            while (!B.isEmpty()) {
                result.add(B.pop());
            }

            A = Anew; // Anew becomes the new A for the next iteration
        }

        while (!A.isEmpty()) {
            result.add(A.pop());
        }

        return result;
    }
}

// Your Solution class remains the same for input/output handling
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> number = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        List<Integer> result = Result.waiter(number, q);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}