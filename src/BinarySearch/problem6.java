package BinarySearch;

//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
//算法的时间复杂度应该为 O(log (m+n)) 。

import java.util.Arrays;

public class problem6 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int preTrash = 0, trash = 0;
        int n = nums1.length, m = nums2.length;
        int nums1_l = 0, nums1_r = nums1.length - 1;
        int nums2_l = 0, nums2_r = nums2.length - 1;
        int nums1_mid = 0, nums2_mid = 0;
        int point;
        int ptrTrash1 = -1, ptrTrash2 = -1;
        double ptr1 = Double.MAX_VALUE * -1, ptr2 = 0;
        boolean isDouble = false, takeOne = false;

        if((m+n) % 2 == 0){
            isDouble = true;
        }

        point = (m+n+1)/2;
        nums1_mid = (nums1_l + nums1_r)/2;
        nums2_mid = (nums2_l + nums2_r)/2;

        while(point != trash && nums1_l <= nums1_r && nums2_l <= nums2_r
            && nums1_r < n && nums2_r < m){
            takeOne = false;
            int n1 = nums1[nums1_mid];
            int n2 = nums2[nums2_mid];

            preTrash = Math.max((nums1_mid - nums1_l), (nums2_mid - nums2_l)) + trash + 1;
            if(n1 == n2 && (nums1_mid - nums1_l) >= (nums2_mid - nums2_l)){
                takeOne = true;
            } else if (n1 < n2) {
                takeOne = true;
            }

            // 二分法取舍
            if(takeOne && preTrash < point){
                trash = trash + nums1_mid - nums1_l + 1;
                ptrTrash1 = nums1_mid;
                if(nums1_mid - nums1_l != 0){
                    nums1_l = nums1_mid + 1;
                }else {
                    nums1_l = nums1_r = nums1_mid + 1;
                }
            }else if(!takeOne && preTrash < point){
                trash = trash + nums2_mid - nums2_l + 1;
                ptrTrash2 = nums2_mid;
                if(nums2_mid - nums2_l != 0){
                    nums2_l = nums2_mid + 1;
                }else {
                    nums2_l = nums2_r = nums2_mid + 1;
                }
            }else if(takeOne && preTrash >= point){
                if(nums2_mid - nums2_l == 0 && preTrash == point){
                    // 循环终止有效，取nums1元素为中位数
                    ptrTrash1 = nums1_mid;
                    trash = point;
                    break;
                }
                nums2_r = nums2_mid - 1;
            }else if(!takeOne && preTrash >= point){
                if(nums1_mid - nums1_l == 0 && preTrash == point){
                    // 循环终止有效，取nums2元素为中位数
                    ptrTrash2 = nums2_mid;
                    trash = point;
                    break;
                }
                nums1_r = nums1_mid - 1;
            }

            nums1_mid = (nums1_l + nums1_r)/2;
            nums2_mid = (nums2_l + nums2_r)/2;
        }

        // 获取ptr1
        if(ptrTrash1 != -1 && ptrTrash2 != -1){
            ptr1 = Math.max(nums1[ptrTrash1], nums2[ptrTrash2]);
        } else if (ptrTrash1 == -1 && ptrTrash2 != -1) {
            ptr1 = nums2[ptrTrash2];
        } else if (ptrTrash1 != -1 && ptrTrash2 == -1) {
            ptr1 = nums1[ptrTrash1];
        }

        // 一方数组全被纳入的情况
        if(point != trash){
            if(isDouble && (nums1_l > nums1_r || nums1_r >= n)){
                int pointNum = nums2_l + point - trash - 1;
                return (Math.max(ptr1, nums2[pointNum]) + nums2[pointNum+1])/2.0;
            } else if (isDouble && (nums2_l > nums2_r || nums2_r >= m)) {
                int pointNum = nums1_l + point - trash - 1;
                return (Math.max(ptr1, nums1[pointNum]) + nums1[pointNum+1])/2.0;
            } else if (!isDouble && (nums1_l > nums1_r || nums1_r >= n)) {
                int pointNum = nums2_l + point - trash - 1;
                return Math.max(ptr1, nums2[pointNum]);
            } else if (!isDouble && (nums2_l > nums2_r || nums2_r >= m)) {
                int pointNum = nums1_l + point - trash - 1;
                return Math.max(ptr1, nums1[pointNum]);
            }
        }

        // 两方数组均未被全部纳入
        // 获取ptr2
        if(isDouble){
            if(ptrTrash1 >= (nums1.length-1) && ptrTrash2 < (nums2.length-1)){
                ptr2 = nums2[ptrTrash2+1];
            } else if (ptrTrash1 < (nums1.length-1) && ptrTrash2 >= (nums2.length-1)) {
                ptr2 = nums1[ptrTrash1+1];
            } else {
                ptr2 = Math.min(nums1[ptrTrash1+1], nums2[ptrTrash2+1]);
            }

            ptr1 = (ptr1+ptr2)/2;
        }

        return ptr1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,5}, nums2 = {3,4,6};
        problem6 p = new problem6();

        System.out.println(p.findMedianSortedArrays(nums1, nums2));
    }
}
