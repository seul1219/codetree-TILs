import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        String[] srr = {"push_back", "pop_back", "size", "get"};
        for(int t=0; t<N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.equals(srr[0])) {
                int num = Integer.parseInt(st.nextToken());
                list.add(num);
            } else if(str.equals(srr[1])) {
                list.remove(list.size()-1);
            } else if(str.equals(srr[2])) {
                System.out.println(list.size());
            } else {
                int num = Integer.parseInt(st.nextToken());
                System.out.println(list.get(num-1));
            }
        }
    }
}