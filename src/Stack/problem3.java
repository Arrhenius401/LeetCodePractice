package Stack;

import java.util.*;

public class problem3 {
    int ptr;
    public String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();
        ptr = 0;

        while (ptr < s.length()){
            char cur = s.charAt(ptr);

            if(Character.isDigit(cur)){
                //处理数字
                String digits = getDigits(s);
                stack.addLast(digits);
            }else if(Character.isLetter(cur) || cur == '['){
                //处理左括号和其他字母
                stack.addLast(String.valueOf(s.charAt(ptr++)));
            }else {
                //处理右括号
                ptr++;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stack.peekLast())){
                    sub.addLast(stack.removeLast());
                }
                Collections.reverse(sub);

                //左括号出栈
                stack.removeLast();
                //处理数字
                int repTime = Integer.parseInt(stack.removeLast());
                StringBuffer sb = new StringBuffer();
                String o = getString(sub);
                //构造字符串
                while (repTime-- > 0){
                    sb.append(o);
                }
                stack.addLast(sb.toString());
            }
        }
        return getString(stack);
    }

    public String getDigits(String s){
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))){
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    public String getString(LinkedList<String> stack){
        StringBuffer ret = new StringBuffer();
        for(String s: stack){
            ret.append(s);
        }
        return ret.toString();
    }
}
