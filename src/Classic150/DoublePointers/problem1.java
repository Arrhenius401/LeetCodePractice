package Classic150.DoublePointers;

//如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
//
//字母和数字都属于字母数字字符。
//
//给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。

public class problem1 {
    public boolean isPalindrome(String s) {
        String temp = preHandle(s);
        int n = temp.length();

        int l=0, r=n-1;
        while (l<r){
            if(temp.charAt(l) != temp.charAt(r)){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    public String preHandle(String s){
        StringBuilder temp = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c - 'a' < 26 && c - 'a' >= 0){
                temp.append(c);
            } else if (c - 'A' < 26 && c - 'A' >= 0){
                char val = (char)('a'+c-'A');
                temp.append(val);
            } else if (c <= '9' && c >= '0'){
                temp.append(c);
            }
        }

        return temp.toString();
    }

    public static void main(String[] args) {
        String s = "0P";
        problem1 p = new problem1();

        System.out.println(p.isPalindrome(s));
    }
}
