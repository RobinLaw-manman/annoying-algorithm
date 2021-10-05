package study.piepie.algorithm.dp;

/**
 * @author Robin
 * @date 2021-10-05 11:17
 **/
public class MinEditDistance {
    //感谢上面得评论，终于理解了。 如果 a[i]=a[j], 那么从 (i-1, j-1) 到(i,j)，不需要做任何操作，因此编辑距离不需要 + 1，
    // 但是从 (i-1, j) 到 (i, j), j 这个位置得字符已经和 i-1 相等了（相当于被 i-1 这个位置占了），
    // 所以不能再和 i 这个位置得字符比较了，
    // 要使得 i 和 j 位置得字符相等，只能是删掉 i 这个字符了或者是在 j 后面再加一个和 i 一样得字符。

    public static int minDist(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        // 初始化第一行
        for (int j = 0; j < s2.length(); ++j) {
            if (s1.charAt(0) == s2.charAt(j)) {
                dp[0][j] = j;
            } else if (j == 0) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = dp[0][j - 1] + 1;
            }
        }
        // 初始化第一列
        for (int i = 0; i < s1.length(); ++i) {
            if (s2.charAt(0) == s1.charAt(i)) {
                dp[i][0] = i;
            } else if (i == 0) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
            }
        }
        for (int i = 1; i < s1.length(); ++i) {
            for (int j = 1; j < s2.length(); ++j) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                } else {
                    dp[i][j] = min(dp[i - 1][j - 1] + 1, dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                }
            }
        }
        return dp[s1.length() - 1][s2.length() - 1];
    }

    private static int min(int x, int y, int z) {
        return Math.min(x, Math.min(y, z));
    }
}