package Trick;

//给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
//我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//
//必须在不使用库内置的 sort 函数的情况下解决这个问题。

public class problem3 {
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = 0;

        for(int i=0; i<nums.length; i++){
            switch (nums[i]){
                case 0:
                    red++;
                    break;

                case 1:
                    white++;
                    break;

                case 2:
                    blue++;
                    break;
            }
        }

        for(int i=0; i<red; i++){
            nums[i] = 0;
        }

        for(int i=red; i<(red+white); i++){
            nums[i] = 1;
        }

        for(int i=(red+white); i< nums.length; i++){
            nums[i] = 2;
        }
    }
}
