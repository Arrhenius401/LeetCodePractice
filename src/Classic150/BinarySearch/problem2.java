package Classic150.BinarySearch;

//整数数组 nums 按升序排列，数组中的值 互不相同 。
//
//在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 向左旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 下标 3 上向左旋转后可能变为 [4,5,6,7,0,1,2] 。
//
//给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
//
//你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。

public class problem2 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        int cur = 0;

        for (int i = 1; i < nums.length; i++) {
            if(nums[cur] > nums[i]) {
                break;
            }
            cur = i;
        }

        if(nums[0] > target) {
            left = cur + 1;
        } else if (nums[0] < target){
            right = cur;
        } else {
            return 0;
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
               right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        problem2 p = new problem2();

        System.out.println(p.search(nums, target));
    }
}
