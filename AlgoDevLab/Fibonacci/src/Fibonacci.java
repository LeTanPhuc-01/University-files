import java.util.HashMap;
import java.util.Scanner;

public class Fibonacci {
    static float fibonacciDP(int n){
        HashMap<Integer, Integer> memo = new HashMap<>();
        // Set F(0) and F(1) in the table
        memo.put(0, 0);
        memo.put(1, 1);
        // Loop from 2 to n
        for(int i = 2; i <= n; i ++){
            memo.put(i, memo.get(i-1) + memo.get(i-2));
        }
        return memo.get(n);
    }
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the nth Fibonacci: ");
        int n = scanner.nextInt();
        System.out.println("The " + n + "th Fibonacci number is: " + fibonacciDP(n));
        scanner.close();
    }
}
