// 1016. 제곱 ㄴㄴ 수
// https://acmicpc.net/problem/1016

package BaekjoonOnlineJudge.boj_01xxx;

import java.util.*;

public class boj_1016 {
    public static void main(String[] args) {
        long min, max;
        try(Scanner sc = new Scanner(System.in)) {
            min = sc.nextLong();
            max = sc.nextLong();
        }

        List<Integer> primes = primes((int)Math.sqrt(max));
        int cnt = primes.size();

        int snnnSize = (int)(max-min+1);
        boolean[] snnn = new boolean[snnnSize];
        for(int i = 0; i < cnt; i++) {
            long tmp = (long)primes.get(i)*primes.get(i);
            for(long j = (min%tmp==0)?0:tmp - min%tmp; j < snnnSize; j += tmp) {
                snnn[(int)j] = true;
            }
        }

        int res = 0;
        for(int i = 0; i < snnnSize; i++) {
            if(!snnn[i]) res++;
        }

        System.out.print(res);
    }

    public static List<Integer> primes(int limit) {
        List<Integer> res = new ArrayList<>();
        res.add(2);

        int         size =  (limit-1)/2;
        boolean[]   np =    new boolean[size];

        for(int i = 0; (2*i+3)*(2*i+3) <= limit; i++) {
            if(!np[i]) {
                int tmp = 2*i+3;
                for(int j = i+tmp; j < size; j += tmp) {
                    np[j] = true;
                }
            }
        }

        for(int i = 0; i < size; i++) {
            if(!np[i]) res.add(2*i+3);
        }

        return res;
    } 
}
