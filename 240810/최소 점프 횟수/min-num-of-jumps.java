import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] arr;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        move(0, arr[0], 0);

        if(min!=Integer.MAX_VALUE) {
            System.out.println(min);
        } else {
            System.out.println(-1);
        }
    }

    public static void move(int idx, int num, int cnt) {
        if(idx==N-1) {
            min = Math.min(min, cnt);
            return;
        }

        for(int i=1; i<=num; i++) {
            if(idx+i<N) {
                move(idx+i, arr[idx+i], cnt+1);
            }
        }
    }
}