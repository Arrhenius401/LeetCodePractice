package Hot100.Stack;

//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//problem2

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    //peek和pop是两种不同的元素访问方法，核心区别在于是否移除元素
    //peek():仅获取容器（队列 / 栈）的头部元素，但不会移除该元素。
    //pop():获取容器（栈模式）的头部元素，并且会移除该元素。
    public void push(int val) {
        xStack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
