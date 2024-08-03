import java.io.*;
import java.util.*;

public class Main {
    public static int K;
    public static int N;
    public static int[] arr;
    // public static boolean[][] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        boolean[][] visited = new boolean[K][N];

        if(N==1) {
            for(int i=1; i<=K; i++) {
                sb.append(i).append("\n");
            }
        } else {
            select(0, visited);
        }

        System.out.println(sb.toString());
    }   

    public static void select(int cur, boolean[][] visited) {
        if(cur==N) {
            for(int i=0; i<arr.length; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for(int i=0; i<K; i++) {
            int res = check(visited, i);
            if(res!=N-1) {
                arr[cur] = i+1;
                visited[i][res] = true;
                select(cur+1, visited);
                visited[i][res] = false;
            }
        }
    }

    public static int check(boolean[][] visited, int r) {
        int cur = 0;
        for(int c=0; c<N; c++) {
            if(!visited[r][c]) {
                cur = c;
                break;
            }
        }
        return cur;
    }
}