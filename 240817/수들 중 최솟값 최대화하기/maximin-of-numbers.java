import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[][] num;
    public static boolean[] visitedR;
    public static boolean[] visitedC;
    public static int[] arr;
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

        visitedR = new boolean[N];
        visitedC = new boolean[N];
        arr = new int[N];

        sketch(0, 0, 0);

        System.out.println(max);
    }

    public static void sketch(int idx, int r, int c) {
        if(idx==N) {
            int min = Integer.MAX_VALUE;
            for(int i=0; i<N; i++) {
                min = Math.min(min, arr[i]);
            }

            max = Math.max(min, max);
            return;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visitedR[i] && !visitedC[j]) {
                    arr[idx] = num[i][j];
                    visitedR[i] = true;
                    visitedC[j] = true;
                    sketch(idx+1, r+1, c+1);
                    visitedR[i] = false;
                    visitedC[j] = false;
                }
            }
        }
    }
}