// 9461. 파도반 수열
// https://acmicpc.net/problem/9461

package BaekjoonOnlineJudge.boj_09xxx;

import java.io.*;

public class boj_9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] padovan = new long[101];
        padovan[1] = 1; padovan[2] = 1; padovan[3] = 1;
        for(int i = 4; i < 101; i++) {
            padovan[i] = padovan[i-2] + padovan[i-3];
        }

        try {
            int query = Integer.parseInt(br.readLine());
            for(int i = 0; i < query; i++) {
                int n = Integer.parseInt(br.readLine());
                bw.write(Long.toString(padovan[n])); bw.write("\n");
            }
            bw.flush(); bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
