import java.io.*;
import java.util.*;
import java.util.stream.*; // Necessary for Stream API usage in Solution class
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'truckTour' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
     */

    public static int truckTour(List<List<Integer>> petrolpumps) {
        int n = petrolpumps.size();
        
        // This variable will store the candidate for the starting petrol pump index.
        // We are looking for the *smallest* index.
        int start_index = 0;
        
        // current_petrol keeps track of the net petrol available in the tank
        // if we started at 'start_index' and traveled up to the current pump.
        // Use long to prevent potential integer overflow, as sums can exceed 2*10^9.
        long current_petrol = 0; 
        
        // total_petrol_deficit accumulates any negative balance encountered
        // before the current 'start_index'. This represents the 'debt' that
        // our chosen starting segment must eventually cover.
        long total_petrol_deficit = 0;

        // Iterate through each petrol pump.
        for (int i = 0; i < n; i++) {
            // Get petrol amount at current pump and distance to the next.
            long petrol_amount = petrolpumps.get(i).get(0);
            long distance_to_next = petrolpumps.get(i).get(1);
            
            // Calculate net gain/loss for this segment (petrol gained - petrol consumed).
            long net_gain = petrol_amount - distance_to_next;
            
            // Add the net gain to the current petrol balance.
            current_petrol += net_gain;
            
            // If current_petrol becomes negative, it means we ran out of fuel.
            // Our current 'start_index' is not a valid beginning.
            if (current_petrol < 0) {
                // Shift the starting point to the next pump (i + 1).
                start_index = i + 1;
                
                // Add the current negative balance to the total deficit.
                // This deficit must be covered by the petrol gained from the
                // segment starting at the new 'start_index'.
                total_petrol_deficit += current_petrol;
                
                // Reset current_petrol for the new potential journey.
                current_petrol = 0;
            }
        }

        // After iterating through all pumps, 'start_index' will hold the smallest
        // index from which the truck can complete the circle.
        // The problem guarantees that a solution always exists, so we don't
        // need to explicitly check if (total_petrol_deficit + current_petrol >= 0).
        return start_index;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // Using System.out for local testing instead of FileWriter directly, 
        // as FileWriter needs a valid path on the system.
        // For HackerRank, System.getenv("OUTPUT_PATH") would be used.
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out)); 

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> petrolpumps = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                petrolpumps.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.truckTour(petrolpumps);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}