package Day1;

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

class arraymanipulation {

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // Write your code here

        long arr[] = new long[n+2];

        for (List<Integer> query : queries) {
            int a = query.get(0);
            int b = query.get(1);
            int k = query.get(2);

            arr[a-1] = arr[a-1] + k;
            if(b < n){
                arr[b] = arr[b] - k;
            }

        }

        long max = Long.MIN_VALUE;
        long sum = 0;
        for (long x : arr) {
            sum += x;
            if(max < sum){
                max = sum;
            }
        }
        return max;


        // int max = 0;
        // long arr[] = new long[n];
        // int currMax = 0;

        // for(int i=0; i<queries.size(); i++){

        //     int a = queries.get(i).get(0);
        //     int b = queries.get(i).get(1);
        //     int k = queries.get(i).get(2);

        //     for(int j=a-1; j<=b-1; j++){
        //         arr[j] = arr[j] + k;
        //         if(arr[j] > currMax){
        //             currMax = arr[j];
        //         }
        //     }

        //     if(max < currMax){
        //         max = currMax;
        //     }
        // }
        // return max;
    }

}

public class ArrayManipulation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = arraymanipulation.arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

