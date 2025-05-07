package Day2;

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

public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        long count = 0;
        Map<Long,Long> map1 = new HashMap<>();
        Map<Long,Long> map2 = new HashMap<>();
        for(int i=0;i<arr.size();i++){
            if(map2.containsKey(arr.get(i))){
                map2.put(arr.get(i),map2.get(arr.get(i))+1);
            }
            else{
                map2.put(arr.get(i),1L);
            }
        }
        for(int i=0;i<arr.size();i++){
            map2.put(arr.get(i),map2.get(arr.get(i))-1);
            if(arr.get(i)%r==0){
                long lc = map1.getOrDefault(arr.get(i)/r, 0L);
                long rc = map2.getOrDefault(arr.get(i)*r, 0L);
                count += lc*rc ;
            }
            if(map1.containsKey(arr.get(i))){
                map1.put(arr.get(i),map1.get(arr.get(i))+1);
            }
            else{
                map1.put(arr.get(i),1L);
            }
        }
        return count;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

