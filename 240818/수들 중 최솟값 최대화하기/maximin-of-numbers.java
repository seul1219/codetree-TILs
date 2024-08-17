import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[][] num;
    public static boolean[] visitedC;
    public static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        num = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visitedC = new boolean[N];

        sketch(0, Integer.MAX_VALUE);

        System.out.println(max);
    }

    public static void sketch(int idx, int min) {
        if (idx==N) {
            max = Math.max(max, min);
            return;
        }

        for (int j=0; j<N; j++) {
            if (!visitedC[j]) {
                visitedC[j] = true;
                sketch(idx+1, Math.min(min, num[idx][j]));
                visitedC[j] = false;
            }
        }
    }
}