package study.piepie.algorithm.backtrack;

/**
 * @author Robin
 * @date 2021-06-11 15:27
 **/
public class Sudoku {
    public static boolean backTrack(char[][] boards, int r, int c) {
        int m = 9;
        int n = 9;
        if (c == n) {
            return backTrack(boards, r + 1, 0);
        }
        if (r == m) {
            return true;
        }
        if (boards[r][c] != '.') {
            return backTrack(boards, r, c + 1);
        }
        for (char ch = '1'; ch <= '9'; ch++) {
            if (!isValid(boards, r, c, ch)) {
                continue;
            }
            boards[r][c] = ch;
            if (backTrack(boards, r, c + 1)) {
                return true;
            }
            boards[r][c] = '.';
        }
        return false;
    }

    public static boolean isValid(char[][] boards, int r, int c, int n) {
        for (int i = 0; i < 9; i++) {
            // 比较同行是否合法
            if (boards[r][i] == n) return false;
            // 比较同一列是否合法
            if (boards[i][c] == n) return false;
            // 9区里面是否合法
            // r/3*3= (0-2)0 (3-5)3 (6-8)6决定行的起始位置   r/3 ===> (0-2)+0 + (3-5)1 + (6-8)2===>实现每过3个换行
            // r/3*3= (0-2)0 (3-5)3 (6-8)6决定列的起始位置   r%3 ===> +0,1,2===>实现同行列的增加每三个分别加0,1,2
            // r/3*3即行上的0,3,6和列上的0,3,6
            if (boards[(r / 3) * 3 + r / 3][(r / 3) * 3 + r % 3] == n) return false;
        }
        return true;
    }
}