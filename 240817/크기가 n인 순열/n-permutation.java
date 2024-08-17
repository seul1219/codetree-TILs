import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] arr;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        visited = new boolean[N+1];

        select(0);
        System.out.println(sb.toString());
    }

    public static void select(int idx) {
        if(idx==N) {
            for(int i=0; i<N; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++) {
            if(!visited[i]) {
                arr[idx] = i;
                visited[i] = true;
                select(idx+1);
                visited[i] = false;
            }
        }
    }
}