package Classic150.BianryTree;

//填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
//
//初始状态下，所有 next 指针都被设置为 NULL

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class problem8 {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Node temp = root;
        Queue<Node> queue = new LinkedList<>();

        queue.add(temp);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curNode = queue.poll();
                if(curNode.left != null){
                    queue.offer(curNode.left);
                }
                if(curNode.right != null){
                    queue.offer(curNode.right);
                }

                Node nextNode = null;
                if(i+1 < size){
                    nextNode = queue.peek();
                }
                curNode.next = nextNode;
            }
        }

        return root;
    }
}
