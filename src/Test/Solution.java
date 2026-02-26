package Test;



import java.util.*;

public class Solution {

    //-----笔试题一
    //给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以
    //按任意顺序返回答案。要求时间复杂度：O(nlogn)。
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }else{
                map.put(nums[i], 1);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).getKey();
        }
        return res;
    }

    //-----笔试题二
    //给你两个按非递减顺序排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别
    //表示 nums1 和 nums2 中的元素数目。
    //请你合并 nums2 到 nums1 中，使合并后的数组同样按非递减顺序排列。
    //注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，
    //nums1 的初始长度为 m+n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，
    //应忽略。nums2 的长度为 n
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        // 测试问题2
        int[] nums_1 = {1,1,1,2,2,3};
        int k_1 = 2;
        int[] res_1 = new Solution().topKFrequent(nums_1, k_1);
        System.out.println(Arrays.toString(res_1));

        int[] nums_2 = {1};
        int k_2 = 1;
        int[] res_2 = new Solution().topKFrequent(nums_2, k_2);
        System.out.println(Arrays.toString(res_2));


        // 测试问题1
        int[] nums1_1 = {1,2,3,0,0,0};
        int[] nums2_1 = {2,5,6};
        int m_1 = 3;
        int n_1 = 3;
        Solution s = new Solution();
        s.merge(nums1_1, m_1, nums2_1, n_1);
        System.out.println(Arrays.toString(nums1_1));

        int[] nums1_2 = {1};
        int[] nums2_2 = {};
        int m_2 = 1;
        int n_2 = 0;
        s.merge(nums1_2, m_2, nums2_2, n_2);
        System.out.println(Arrays.toString(nums1_2));
    }

}
