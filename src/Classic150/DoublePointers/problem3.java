package Classic150.DoublePointers;

//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
//
//字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

public class problem3 {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        if(n > m){
            return false;
        }

        int ptr1 = 0, ptr2 = 0;
        while (ptr1 < n && ptr2 < m){
            if (s.charAt(ptr1) == t.charAt(ptr2)){
                ptr1++;
            }
            ptr2++;
        }

        return ptr1 == n;
    }
}
