import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[N][M];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {0, 0});
        visited[0][0] = true;

        boolean flag = false;
        while(!que.isEmpty()) {
            int[] cur = que.poll();
            if(cur[0]==N-1 && cur[1]==M-1) {
                flag = true;
                break;
            }

            for(int d=0; d<4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if(nr>=0 && nr<N && nc>=0 && nc<M) {
                    if(map[nr][nc]==1 && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        que.offer(new int[] {nr, nc});
                    }
                }
            }
        }

        if(flag) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}