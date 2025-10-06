package Classic150.Array_SubString;

//给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
//
//不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

public class problem2 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }

        int slow = 1, fast = 1;
        int count = 1;
        while(fast < n){
            if(nums[fast] != nums[fast-1]){
                nums[slow] = nums[fast];
                count = 1;
                slow++;
            } else {
                if(count < 2){
                    nums[slow] = nums[fast];
                    slow++;
                }
                count++;
            }

            fast++;
        }

        return slow;
    }
}
