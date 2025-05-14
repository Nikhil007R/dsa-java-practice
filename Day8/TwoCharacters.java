package Day8;

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
     * Complete the 'alternate' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternate(String s) {

        Set<Character> uc = new HashSet<>();
        for (char ch : s.toCharArray()) {
            uc.add(ch);
        }

        List<Character> chars = new ArrayList<>(uc);
        int maxLength = 0;
        // [a,b,e,f]

        for (int i = 0; i < chars.size(); i++) {
            for (int j = i + 1; j < chars.size(); j++) {
                // pair ka first and second element
                char first = chars.get(i);
                char second = chars.get(j);

                StringBuilder str = new StringBuilder();
                // meri string jisme basically mai only pairs wale char rkhaunga from my original string

                for (char ch : s.toCharArray()) {
                    if (ch == first || ch == second) {
                        str.append(ch);
                    }
                }

                if (isAlternating(str.toString())) {
                    maxLength = Math.max(maxLength, str.length());
                }
            }
        }

        return maxLength;
    }

    // check for alternating if(first element != second element)
    private static boolean isAlternating(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}

public class TwoCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = Result.alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

