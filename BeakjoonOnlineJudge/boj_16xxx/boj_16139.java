// 16139. 인간-컴퓨터 상호작용
// https://acmicpc.net/problem/16139

package BeakjoonOnlineJudge.boj_16xxx;

import java.util.*;
import java.io.*;

public class boj_16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String  str =       br.readLine();
        int     strSize =   str.length();
        int[][] prefixSum = new int[strSize+1][26];
        for(int i = 0; i < strSize; i++) {
            prefixSum[i+1] = Arrays.copyOf(prefixSum[i], 26);
            prefixSum[i+1][str.charAt(i)-'a']++;
        }

        int query = Integer.parseInt(br.readLine());
        for(int i = 0; i < query; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int trg =       st.nextToken().charAt(0)-'a';
            int startIdx =  Integer.parseInt(st.nextToken());
            int endIdx =    Integer.parseInt(st.nextToken())+1;

            bw.write(Integer.toString(prefixSum[endIdx][trg] - prefixSum[startIdx][trg])); bw.write("\n");
        }

        bw.flush(); bw.close();
    }
}
