package Day2;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class JavaHashset {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }


        Set<String> hs = new HashSet<>();
        for(int i=0; i<t; i++){

            StringBuilder sb = new StringBuilder();
            if(pair_left[i].compareTo(pair_right[i]) < 0){
                sb.append(pair_left[i] + " ");
                sb.append(pair_right[i]);
            }
            else{
                sb.append(pair_right[i] + " ");
                sb.append(pair_left[i]);
            }
            hs.add(sb.toString());

            System.out.println(hs.size());
        }

    }
}
