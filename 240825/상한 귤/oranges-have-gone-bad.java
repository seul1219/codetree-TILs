import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        int[][] res = new int[N][N];
        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                res[r][c] = -2;
            }
        }
        
        Queue<int[]> que = new LinkedList<>();

        for(int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++) {
                int cur = Integer.parseInt(st.nextToken());
                map[r][c] = cur;
                if(map[r][c]==0) {
                    res[r][c] = -1;
                } else if(map[r][c]==2) {
                    res[r][c] = 0;
                    que.offer(new int[] {r, c, 0});
                } 
            }
        }

        boolean[][] visited = new boolean[N][N];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!que.isEmpty()) {
            int[] cur = que.poll();
            
            for(int d=0; d<4; d++) {
                int nr = dr[d] + cur[0];
                int nc = dc[d] + cur[1];

                if(nr>=0 && nr<N && nc>=0 && nc<N) {
                    if(!visited[nr][nc] && map[nr][nc]==1) {
                        visited[nr][nc] = true;
                        que.offer(new int[] {nr, nc, cur[2]+1});
                        res[nr][nc] = cur[2]+1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                sb.append(res[r][c]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}