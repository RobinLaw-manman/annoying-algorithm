package study.piepie.algorithm.sort;

/**
 * @author Robin
 * @date 2021-05-10 15:17
 **/
// 找第k大
public class FindKthLarge {
    public static int findKthLarge(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int p = partition(nums, low, high);
            if (k < p) {
                low = p + 1;
            } else if (k > p) {
                high = p - 1;
            } else {
                return nums[p];
            }
        }
        return -1;
    }

    // 分区，类似快排
    public static int partition(int[] nums, int low, int high) {
        if (low == high) {
            return low;
        }
        int i = low;
        int j = high + 1;
        int pivot = nums[low];
        while (true) {
            while (nums[++i] < pivot) {
                if (i == high) {
                    break;
                }
            }
            while (nums[--j] < pivot) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, j, low);
        return j;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}