import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[M];

        select(0, 1);

        System.out.println(sb.toString());
    }

    public static void select(int idx, int num) {
        if(idx==M) {
            for(int i=0; i<M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for(int i=num; i<=N; i++) {
            arr[idx] = i;
            select(idx+1, i+1);
        }
    }

}