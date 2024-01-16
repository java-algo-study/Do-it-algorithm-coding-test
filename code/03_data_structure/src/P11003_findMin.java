package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Deque;
import java.util.LinkedList;

public class P11003_findMin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int window_size = Integer.parseInt(input[1]);
        Deque<Node> minQueue = new LinkedList<>();

        String[] values = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(values[i]);
            while (!minQueue.isEmpty() && minQueue.getLast().value > cur) minQueue.removeLast();
            minQueue.addLast(new Node(cur, i));
            if (minQueue.getFirst().index <= i - window_size) minQueue.removeFirst();
            pw.print(minQueue.getFirst().value + " ");
        }

        pw.flush();
        pw.close();
        br.close();
    }

    static class Node {
        int value;
        int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
