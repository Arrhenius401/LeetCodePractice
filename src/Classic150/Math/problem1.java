package Classic150.Math;

//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
//
//回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
//例如，121 是回文，而 123 不是。

public class problem1 {
    public boolean isPalindrome(int x) {
        String s = ""+x;
        int ptr1 = 0, ptr2 = s.length()-1;

        while(ptr1 < ptr2){
            if(s.charAt(ptr1) != s.charAt(ptr2)){
                return false;
            }
            ptr1++;
            ptr2--;
        }
        return true;
    }
}
