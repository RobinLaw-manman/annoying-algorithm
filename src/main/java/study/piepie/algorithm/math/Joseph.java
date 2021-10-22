package study.piepie.algorithm.math;

/**
 * @author Robin
 * @date 2021-10-22 16:18
 **/
public class Joseph {
    // https://pic.leetcode-cn.com/1622207345-bKYeRl-Screenshot%20from%202021-05-28%2021-08-29.png
    // 记得余数三大定律
    // 1 (a+b)%m = a%m + b%m
    // 2 a.b%m = a%m * b%m
    // 3 a % m = b%m -----> (a-b)%m = 0(能整除)
    public static int lastRemaining(int n, int m) {
        return f(n, m);
    }

    public static int f(int n, int m) {
        int f = 0;
        for (int i = 2; i <= n; ++i) {
            f = (f + m) % i;
        }
        return f;
    }
}