import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Result {
    public static String encryption(String s) {
        // Remove all spaces
        s = s.replaceAll("\\s", "");
        int length = s.length();

        // Calculate number of rows and columns
        int rows = (int) Math.floor(Math.sqrt(length));
        int cols = (int) Math.ceil(Math.sqrt(length));
        if (rows * cols < length) {
            rows++;
        }

        // Build encrypted string
        StringBuilder encrypted = new StringBuilder();
        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                int index = r * cols + c;
                if (index < length) {
                    encrypted.append(s.charAt(index));
                }
            }
            encrypted.append(' ');
        }

        return encrypted.toString().trim();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
            new InputStreamReader(System.in)
        );
        BufferedWriter bufferedWriter = new BufferedWriter(
            new OutputStreamWriter(System.out)
        );

        String s = bufferedReader.readLine();
        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
