import java.io.*;
import java.util.*;

public class Main {
    public static int K;
    public static int N;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        select(0);

        System.out.println(sb.toString());
    }

    public static void select(int cnt) {
        if(cnt==N) {
            for(int i=0; i<arr.length; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=K; i++) {
            arr[cnt] = i;
            select(cnt+1);
        } 
    }
}