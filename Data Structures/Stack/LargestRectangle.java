import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {
        Stack<Integer> stk = new Stack<Integer>();

        long maxArea = 0;
        long area = 0;
        int i = 0;

        for(i = 0; i < h.length;){
            if(stk.isEmpty() || h[stk.peek()] <= h[i]){
                stk.push(i++);
            }else {
                int top = stk.pop();
                if(stk.isEmpty()){
                    area = (long)h[top] * i;
                }else {
                    area = (long)h[top] * (i - stk.peek() - 1);
                }

                if(area > maxArea){
                    maxArea = area;
                }
            }
        }

        while(!stk.isEmpty()){
            int top = stk.pop();
            if(stk.isEmpty()){
                    area = (long)h[top] * i;
                }else {
                    area = (long)h[top] * (i - stk.peek() - 1);
                }

                if(area > maxArea){
                    maxArea = area;
                }
        }
        return maxArea;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
