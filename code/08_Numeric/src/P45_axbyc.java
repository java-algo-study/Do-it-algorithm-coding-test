import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

public class P45_axbyc {
    static Stack<Tuple> stack = new Stack<>();

    // 데이터를 저장할 클래스 정의
    static class Tuple {
        int a, b, c, d;

        Tuple(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        int getA() {
            return this.a;
        }

        int getC() {
            return this.c;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            BigInteger tempA = BigInteger.valueOf(A);
            BigInteger tempB = BigInteger.valueOf(B);
            BigInteger tempGcd = tempA.gcd(tempB);
            int gcd = tempGcd.intValue();
            if (C % gcd != 0) {
                System.out.println("-1");
                System.exit(0);
            }
            writeGcdHistory(A, B);
//            System.out.println(stack);
            Tuple returnTuple = reverseGcd();
            System.out.println(returnTuple.getA()*C + " " + returnTuple.getC()*C);

        }

        public static void writeGcdHistory(int A, int B) {
            int divisor = A / B;
            int remain = A % B;
            while (remain != 0) {
                stack.push(new Tuple(A, B, divisor, remain));
                System.out.println("Pushed"+A+" "+ " "+B + " "+ divisor + " "+ remain);
                A = B;
                B = remain;
                divisor = A / B;
                remain = A % B;

            }
        }

        public static Tuple reverseGcd() {
            int A = 0;
            int C = 1;
            while (!stack.isEmpty()) {
                Tuple currentElement = stack.pop();
                int tmpA = A;
                A = C;
                C = tmpA + C * -1 * currentElement.getC();
                System.out.println(" "+A+" "+C);
            }
            return new Tuple(A, 0, C, 0);
        }
    }
}