package Classic150.Array_SubString;

//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
//
//比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
//
//P   A   H   N
//A P L S I I G
//Y   I   R
//之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
//
//请你实现这个将字符串进行指定行数变换的函数：
//
//string convert(string s, int numRows);

public class problem13 {
    public String convert(String s, int numRows) {
        if(numRows == 1 || s.isEmpty()){
            return s;
        }

        // 初始化矩阵
        int round = 2 * (numRows - 1);
        int cols = (s.length() / round + 1) * (numRows - 1);
        char[][] matrix = new char[numRows][cols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = ' ';
            }
        }

        // 填充矩阵
        int rootRow = 0;
        int rootCol = 0;
        matrix[rootRow][rootCol] = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            int index = i % round;
            if(index < numRows && index != 0){
                matrix[++rootRow][rootCol] = s.charAt(i);
            }else{
                matrix[--rootRow][++rootCol] = s.charAt(i);
            }
        }

        // 组装答案
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < cols; j++) {
                if(matrix[i][j] != ' '){
                    builder.append(matrix[i][j]);
                }
            }
        }

        return builder.toString();
    }
}
