package Classic150.Heap;

//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
//请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
//你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。

public class problem3 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;

        return quickSelect(nums, 0, n-1, n-k);
    }

    private int quickSelect(int[] nums, int l, int r, int k){
        if(l == r){
            return nums[k];
        }

        int x = nums[l], i = l-1, j = r+1;
        while (i < j){
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);

            if(i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        if(k <= j) {
            return quickSelect(nums, l, j, k);
        }else {
            return quickSelect(nums, j + 1, r, k);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        problem3 p = new problem3();

        System.out.println(p.findKthLargest(nums, k));
    }
}
