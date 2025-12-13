// 10830. 행렬 제곱
// https://acmicpc.net/problem/10830

package BaekjoonOnlineJudge.boj_10xxx;

import java.io.*;
import java.util.*;

public class boj_10830 {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // INPUT
        st = new StringTokenizer(br.readLine());

        int     n = Integer.parseInt(st.nextToken());
        long    b = Long.parseLong(st.nextToken());

        // INPUT PROCESSING
        int[][]     a           = new int[n][n];
        String      binaryB     = Long.toBinaryString(b);
        int         binBsize    = binaryB.length();
        int[][][]   a2kSet      = new int[binBsize][n][n];  a2kSet[0] = a;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken())%1000;
            }
        }

        // MULTIPLICATE n' POWER
        for(int i = 1; i < binBsize; i++) {
            a2kSet[i] = multiplicate(a2kSet[i-1], a2kSet[i-1], 1000);
        }

        int[][] result = a2kSet[binBsize-1];
        for(int i = 1; i < binBsize; i++) {
            if(binaryB.charAt(i) == '1') {
                result = multiplicate(result, a2kSet[binBsize-i-1], 1000);
            }
        }

        // OUTPUT
        try {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    bw.write(result[i][j] + " ");
                }
                bw.write("\n");
            }

            bw.flush(); bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[][] multiplicate(int[][] _a, int[][] _b, int moduler) {
        int[][] result  = new int[_a.length][_b[0].length];
        int     iter    = _b.length;

        for(int i = 0; i < iter; i++) {
            for(int j = 0; j < iter; j++) {
                for(int k = 0; k < iter; k++) {
                    result[i][j] += _a[i][k] * _b[k][j];
                }
                result[i][j] %= moduler;
            }
        }

        return result;
    }
}
