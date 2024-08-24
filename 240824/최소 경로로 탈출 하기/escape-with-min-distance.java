import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {0, 0, 0});

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        int max = -1;
        boolean[][] visited = new boolean[N][M];
        while(!que.isEmpty()) {
            int[] cur = que.poll();
            max = Math.max(cur[2], max);

            for(int d=0; d<4; d++) {
                int nr = dr[d] + cur[0];
                int nc = dc[d] + cur[1];

                if(nr>=0 && nr<N && nc>=0 && nc<M) {
                    if(map[nr][nc]==1 && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        que.offer(new int[] {nr, nc, cur[2]+1});
                    }
                }
            }
        }

        System.out.println(max);
    }
}