package study.piepie.algorithm.string;

/**
 * @author Robin
 * @date 2021-11-16 14:29
 **/
public class Palindrom {
    public static String getMaxLengthOfPalindrom(String s) {
        String longestPalindrom = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrom(s, i, i);
            String s2 = palindrom(s, i, i + 1);
            longestPalindrom =
                    (longestPalindrom.length() < s1.length()) ? (s1.length() < s2.length() ? s2 : s1) : longestPalindrom.length() < s2.length() ? s2 : longestPalindrom;
        }
        return longestPalindrom;
    }

    public static String palindrom(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        String s = "adaegffh";
        String longest = getMaxLengthOfPalindrom(s);
        System.out.println(longest);
    }
}