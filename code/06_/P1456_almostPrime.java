    import java.util.*;

    public class P1456_almostPrime {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int M = sc.nextInt();

            ArrayList<Integer> primes = new ArrayList<>();
            for (int i = 2; i <= M; i++) {
                if (isPrime(i)) primes.add(i);
            }

            int answer = 0;
            for (int prime : primes) {
                long almostPrime = prime;
                while ((almostPrime *= prime) <= M) {
                    if (almostPrime >= N) answer++;
                }
            }
            System.out.println(answer);
        }

        public static boolean isPrime(int num) {
            if (num == 2) return true;
            if (num < 2 || num % 2 == 0) return false;
            for (int i = 3; i * i <= num; i += 2) {
                if (num % i == 0) return false;
            }
            return true;
        }
    }
