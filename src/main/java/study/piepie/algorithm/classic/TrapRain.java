package study.piepie.algorithm.classic;

/**
 * @author Robin
 * @date 2021-11-20 11:10
 **/
public class TrapRain {
    public static int trap(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int lmax = heights[left];
        int rmax = heights[right];
        int res = 0;
        while (left <= right) {
            lmax = Math.max(lmax, heights[left]); //1： 第一根lmax == heights[left]
            rmax = Math.max(rmax, heights[right]);//2： 最后一根rmax == heights[right]
            if (lmax < rmax) { // 当前left这个点只和lmax有关
                res += lmax - heights[left]; // 这边如果heights[left]已经是最高的。在1中已经将lmax更新为自己了，相减为0
                left++;
            } else {
                res+= rmax - heights[right]; // 这边如果heights[right]已经是最高的。在1中已经将rmax更新为自己了，相减为0
                right--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] heights = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int res = trap(heights);
        System.out.println(res);
    }
}