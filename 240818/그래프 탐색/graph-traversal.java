import java.io.*;
import java.util.*;

public class Main {
    public static List<Integer>[] list;
    public static boolean[] visited;
    public static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new LinkedList[N+1];
        for(int i=0; i<N+1; i++) {
            list[i] = new LinkedList<>();
        }

        visited = new boolean[N+1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[start].add(end);
            list[end].add(start);
        }

        visited[1] = true;
        search(1);

        System.out.println(res);
    }

    public static void search(int num) {
        for(int i=0; i<list[num].size(); i++) {
            int cur = list[num].get(i);
            if(!visited[cur]) {
                visited[cur] = true;
                res++;
                search(cur);
            }
        }
    }
}