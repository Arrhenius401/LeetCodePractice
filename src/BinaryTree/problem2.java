package BinaryTree;

//给定一个二叉树 root ，返回其最大深度。
//二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。

public class problem2 {
    public int maxDepth(TreeNode root) {
        int max = 0;
        max = order(root, 0, max);
        return max;
    }

    //Integer 是不可变类
    //Integer 类一旦创建，其内部封装的 int 值就无法被修改（没有提供修改内部值的方法）。当你在函数中写 integer = 100 时，本质是创建了一个新的 Integer 对象（自动装箱），并让形参指向这个新对象，而非修改原对象的值。
    //引用传递的是地址副本
    //虽然 Integer 是引用类型，但传递给函数的是引用地址的副本。当你在函数中对形参重新赋值（integer = new Integer(100)），只是修改了这个副本指向的新地址，不会影响外部原引用的指向。
    public int order(TreeNode root, int num, int max){
        if(root == null){
            return max;
        }

        num++;
        max = Math.max(num, max);

        int left = order(root.left, num, max);
        int right = order(root.right, num, max);

        max = Math.max(left, max);
        max = Math.max(right, max);

        return max;
    }
}
