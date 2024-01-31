import java.util.Scanner;

public class P1715_SortingCard {
    static public void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer= 0;
        int[] arr = new int[N];
        for (int i = 0 ; i < N ; i++){
            arr[i] = sc.nextInt();
        }
        for (int i = 0 ; i < N ; i++)   answer+=(arr[i] * (N-i));
        answer-=arr[0];
        System.out.println(answer);
    }
}
