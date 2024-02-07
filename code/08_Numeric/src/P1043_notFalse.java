import java.util.*;
import java.util.HashMap;
public class P1043_notFalse {

    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int T = sc.nextInt();
        arr = new int[N];
        int[] truthUser = new int[T];
        boolean[] visited = new boolean[N];
        for (int i = 0; i < T; i++) truthUser[i] = sc.nextInt();
        // 1. Graph를 생성한 후 -> BFS 돌린 후 visited 조사하면 끝!
        // Graph 생성 : 1. Adjacency List(Hashmap) / 2. Adjacency Matrix
        int[] brr;
        for (int i = 0; i < M; i++) {
            int group_num = sc.nextInt();
            brr = new int[group_num];
            for (int j = 0; j < group_num; j++) brr[j] = sc.nextInt()-1;
            makeParentinCompleteGraph(brr);
        }
        for (int user : truthUser) {
            int idx = arr[user];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == idx) visited[i] = true;
            }
        }
        int cnt = 0;
        for (int i = 0 ; i < N ; i++) {
            if (visited[i]) cnt += 1;
        }
        System.out.println(N-cnt);

    }

    static void makeParentinCompleteGraph(int[] users) {
        for (int i = 0 ; i < users.length;i++)
            for (int j = 0 ; j < users.length; j++)
                union(users[i], users[j]);
    }

    static int findParent(int i) {
        if (arr[i] == i) return i;
        return arr[i] = findParent(arr[i]);
    }
    static void union(int user1, int user2) {
        /*
        description: merge user2's group into user1`s group
         */

        arr[findParent(user2)] = findParent(user1);
    }


    }

