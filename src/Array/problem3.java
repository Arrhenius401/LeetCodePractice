package Array;

public class problem3 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] newNum = new int[len];

        for(int i=0; i<len; i++){
            newNum[(i+k)%len] = nums[i];
        }

        System.arraycopy(newNum, 0, nums, 0, len);
    }

    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end){
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}
