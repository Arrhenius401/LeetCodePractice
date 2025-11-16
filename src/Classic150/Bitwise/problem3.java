package Classic150.Bitwise;

//给定一个正整数 n，编写一个函数，获取一个正整数的二进制形式并返回其二进制表达式中 设置位 的个数（也被称为汉明重量）。

public class problem3 {
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0){
            ans = (n & 1) == 0 ? ans : ans + 1;
            n >>>= 1;
        }
        return ans;
    }
}
