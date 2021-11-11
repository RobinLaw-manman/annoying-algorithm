package study.piepie.algorithm.sort;

/**
 * @author Robin
 * @date 2021-11-01 00:09
 **/
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] tmp = new int[arr.length];
//        sort(arr);
        sort(arr, 0, arr.length - 1, tmp);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    public static void sort(int[] nums, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sort(nums, left, mid, tmp);
            sort(nums, mid + 1, right, tmp);
            merge(nums, left, mid, right, tmp);
        }
    }

    public static void merge(int[] nums, int left, int mid, int right, int[] tmp) {
        int i = left;
        int j = mid+1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                tmp[index++] = nums[i++];
            } else {
                tmp[index++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[index++] = nums[i++];
        }
        while (j <= right) {
            tmp[index++] = nums[j++];
        }
        index = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            nums[left++] = tmp[index++];
        }
    }
}