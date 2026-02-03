package Classic150.Stack;

//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
//实现 MinStack 类:
//
//MinStack() 初始化堆栈对象。
//void push(int val) 将元素val推入堆栈。
//void pop() 删除堆栈顶部的元素。
//int top() 获取堆栈顶部的元素。
//int getMin() 获取堆栈中的最小元素。

import java.util.Stack;

public class MinStack {
    Stack<Integer> topStack;
    Stack<Integer> minStack;
    int curMin;

    public MinStack() {
        topStack = new Stack<>();
        minStack = new Stack<>();
        curMin = Integer.MAX_VALUE;
    }

    public void push(int val) {
        curMin = Math.min(curMin, val);
        topStack.push(val);
        minStack.push(curMin);
    }

    public void pop() {
        topStack.pop();
        minStack.pop();
        if(minStack.isEmpty()){
            curMin = Integer.MAX_VALUE;
        }else {
            curMin = minStack.peek();
        }

    }

    public int top() {
        return topStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
