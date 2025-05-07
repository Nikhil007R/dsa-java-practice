package Day2;

import java.util.Stack;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result12 {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        // Write your code here

        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){

            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                st.push(s.charAt(i));
            }

            else{
                if (st.isEmpty()) return "NO";

                char top = st.pop();
                if ((s.charAt(i) == ')' && top != '(') ||
                        (s.charAt(i) == '}' && top != '{') ||
                        (s.charAt(i) == ']' && top != '[')) {
                    return "NO";
                }
            }
        }
        return st.isEmpty() ? "YES" : "NO";
    }

}

public class IsBalancedParanthesis {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String s = bufferedReader.readLine();

            String result = Result12.isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}

