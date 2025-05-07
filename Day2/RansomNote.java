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

class Result {

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note) {
        // Write your code here

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> notes = new HashMap<>();

        for(String s: magazine){
            if(map.containsKey(s)){
                map.put(s, map.get(s)+1);
            }
            else{
                map.put(s, 1);
            }
        }

        for(String s: note){
            if(notes.containsKey(s)){
                notes.put(s, notes.get(s)+1);
            }
            else{
                notes.put(s, 1);
            }
        }

        int flag = 1;

        // System.out.println(map);
        // System.out.println(notes);

        for(Map.Entry<String, Integer> i: notes.entrySet()){
            if(!map.containsKey(i.getKey()) ||
                    map.get(i.getKey()) < i.getValue()
            ){
                flag = 0;
                break;
            }
        }
        if(flag == 0){
            System.out.println("No");
        }
        else{
            System.out.println("Yes");
        }


    }

}

public class RansomNote {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        Result.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}

