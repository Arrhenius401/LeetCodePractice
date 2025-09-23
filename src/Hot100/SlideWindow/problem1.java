package Hot100.SlideWindow;

import java.util.HashSet;
import java.util.Set;

public class problem1 {
    public int lengthOfLongestSubstring(String s) {
        //哈希集合
        Set<Character> set = new HashSet<Character>();

        int n = s.length();
        int max = 0;
        int rightPointer = -1;

        for(int leftPointer=0; leftPointer<n; leftPointer++){
            if(leftPointer!=0){
                //左指针向右移动一个，移除一个字符
                set.remove(s.charAt(leftPointer-1));
            }

            while(rightPointer+1 < n && !set.contains(s.charAt(rightPointer+1))){
                set.add(s.charAt(++rightPointer));
            }

            max = Math.max(max, rightPointer - leftPointer +1);
        }

        return max;
    }
}
