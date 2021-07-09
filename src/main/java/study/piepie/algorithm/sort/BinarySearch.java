package study.piepie.algorithm.sort;

/**
 * @author Robin
 * @date 2021-05-07 16:23
 **/
public class BinarySearch {
    public static int searh(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int leftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target <= nums[mid]) {
                right = mid - 1;
            }
        }
        if (left == nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    public static int rightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target >= nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    public static int leftBound2(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
//        if (left == nums.length) {
//            return -1;
//        }
//        return nums[left] == target ? left : -1;
        return left;
    }

    public static int rightBound2(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
//        if (left == 0) return -1;
//        return nums[left - 1] == target ? left - 1 : -1;
        return left - 1;
    }

    public static void main(String[] args) {
//        int[] nums = new int[] {1, 2, 2, 2, 3};
        int[] nums = new int[]{2, 3, 5, 7};
        int index = searh(nums, 2);
        System.out.println(index);
        int left = leftBound2(nums, 4);
        // 2==> 左侧搜索，如果target不存在返回大于target的第一个数5对应的索引
        System.out.println("left bound: " + left);
        // 1==> 右侧搜索，如果target不存在返回小于target的第一个数3对应的索引
        int right = rightBound2(nums, 4);
        System.out.println("right bound: " + right);
    }
}