import java.io.*;
import java.util.*;

public class Main {
    public static char[] cArr;
    public static boolean[] alpha = new boolean[6];
    public static int cnt = 0;
    public static int[] arr = new int[6];
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        cArr = new char[str.length()];

        for(int i=0; i<cArr.length; i++) {
            cArr[i] = str.charAt(i);
            if(cArr[i]>='a' && cArr[i]<='f') {
                if(!alpha[cArr[i]-'a']) {
                    alpha[cArr[i]-'a'] = true;
                }
            }
        }

        select(0);

        System.out.println(max);
    }

    //알파벳에 숫자 넣기
    public static void select(int cur) {
        if(cur==6) {
            max = Math.max(max, cal());
            return;
        }

        for(int i=1; i<=4; i++) {
            if(alpha[cur]) {
                arr[cur] = i;
                select(cur+1);
            } else {
                select(cur+1);
            }
        }
    }

    //계산
    public static int cal() {
        int res = arr[cArr[0]-'a'];

        for(int i=2; i<cArr.length; i++) {
            if(cArr[i-1]=='+') {
                res += arr[cArr[i]-'a'];
            } else if(cArr[i-1]=='-') {
                res -= arr[cArr[i]-'a'];
            } else if(cArr[i-1]=='*') {
                res *= arr[cArr[i]-'a'];
            }
        }

        return res;
    }
}