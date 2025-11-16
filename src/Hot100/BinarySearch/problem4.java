package Hot100.BinarySearch;

//整数数组 nums 按升序排列，数组中的值 互不相同 。
//
//在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 向左旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 下标 3 上向左旋转后可能变为 [4,5,6,7,0,1,2] 。
//
//给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
//
//你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。

public class problem4 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1, mid = 0;
        int point = 0;
        int ans = -1;
        int big = nums[0];

        if(nums.length == 0){
            return -1;
        }

        while (left <= right){
            mid = (left+right)/2;

            if(nums[mid] < big){
                right = mid-1;

                big = nums[mid];
                point = mid;
            }else {
                left = mid+1;
            }
        }

        if (target == nums[0]){
            ans = 0;
        }else if(target > nums[0]){
           left = 0;
           if(point == 0){
               point = nums.length-1;
           }
           right = point;
        }else {
            left = point;
            right = nums.length-1;
        }

        while (left <= right){
            mid = (left+right)/2;

            if(nums[mid] == target){
                ans = mid;
                break;
            }else if(nums[mid] < target){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums ={1,3};
        int target = 3;
        problem4 p = new problem4();

        System.out.println(p.search(nums, target));
    }
}
