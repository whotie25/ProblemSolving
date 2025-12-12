// 2749. 피보나치 수 3
// https://acmicpc.net/problem/2749
package BaekjoonOnlineJudge.boj_02xxx;

import java.io.*;

public class boj_2749 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // INPUT
        long n = Long.parseLong(br.readLine()) - 1;

        // INPUT PROCESSING
        if(n == 0) { /* F(1) = 1 */
            bw.write("1");
            bw.flush(); bw.close();
            return;
        }

        long    denom       = 0x4000_0000_0000_0000L;
        String  binaryN     = "";

        while(n/denom == 0) denom /= 2;

        while(denom != 0) {
            if(n/denom == 1) {
                binaryN += "1";
                n %= denom;
            } else {
                binaryN += "0";
            }

            denom /= 2;
        }

        // FIBONACCI (MATRIX)
        int         iter    = binaryN.length();
        long[][]    powered = new long[iter][3];
        powered[0][0] = 1; powered[0][1] = 1; powered[0][2] = 0;

        for(int i = 1; i < iter; i++) {
            powered[i][0] = (powered[i-1][0] * powered[i-1][0] + powered[i-1][1] * powered[i-1][1])%1000000;
            powered[i][1] = (powered[i-1][0] * powered[i-1][1] + powered[i-1][1] * powered[i-1][2])%1000000;
            powered[i][2] = (powered[i-1][1] * powered[i-1][1] + powered[i-1][2] * powered[i-1][2])%1000000;
        }

        long[]      result = powered[iter-1];

        for(int i = 0; i < iter-1; i++) {
            if(binaryN.charAt(iter - i -1) == '1') {
                long[] tmp = new long[3];

                tmp[0] = (result[0] * powered[i][0] + result[1] * powered[i][1])%1000000;
                tmp[1] = (result[0] * powered[i][1] + result[1] * powered[i][2])%1000000;
                tmp[2] = (result[1] * powered[i][1] + result[2] * powered[i][2])%1000000;

                result = tmp;
            }
        }

        // OUTPUT
        try {
            bw.write(result[0] + "");
            bw.flush(); bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }   
}
