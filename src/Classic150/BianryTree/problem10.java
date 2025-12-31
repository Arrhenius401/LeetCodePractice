package Classic150.BianryTree;

//给你一个 n * n 矩阵 grid ，矩阵由若干 0 和 1 组成。请你用四叉树表示该矩阵 grid 。
//
//你需要返回能表示矩阵 grid 的 四叉树 的根结点。
//
//四叉树数据结构中，每个内部节点只有四个子节点。此外，每个节点都有两个属性：
//
//val：储存叶子结点所代表的区域的值。1 对应 True，0 对应 False。注意，当 isLeaf 为 False 时，你可以把 True 或者 False 赋值给节点，两种值都会被判题机制 接受 。
//isLeaf: 当这个节点是一个叶子结点时为 True，如果它有 4 个子节点则为 False 。
//class Node {
//    public boolean val;
//    public boolean isLeaf;
//    public Node topLeft;
//    public Node topRight;
//    public Node bottomLeft;
//    public Node bottomRight;
//}
//我们可以按以下步骤为二维区域构建四叉树：
//
//如果当前网格的值相同（即，全为 0 或者全为 1），将 isLeaf 设为 True ，将 val 设为网格相应的值，并将四个子节点都设为 Null 然后停止。
//如果当前网格的值不同，将 isLeaf 设为 False， 将 val 设为任意值，然后如下图所示，将当前网格划分为四个子网格。
//使用适当的子网格递归每个子节点。
//
//
//如果你想了解更多关于四叉树的内容，可以参考 百科 。
//
//四叉树格式：
//
//你不需要阅读本节来解决这个问题。只有当你想了解输出格式时才会这样做。输出为使用层序遍历后四叉树的序列化形式，其中 null 表示路径终止符，其下面不存在节点。
//
//它与二叉树的序列化非常相似。唯一的区别是节点以列表形式表示 [isLeaf, val] 。
//
//如果 isLeaf 或者 val 的值为 True ，则表示它在列表 [isLeaf, val] 中的值为 1 ；如果 isLeaf 或者 val 的值为 False ，则表示值为 0 。

import java.util.ArrayList;
import java.util.List;

public class problem10 {

    public Node construct(int[][] grid) {
        int n = grid.length;

        if(n == 1){
            return new Node(grid[0][0] == 1, true);
        }

        return createNode(grid, 0, 0, n);
    }

    public Node createNode(int[][] grid, int x, int y, int size) {
        int[][] turn = {{0, 0}, {0, size/2}, {size/2, 0}, {size/2, size/2}};
        boolean isLeaf = true;
        int val = grid[x][y];

        if(size == 2) {
            for (int i = 1; i < 4; i++) {
                int pointX = x + turn[i][0];
                int pointY = y + turn[i][1];

                if(val != grid[pointX][pointY]) {
                    isLeaf = false;
                    break;
                }
            }

            if(isLeaf) {
                return new Node(val == 1, true);
            } else {
                Node root = new Node(false, false);
                for (int i = 0; i < 4; i++) {
                    int pointX = x + turn[i][0];
                    int pointY = y + turn[i][1];
                    Node leaf = new Node(grid[pointX][pointY] == 1, true);

                    switch (i) {
                        case 0:
                            root.topLeft = leaf;
                            break;
                        case 1:
                            root.topRight = leaf;
                            break;
                        case 2:
                            root.bottomLeft = leaf;
                            break;
                        case 3:
                            root.bottomRight = leaf;
                            break;
                    }
                }
                return root;
            }
        }

        List<Node> leafNodes = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Node leaf = createNode(grid, x + turn[i][0], y + turn[i][1], size/2);
            leafNodes.add(leaf);

            if (i == 0) {
                val = leaf.val ? 1 : 0;
                isLeaf = true;
            } else {
                if(val != (leaf.val ? 1 : 0) || !leaf.isLeaf) {
                    isLeaf = false;
                }
            }
        }

        if (isLeaf) {
           return new Node(val == 1, true);
        } else {
            Node root = new Node(false, false);
            for (int i = 0; i < 4; i++) {
                Node leaf = leafNodes.get(i);

                switch (i) {
                    case 0:
                        root.topLeft = leaf;
                        break;
                    case 1:
                        root.topRight = leaf;
                        break;
                    case 2:
                        root.bottomLeft = leaf;
                        break;
                    case 3:
                        root.bottomRight = leaf;
                        break;
                }
            }
            return root;
        }
    }

    public static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}

