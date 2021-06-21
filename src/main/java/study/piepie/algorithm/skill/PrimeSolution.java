package study.piepie.algorithm.skill;

/**
 * @author Robin
 * @date 2021-06-21 16:41
 **/
public class PrimeSolution {
    public static long countPrime(int n) {
        boolean[] isPrime = new boolean[n + 1];
        long count = 0;
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (boolean f : isPrime) {
            if (f){
                count++;
            }
        }
        return count;
    }
}