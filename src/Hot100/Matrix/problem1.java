package Hot100.Matrix;

public class problem1 {
    //在计算机科学中，原地算法（In-place Algorithm） 是一种特殊的算法设计范式，其核心特征是不需要额外的、与输入数据规模成比例的辅助空间，仅通过修改输入数据本身来完成计算，最终得到结果。
    // 简单来说，它 “就地” 利用原始数据的存储空间进行操作，几乎不依赖额外内存（或仅依赖常数级别的辅助空间）。

    //要准确理解原地算法，需抓住两个核心要点：
    //空间复杂度极低：
    //算法的空间复杂度通常为 O(1)（常数级），即辅助空间的大小不随输入数据量（如数组长度、字符串长度）的增加而变化。例如，排序时仅用 1-2 个临时变量存储中间值，而非创建一个与原数组等大的新数组。
    //注意：若算法需要的辅助空间与输入规模无关（如固定大小的栈、哈希表），也可视为原地算法（称为 “广义原地算法”）。
    //直接修改输入数据：
    //算法不依赖 “拷贝输入数据到新空间再处理” 的模式，而是直接在原始数据结构（如数组、链表）的内存地址上进行更新、交换、覆盖等操作，最终原始数据会被替换为输出结果。

    public void setZeroes(int[][] matrix) {
        boolean flagCol = false, flagRow = false;
        int m = matrix.length, n = matrix[0].length;

        for(int i=0; i<m; i++){
            if(matrix[i][0] == 0){
                flagCol = true;
                break;
            }
        }

        for(int j=0; j<n; j++) {
            if (matrix[0][j] == 0) {
                flagRow = true;
                break;
            }
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(flagCol){
            for (int i=0; i<m; i++){
                matrix[i][0] = 0;
            }
        }

        if(flagRow){
            for (int j=0; j<n; j++){
                matrix[0][j] = 0;
            }
        }

    }
}
