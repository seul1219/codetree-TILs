import java.io.*;
import java.util.*;

public class Main {
    public static char[] cArr;
    public static int cnt = 0;
    public static int[] arr;
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        cArr = new char[str.length()];

        //알파벳 개수
        for(int i=0; i<cArr.length; i++) {
            cArr[i] = str.charAt(i);
            if(cArr[i]>='a' && cArr[i]<='f') {
                cnt++;
            }
        }

        arr = new int[cnt];

        select(0);

        System.out.println(max);
    }

    public static void select(int cur) {
        if(cur==cnt) {
            //계산
            max = Math.max(max, cal());
            return;
        }

        for(int i=1; i<=4; i++) {
            arr[cur] = i;
            select(cur+1);
        }
    }

    public static int cal() {
        int res = arr[0];
        int th = 1;

        for(int i=2; i<cArr.length; i++) {
            if(cArr[i-1]=='+') {
                res += arr[th++];
            } else if(cArr[i-1]=='-') {
                res -= arr[th++];
            } else if(cArr[i-1]=='*') {
                res *= arr[th++];
            }
        }

        return res;
    }
}