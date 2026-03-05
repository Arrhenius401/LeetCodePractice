package Daily;

//给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。
//
//交替字符串 定义为：如果字符串中不存在相邻两个字符相等的情况，那么该字符串就是交替字符串。例如，字符串 "010" 是交替字符串，而字符串 "0100" 不是。
//
//返回使 s 变成 交替字符串 所需的 最少 操作数。

public class problem2 {
    public int minOperations(String s) {
        int ans1 = 0;
        int ans2 = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            boolean isDouble = (i % 2 == 0);
            if(isDouble) {
                if(s.charAt(i) == '0'){
                    ans1++;
                }else {
                    ans2++;
                }
            } else {
                if(s.charAt(i) == '1'){
                    ans1++;
                }else {
                    ans2++;
                }
            }
        }

        return Math.min(ans1, ans2);
    }
}
