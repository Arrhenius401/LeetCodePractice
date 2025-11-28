package Classic150.Array_SubString;

//给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
//
//单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。

public class problem10 {
    public int lengthOfLastWord(String s) {
        int cur = 0, ptr = s.length()-1;

        while (ptr >= 0 && s.charAt(ptr) == ' '){
            ptr--;
        }

        while (ptr >= 0 && s.charAt(ptr) != ' '){
            ptr--;
            cur++;
        }

        return cur;
    }
}
