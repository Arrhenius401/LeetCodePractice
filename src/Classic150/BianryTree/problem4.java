package Classic150.BianryTree;

//一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class problem4 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int curNum = 1, nextNum = 0;
        int temp = curNum;
        double sum = 0;

        queue.offer(root);
        while (curNum > 0 && !queue.isEmpty()){
            curNum--;

            TreeNode node= queue.poll();
            sum += node.val;

            if(node.right != null){
                queue.offer(node.right);
                nextNum++;
            }
            if(node.left != null){
                queue.offer(node.left);
                nextNum++;
            }

            if(curNum == 0){
                ans.add(sum/temp);
                curNum = nextNum;
                temp = nextNum;
                nextNum = 0;
                sum = 0;
            }
        }

        return ans;
    }
}
