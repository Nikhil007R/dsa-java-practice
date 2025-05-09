package Day3;

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

    /*
     * Complete the 'largestRectangle' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY h as parameter.
     */

    public static long largestRectangle(List<Integer> h) {
        // Write your code here

        Stack<Integer> stack = new Stack<>();
        int n = h.size();
        long maxArea = 0;
        int i = 0;

        while (i < n) {
            // If stack is empty or current height is >= top of stack
            if (stack.isEmpty() || h.get(i) >= h.get(stack.peek())) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                long area = (long) h.get(top)* width;
                maxArea = Math.max(maxArea, area);
            }
        }

        // Process remaining elements in stack
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            long area = (long) h.get(top) * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;


        // long maxArea = 0;  BRUTE FORCE

        // for(int i=0; i<h.size(); i++){
        //     long minimum = h.get(i);
        //     for(int j=i; j<h.size(); j++){
        //         if(minimum > h.get(j)){
        //             minimum = h.get(j);
        //         }
        //         long width = j-i+1;
        //         if(width * minimum > maxArea){
        //             maxArea = width * minimum;
        //         }

        //     }
        // }
        // return maxArea;
    }

}

public class LargestRectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        long result = Result.largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

