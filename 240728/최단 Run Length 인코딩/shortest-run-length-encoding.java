import java.io.*;
import java.util.*;

public class Main {
    public static int len = 0;
    public static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        len = str.length();
        for(int i=0; i<len; i++) {
            stack.push(str.charAt(i));
        }

        int ans = Integer.MAX_VALUE;
        int cnt = 0;
        while(cnt<len) {
            if(cnt>0) {
                str = shift(str);
            }

            ans = Math.min(runLen(str), ans);
            cnt++;
        }

        System.out.println(ans);
    }

    public static String shift(String str) {
        String nStr = "";
        char c = stack.pop();
        nStr = c + str.substring(0, len-1);
        return nStr;
    }

    public static int runLen(String str) {
        char cen = str.charAt(0);
        int con = 2;
        int num = 1;

        for(int i=1; i<len; i++) {
            if(str.charAt(i)!=cen) {
                cen = str.charAt(i);
                con += 2;
                num = 1;
            } else {
                num++;
                if(num>=10) {
                    con += 1;
                }
            }
        }

        return con;
    }
}