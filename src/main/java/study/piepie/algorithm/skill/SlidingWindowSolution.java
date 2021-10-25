package study.piepie.algorithm.skill;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Robin
 * @date 2021-10-22 17:37
 **/
public class SlidingWindowSolution {
    /**
     * 最小覆盖子串
     *
     * @param s
     * @param t
     * @return
     */
    public static String minCoverString(String s, String t) {
        String subStr = s;
        Set<Character> need = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            need.add(t.charAt(i));
        }
        Map<Character, Integer> window = new HashMap<>();
        int valid = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.contains(c)) {
                if (window.containsKey(c)) {
                    window.put(c, window.get(c) + 1);
                } else {
                    window.put(c, 1);
                    valid++;
                }
            }
            while (valid >= need.size()) {
                if (right - left < subStr.length()) {
                    subStr = s.substring(left, right);
                }
                char c1 = s.charAt(left);
                left++;
                if (need.contains(c1)) {
                    if (window.get(c1) == 1) {
                        window.remove(c1);
                        valid--;
                    } else {
                        window.put(c1, window.get(c1)-1);
                    }
                }
            }
        }
        return subStr;
    }
    public static void main(String[] args) {
        String min = minCoverString("ADOBECODEBANC", "ABC");
        System.out.println(min);
    }
}