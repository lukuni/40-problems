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

    public static int quickestWayUp(List<List<Integer>> ladders, List<List<Integer>> snakes) {
        
        int[] board = new int[101];
        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }

        for (List<Integer> ladder : ladders) {
            board[ladder.get(0)] = ladder.get(1);
        }

        for (List<Integer> snake : snakes) {
            board[snake.get(0)] = snake.get(1);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[101];
        int[] dist = new int[101];

        queue.add(1);
        visited[1] = true;
        dist[1] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            
            if (curr == 100) {
                return dist[100];
            }

            for (int dice = 1; dice <= 6; dice++) {
                int next = curr + dice;
                if (next <= 100) {
                    int destination = board[next];
                    if (!visited[destination]) {
                        visited[destination] = true;
                        dist[destination] = dist[curr] + 1;
                        queue.add(destination);
                    }
                }
            }
        }

        return -1;
    }
}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> ladders = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        ladders.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int m = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> snakes = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        snakes.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int result = Result.quickestWayUp(ladders, snakes);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}



