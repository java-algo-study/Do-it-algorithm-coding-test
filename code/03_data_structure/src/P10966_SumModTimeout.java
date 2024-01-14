package src;

import java.util.Scanner;

public class P10966_SumModTimeout {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N + 5];
        int counter = 0;
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i - 1] + sc.nextInt();
        }
        for (int i = 1 ; i <=N ; i++)
            for (int j =1 ; j <= N ; j++)
                if (i <= j)
                    if ((arr[j]-arr[i-1]) % M == 0)
                        counter+=1;
        System.out.println(counter);
    }
}
