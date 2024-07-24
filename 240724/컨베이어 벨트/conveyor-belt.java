import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] arr = new int[2*N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=2*N-1; i>=N; i--) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<T; i++) {
            int tmp = arr[2*N-1];
            arr[2*N-1] = arr[N-1];

            for(int j=N-2; j>=0; j--) {
                arr[j+1] = arr[j];
            }

            arr[0] = arr[N];

            for(int j=N+1; j<2*N-1; j++) {
                arr[j-1] = arr[j];
            }

            arr[2*N-2] = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            sb.append(arr[i] + " ");
        }
        sb.append("\n");
        for(int i=2*N-1; i>=N; i--) {
            sb.append(arr[i] + " ");
        }

        System.out.println(sb.toString());
    }
}