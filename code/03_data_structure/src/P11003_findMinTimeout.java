package src;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
public class P11003_findMinTimeout {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        int window_size = sc.nextInt();
        Deque<Node> q = new LinkedList<>();
        for (int i = 0 ; i < N; i++)
        {
            int cur = sc.nextInt();
            while (!q.isEmpty() && q.getLast().value>cur)   q.removeLast();
            q.addLast(new Node(cur, i));

            if (q.getFirst().index<=i-window_size)  q.removeFirst();
            bw.write(q.getFirst().value + " ");


        }
        bw.flush();
        bw.close();
    }

    static class Node{
        public int value;
        public int index;

        Node(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
}
