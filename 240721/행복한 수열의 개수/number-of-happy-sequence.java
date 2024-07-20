import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] numbers = new int[N][N];
        for(int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++) {
                numbers[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        if(M==1) {
            System.out.println(N*2);
        } else {
            int ans = 0;

            //행 탐색
            for(int r=0; r<N; r++) {
                int com = numbers[r][0];
                int cnt = 1;

                for(int c=1; c<N; c++) {
                    if(numbers[r][c]==com) {
                        cnt++;

                        if(cnt>=M) {
                            ans++;
                            break;
                        }
                    } else {
                        com = numbers[r][c];
                        cnt=1;
                    }
                }
            }
            
            //열 탐색
            for(int c=0; c<N; c++) {
                int com = numbers[0][c];
                int cnt = 1;

                for(int r=1; r<N; r++) {
                    if(numbers[r][c]==com) {
                        cnt++;

                        if(cnt>=M) {
                            ans++;
                            break;
                        }
                    } else {
                        com = numbers[r][c];
                        cnt=1;
                    }
                }
            }

            System.out.println(ans);
        }
    }
}