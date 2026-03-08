package Daily;

//给你一个字符串数组 nums ，该数组由 n 个 互不相同 的二进制字符串组成，且每个字符串长度都是 n 。请你找出并返回一个长度为 n 且 没有出现 在 nums 中的二进制字符串。如果存在多种答案，只需返回 任意一个 即可。

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class problem5 {
    StringBuilder sb;
    String ans;
    Set<String> isExist;

    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();

        isExist = new HashSet<>();
        sb = new StringBuilder();
        ans = "";

        for (int i = 0; i < nums.length; i++) {
            isExist.add(nums[i]);
        }

        traceback(n, 0);

        return ans;
    }

    private void traceback(int n, int cur) {
        if(cur >= n) {
            String curStr = sb.toString();
            if(!isExist.contains(curStr)){
                ans = curStr;
            }
            return;
        }

        for (int i = 0; i < 2; i++) {
            sb.append(i);
            traceback(n, cur+1);
            sb.deleteCharAt(cur);
        }
    }
}
