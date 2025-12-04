// 14492. 부울행렬의 부울곱
// https://acmicpc.net/problem/14492

package BeakjoonOnlineJudge.boj_14xxx;

import java.util.*;
import java.io.*;

public class boj_14492 {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int     n =     Integer.parseInt(br.readLine());
        int[][] mat_1 = new int[n][n];
        int[][] mat_2 = new int[n][n];
        int[][] res =   new int[n][n];
        int     sum =   0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                mat_1[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                mat_2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    res[i][j] += mat_1[i][k] * mat_2[k][j];
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(res[i][j] > 0) sum++;
            }
        }

        bw.write(Integer.toString(sum)); bw.write("\n");
        bw.flush(); bw.close();
    }
}
