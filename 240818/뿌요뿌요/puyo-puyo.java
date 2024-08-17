import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[][] num;
    public static boolean[][] visited;
    public static int max = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        num = new int[N][N];

        for(int r=0; r<N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int c=0; c<N; c++) {
                num[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][N];

        int pop = 0;
        int res = 1;
        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                if(!visited[r][c]) {
                    max = 1;
                    visited[r][c] = true;
                    search(r, c);
                    if(max>=4) {
                        pop++;
                    }
                    res = Math.max(max, res);
                }
            }
        }

        System.out.println(pop + " " + res);
    }

    public static void search(int r, int c) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for(int d=0; d<4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr>=0 && nr<N && nc>=0 && nc<N) {
                if(num[r][c] == num[nr][nc] && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    max++;
                    search(nr, nc);
                }
            }
        }
    }
}