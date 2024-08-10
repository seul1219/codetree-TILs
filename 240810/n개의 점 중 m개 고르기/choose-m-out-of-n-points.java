import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static int[] x;
    public static int[] y;
    public static int[] arr;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        x = new int[N];
        y = new int[N];
        for(int t=0; t<N; t++) {
            st = new StringTokenizer(br.readLine());

            x[t] = Integer.parseInt(st.nextToken());
            y[t] = Integer.parseInt(st.nextToken());
        }

        arr = new int[M];

        sel(0, 0);

        System.out.println(min);
    }

    //선택
    public static void sel(int idx, int num) {
        if(idx==M) {
            min = Math.min(min, (int) cal());
            return;
        }

        for(int i=num; i<N; i++) {
            arr[idx] = i;
            sel(idx+1, i+1);
        }
    }

    //거리
    public static double cal() {
        double max = 0;
        for(int i=0; i<M; i++) {
            for(int j=i+1; j<M; j++) {
                max = Math.max(max, Math.pow(x[i]-x[j], 2) + Math.pow(y[i]-y[j], 2));
            }
        }
        return max;
    }
}