package Classic150.Stack;

//给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
//
//请你计算该表达式。返回一个表示表达式值的整数。
//
//注意：
//
//有效的算符为 '+'、'-'、'*' 和 '/' 。
//每个操作数（运算对象）都可以是一个整数或者另一个表达式。
//两个整数之间的除法总是 向零截断 。
//表达式中不含除零运算。
//输入是一个根据逆波兰表示法表示的算术表达式。
//答案及所有中间计算结果可以用 32 位 整数表示。

import java.util.Deque;
import java.util.LinkedList;

public class problem2 {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new LinkedList<>();
        stack.push(tokens[0]);

        try {
            for (int i = 1; i < tokens.length; i++) {
                switch (tokens[i]) {
                    case "+":
                        int num1 = Integer.parseInt(stack.pop());
                        int num2 = Integer.parseInt(stack.pop());
                        int ans1 = num1 + num2;
                        stack.push("" + ans1);
                        break;
                    case "-":
                        int num3 = Integer.parseInt(stack.pop());
                        int num4 = Integer.parseInt(stack.pop());
                        int ans2 = num4 - num3;
                        stack.push("" + ans2);
                        break;
                    case "*":
                        int num5 = Integer.parseInt(stack.pop());
                        int num6 = Integer.parseInt(stack.pop());
                        int ans3 = num5 * num6;
                        stack.push("" + ans3);
                        break;
                    case "/":
                        int num7 = Integer.parseInt(stack.pop());
                        int num8 = Integer.parseInt(stack.pop());
                        int ans4 = num8/num7;
                        stack.push("" + ans4);
                        break;
                    default:
                        stack.push(tokens[i]);

                }
            }

            String pureNum = stack.pop();
            return Integer.parseInt(pureNum);
        } catch (Exception e) {
            return -1;
        }

    }
}
