package BinarySearch;

//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//请必须使用时间复杂度为 O(log n) 的算法。

public class problem1 {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len;
        int pointNum = 0;

        while (left < right){
            pointNum = (left + right)/2;

            if(left == pointNum){
                if(nums[pointNum] < target){
                    return pointNum+1;
                }else {
                    return left;
                }
            }

            if(nums[pointNum] == target){
                return pointNum;
            }else if (nums[pointNum] < target){
                left = pointNum;
            }else {
                right = pointNum;
            }
        }

        return pointNum + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 2;
        problem1 p = new problem1();

        int ans = p.searchInsert(nums, target);
        System.out.println(ans);
    }

}
