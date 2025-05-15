package Day9;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    // Generate first q prime numbers
    private static int[] generatePrimeArray(int q) {
        int[] primes = new int[q];
        int count = 0;
        int num = 2;

        while (count < q) {
            boolean isPrime = true;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes[count++] = num;
            }
            num++;
        }

        return primes;
    }

    public static List<Integer> waiter(List<Integer> number, int q) {
        List<Integer> answer = new ArrayList<>();
        int[] primeArray = generatePrimeArray(q);

        Stack<Integer> curr = new Stack<>();
        for (int i = number.size() - 1; i >= 0; i--) {
            curr.push(number.get(i));
        }

        for (int i = 0; i < q; i++) {
            int prime = primeArray[i];
            Stack<Integer> A1 = new Stack<>();
            Stack<Integer> B1 = new Stack<>();

            while (!curr.isEmpty()) {
                int plate = curr.pop();
                if (plate % prime == 0) {
                    B1.push(plate);
                } else {
                    A1.push(plate);
                }
            }

            Stack<Integer> reverseB = new Stack<>();
            while (!B1.isEmpty()) {
                reverseB.push(B1.pop());
            }
            while (!reverseB.isEmpty()) {
                answer.add(reverseB.pop());
            }

            curr = A1;
        }

        Stack<Integer> reverseA = new Stack<>();
        while (!curr.isEmpty()) {
            reverseA.push(curr.pop());
        }
        while (!reverseA.isEmpty()) {
            answer.add(reverseA.pop());
        }

        return answer;
    }
}

public class Waiter {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().trim().split(" ");
        int n = Integer.parseInt(firstMultipleInput[0]);
        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> number = Arrays.stream(bufferedReader.readLine().trim().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = Result.waiter(number, q);

        for (int val : result) {
            System.out.println(val);
        }

        bufferedReader.close();
    }
}

