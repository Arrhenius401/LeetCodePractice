package Classic150.Stack;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
//有效字符串需满足：
//
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。
//每个右括号都有一个对应的相同类型的左括号。

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class problem4 {
    public boolean isValid(String s) {
        int n = s.length();
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                    stack.push(c);
                    break;
                case '{':
                    stack.push(c);
                    break;
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if(!stack.isEmpty() && stack.peekFirst() == '('){
                        stack.pop();
                    }else {
                        return false;
                    }
                    break;
                case '}':
                    if(!stack.isEmpty() && stack.peekFirst() == '{'){
                        stack.pop();
                    }else {
                        return false;
                    }
                    break;
                case ']':
                    if(!stack.isEmpty() && stack.peekFirst() == '['){
                        stack.pop();
                    }else {
                        return false;
                    }
                    break;
            }
        }

        return stack.isEmpty();
    }
}
