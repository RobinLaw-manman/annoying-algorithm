package study.piepie.algorithm.skill;

/**
 * @author Robin
 * @date 2021-07-02 14:40
 **/
public class OneLineSolution {
    // 你和你的朋友面前有一堆石子，你们轮流拿，
    // 一次至少拿一颗，最多拿三颗，谁拿走最后一颗石子谁获胜
    // 让对手面对4，8，12 总是能赢
    public static boolean canWin(int n) {
        return n % 4 != 0;
    }

    // 如果我们把这四堆石头按索引的奇偶分为两组，即第 1、3 堆和第 2、4 堆，
    // 那么这两组石头的数量一定不同，也就是说一堆多一堆少。因为石头的总数是奇数，不能被平分。
    //而作为第一个拿石头的人，你可以控制自己拿到所有偶数堆，或者所有的奇数堆
    public static boolean stoneGame(int[] piles) {
        return true;
    }

    // 电灯开关问题
    // 16盏灯开始是灭的，如果亮，按了基数次
    // 16 = 1* 16 = 2*8 = 4*4 所以被按5次。4*4为1次
    // 所以小于16的平方根的数字的平方对应的数字都是亮着的
    // 第 1×1=1 盏、第 2×2=4 盏、第 3×3=9 盏和第 4×4=16 盏是亮的
    public static int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}