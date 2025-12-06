package Classic150.Array_SubString;

//编写一个函数来查找字符串数组中的最长公共前缀。
//
//如果不存在公共前缀，返回空字符串 ""。

public class problem11 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char ptr = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(i > strs[j].length() - 1 || ptr != strs[j].charAt(i)){
                    return builder.toString();
                }
            }
            builder.append(ptr);
        }

        return builder.toString();
    }
}
