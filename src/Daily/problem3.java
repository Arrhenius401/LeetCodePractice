package Daily;

//给你一个二进制字符串 s ，该字符串 不含前导零 。
//
//如果 s 包含 零个或一个由连续的 '1' 组成的字段 ，返回 true。否则，返回 false 。

public class problem3 {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        boolean isFirstOne = false, isSecondOne = false;

        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '1'){
                if(!isFirstOne){
                    isFirstOne = true;
                    i++;
                    while (i < n && s.charAt(i) == '1'){
                        i++;
                    }
                } else {
                    isSecondOne = true;
                }
            }
        }

        return !isFirstOne || (isFirstOne && !isSecondOne);
    }
}
