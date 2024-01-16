package src;

import java.util.Arrays;
import java.util.Scanner;

public class P1253_Good_Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);
        int result = 0;

        for (int i = 0; i < N; i++) {
            if (isGoodNumber(arr, i, N)) {
                result++;
            }
        }

        System.out.println(result);
    }

    // 좋은 수인지 확인하는 함수
    static boolean isGoodNumber(long[] arr, int cur, int N) {
        int left = 0;
        int right = N - 1;

        while (left < right) {
            long sum = arr[left] + arr[right];

            if (sum == arr[cur]) {
                if (left != cur && right != cur) {
                    return true;
                } else {
                    left++;
                    right--;
                }
            } else if (sum < arr[cur]) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }
}
