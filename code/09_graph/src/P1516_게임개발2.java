import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class P1516_게임개발2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] ability = new int[N];
        int[] distance = new int[N];
        ArrayList<Integer>[] dependencies = new ArrayList[N];
        ArrayList[] inbound = new ArrayList[N];
        for (int i = 0 ; i < N ; i++) {
            dependencies[i] = new ArrayList<Integer>();
            inbound[i] = new ArrayList<Integer>();
            distance[i] = 0;
        }
        for (int i = 0; i < N; i++)
        {
            int input_int = sc.nextInt();
            ability[i] = input_int;
            while ((input_int=sc.nextInt()) != -1){
                dependencies[input_int-1].add(i);
                inbound[i].add(input_int-1);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int idx = 0;
        for (ArrayList<Integer> single_inbound: inbound){
            if (single_inbound.size()==0)   {q.add(idx);    distance[idx] = ability[idx];}
            idx+=1;
        }
        while (!q.isEmpty()){
            int cur = q.poll();
            for (int dependency: dependencies[cur]) {
                if (distance[dependency] < distance[cur] + ability[dependency]) {
                    distance[dependency] = distance[cur] + ability[dependency];
                    q.add(dependency);
                }
            }
        }
        for (int dist : distance)
            System.out.println(dist);
    }
}
