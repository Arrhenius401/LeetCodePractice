package Classic150.Math;

//给定一个表示 大整数 的整数数组 digits，其中 digits[i] 是整数的第 i 位数字。这些数字按从左到右，从最高位到最低位排列。这个大整数不包含任何前导 0。
//
//将大整数加 1，并返回结果的数字数组。
//

import java.util.ArrayList;
import java.util.List;

public class problem2 {
    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        boolean isAdd = true;

        for (int i = digits.length-1; i >= 0; i--) {
            if (isAdd) {
                if(digits[i] == 9){
                    list.addFirst(0);
                }else {
                    list.addFirst(digits[i] + 1);
                    isAdd = false;
                }
            } else {
                list.addFirst(digits[i]);
            }
        }

        if (isAdd) {
            list.addFirst(1);
        }

        int[] ans = list.stream().mapToInt(Integer::intValue).toArray();
        return ans;
    }
}
