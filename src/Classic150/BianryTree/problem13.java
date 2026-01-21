package Classic150.BianryTree;

//给你二叉树的根结点 root ，请你将它展开为一个单链表：
//
//展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
//展开后的单链表应该与二叉树 先序遍历 顺序相同。

import java.util.ArrayList;
import java.util.List;

public class problem13 {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorder(root, list);

        TreeNode pre = root;
        for (int i = 1; i < list.size(); i++) {
            TreeNode node = list.get(i);
            pre.right = node;
            pre.left = null;
            pre = node;
        }
    }

    public void preorder(TreeNode root, List<TreeNode> list) {
        if(root == null){
            return;
        }

        list.add(root);
        preorder(root.left, list);
        preorder(root.right, list);
    }
}
