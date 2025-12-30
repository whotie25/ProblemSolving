// 4948. 베르트랑 공준
// https://acmicpc.net/problem/4948

package BaekjoonOnlineJudge.boj_04xxx;

import java.io.*;
import java.util.*;

public class boj_4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int     n =     123456*2;
        int     size =  (n-1)/2;
        BitSet  p =     new BitSet(size);

        for(int i = 0; (2*i+3)*(2*i+3) <= n; i++) {
            if(!p.get(i)) {
                int tmp = 2*i+3;
                for(int j = i+tmp; j < size; j += tmp) {
                    p.set(j);
                }
            }
        }

        int cnt = 1;
        List<Integer> resPrefix = new ArrayList<>(); resPrefix.add(cnt);
        for(int i = 0; i < size; i++) {
            if(!p.get(i)) cnt++;
            resPrefix.add(cnt);
        }

        try {
            
            while(true) {
                int a = Integer.parseInt(br.readLine());

                if(a == 0) break;

                if(a == 1) {
                    bw.write("1\n");
                } else {
                    bw.write(String.valueOf(resPrefix.get(a-1) - resPrefix.get((a-1)/2))); bw.write("\n");
                }
            }
            bw.flush(); bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
