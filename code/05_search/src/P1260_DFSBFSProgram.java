import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1260_DFSBFSProgram {
    static boolean visited[];
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N];
        for (int i = 0 ; i < N; i++) arr[i] = new ArrayList<Integer>();
        for (int i = 0 ; i < M ; i ++)
        {
            st =new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            arr[src-1].add(dst-1);
            arr[dst-1].add(src-1);
        }
        for (int i = 0 ; i < N ; i++) Collections.sort(arr[i]);
        visited = new boolean[N];
        DFS(start-1);
        System.out.println();
        visited = new boolean[N];
        BFS(start-1);
        System.out.println();
    }
    public static void DFS(int Node){
        System.out.print(Node+1 + " ");
        visited[Node] = true;
        for(int i : arr[Node]){
            if (!visited[i])    DFS(i);
        }
    }

    public static void BFS(int Node){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(Node);
        visited[Node] = true;

        while (!queue.isEmpty()){
            int new_node = queue.poll();
            System.out.print(new_node+1+" ");
            for (int i : arr[new_node]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
