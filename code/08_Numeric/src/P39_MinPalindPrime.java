import java.util.Scanner;

public class P39_MinPalindPrime {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[10000001];
        for (int i = 2 ; i < A.length; i++)     A[i] = i;
        for (int i = 2; i < A.length ; i++) {
            if (A[i] == 0) continue;
            for (int j = 2*i; j < A.length ; j = j+i)A[j] = 0;
        }
        int i = N;
        while (true){
            if (A[i] == 0) continue;
            int result = A[i];
            if (isPalindrome(result)){
                System.out.println(result);
                System.exit(0);
            }
            i+=1;
        }
    }
    public static boolean isPalindrome(int number){
        char temp[] = String.valueOf(number).toCharArray();
        int s = 0;
        int e = temp.length-1;
        while (s<e){
            if (temp[s]!= temp[e]) return false;
            s++;
            e--;
        }
        return true;
    }
}
