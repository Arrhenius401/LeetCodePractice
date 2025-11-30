package Classic150.Stack;

//给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为 更加简洁的规范路径。
//
//在 Unix 风格的文件系统中规则如下：
//
//一个点 '.' 表示当前目录本身。
//此外，两个点 '..' 表示将目录切换到上一级（指向父目录）。
//任意多个连续的斜杠（即，'//' 或 '///'）都被视为单个斜杠 '/'。
//任何其他格式的点（例如，'...' 或 '....'）均被视为有效的文件/目录名称。
//返回的 简化路径 必须遵循下述格式：
//
//始终以斜杠 '/' 开头。
//两个目录名之间必须只有一个斜杠 '/' 。
//最后一个目录名（如果存在）不能 以 '/' 结尾。
//此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
//返回简化后得到的 规范路径

import java.util.*;

public class problem1 {
    public String simplifyPath(String path) {
        //  String.split() 会产生空字符串，仅无第二个参数时，会抛弃末尾的空字符串
        String[] names = path.split("/");
        Deque<String> legalNames = new LinkedList<>();
        String ans = "";

        for (String name: names) {
            if (name.equals("..") && !legalNames.isEmpty()) {
                // 移除元素都一样
                legalNames.pop();
            } else if (!name.isBlank() && !name.equals(".") && !name.equals("..")) {
                // offer() 是 Deque 继承自 Queue 接口的方法，核心是向队列尾部添加元素
                // push() 是 Deque 为了兼容「栈」功能设计的方法，核心是向栈顶（即 Deque 头部）添加元素
                legalNames.push(name);
            }
        }

        while (!legalNames.isEmpty()) {
            ans = "/" + legalNames.pop() + ans;
        }

        return ans.length() == 0 ? "/" : ans;
    }

    public static void main(String[] args) {
        String path = "/home/";
        problem1 p = new problem1();

        System.out.println(p.simplifyPath(path));
    }
}
