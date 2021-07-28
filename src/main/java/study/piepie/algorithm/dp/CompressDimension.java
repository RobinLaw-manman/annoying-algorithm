package study.piepie.algorithm.dp;

/**
 * @author Robin
 * @date 2021-07-27 11:07
 **/
public class CompressDimension {
    static int longestPalindromeSubseq(String s) {
        int n = s.length();
        // base case：一维 dp 数组全部初始化为 0
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            // 一定要记住dp[j]在一维数组上一遍遍更新去理解！！！！！
            // pre总是外循环的dp[j-1]
            // pre==上一次内循环temp==dp[j-1]===> 外循环的j-1
            // pre要初始化为0是因为外循环的时候pre也要更新为新的值
            int pre = 0;
            for (int j = i + 1; j < n; j++) {
                int temp = dp[j];
                // 状态转移方程
                if (s.charAt(i) == s.charAt(j))
                    dp[j] = pre + 2;
                else
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                pre = temp;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        String s = "abcba";
        int len = longestPalindromeSubseq(s);
        System.out.println(len);
    }
}