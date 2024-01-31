import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import static java.lang.Math.max;


public class P1744_MaxbyClassify {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] dp = new int[N];
        for(int i = 0 ; i < N ; i++) arr[i] = sc.nextInt();

        dp[0] = arr[0];
        dp[1] = max(arr[0]+arr[1], arr[0]*arr[1]);
        for (int i = 2 ; i < N ; i++) dp[i] = max(dp[i-2]+arr[i-1]*arr[i], dp[i-1]+arr[i]);
        System.out.println(dp[N-1]);
    }
}
