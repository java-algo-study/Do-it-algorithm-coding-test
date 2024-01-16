package src;

import java.util.Scanner;
import java.util.Arrays;

public class P11399_ATMResponseTime {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N ; i++)    arr[i] = sc.nextInt();

        Arrays.sort(arr);
        int sum = 0;
        for(int i = 0 ; i < N ; i++)    sum+=arr[i]*(N-i);
        System.out.println(sum);
    }
}
