package study.piepie.algorithm.string;

/**
 * @author Robin
 * @date 2021-11-16 14:29
 **/
public class Palindrom {
    public static int getMaxLengthOfPalindrom(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int maxLength = Math.max(lengthOfPalindrom(s, i, i+1), lengthOfPalindrom(s, i, i));
            max = Math.max(max, maxLength);
        }
        return max;
    }
    public static int lengthOfPalindrom(String s, int midOne, int midTwo) {
        if (midTwo>=s.length() || s.charAt(midOne) != s.charAt(midTwo)) {
            return 0;
        }
        int length = (midOne == midTwo ? 1 : 2);
        while (--midOne >=0 && ++midTwo < s.length() && s.charAt(midOne) == s.charAt(midTwo)) {
            length+=2;
        }
        return length;
    }

    public static void main(String[] args) {
        String s = "adaegffg";
        int longest = getMaxLengthOfPalindrom(s);
        System.out.println(longest);
    }
}