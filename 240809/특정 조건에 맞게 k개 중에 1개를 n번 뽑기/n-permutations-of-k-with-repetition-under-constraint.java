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

        select(0, 0, 1);

        System.out.println(sb.toString());
    }   

    //숫자 고르기
    public static void select(int idx, int num, int con) {
        if(idx==N) {
            for(int i=0; i<arr.length; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for(int i=1; i<=K; i++) {
            //처음이거나 연속이 아니면
            if(idx==0 || num!=i) {
                arr[idx]=i;
                select(idx+1, i, 1);
            }

            //3번 연속 아니면
            if(num==i && con<2) {
                arr[idx]=i;
                select(idx+1, i, con+1);
            }
        }
    }
}