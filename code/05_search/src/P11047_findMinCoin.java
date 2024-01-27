import java.util.Scanner;

public class P11047_findMinCoin {
    static public void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int arr[] = new int[N];
        boolean flag = false;
        int ckpt = 0;
        int answer = 0;
        for (int i = 0 ; i < N ; i ++ ) {
            arr[i] = sc.nextInt();
            if (arr[i]>M && !flag) {
                flag = true;
                ckpt = i-1;
            }
        }
        for (int i = ckpt ; i >= 0; i--){
            answer += M / arr[i];
            M %= arr[i];
        }
        System.out.println(answer);
    }
}
