import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());		
		int N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];
        for(int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

	    int[] drr = {-1, 0, 1};
        int ans = 0;
        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {        
                int cnt = 0;

                for(int dr=0; dr<3; dr++) {
                    int nr = r + drr[dr];

                    for(int dc=0; dc<3; dc++) {
                        int nc = c + drr[dc];

                        if(nr<N && nr>=0 && nc<N && nc>=0) {
                            cnt += arr[nr][nc];
                        }
                    }               
                }

                ans = Math.max(ans, cnt);
            }
        }

        System.out.println(ans);
    }
}