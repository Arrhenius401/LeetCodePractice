package Classic150.Matrix;

//请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
//
//数字 1-9 在每一行只能出现一次。
//数字 1-9 在每一列只能出现一次。
//数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）

import java.util.HashSet;
import java.util.Set;

public class problem1 {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;

        // 行检查
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if(c == '.'){
                    continue;
                }

                if(set.contains(c - '1')){
                    return false;
                }
                set.add(c - '1');
            }
        }

        // 列检查
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                char c = board[j][i];
                if(c == '.'){
                    continue;
                }

                if(set.contains(c - '1')){
                    return false;
                }
                set.add(c - '1');
            }
        }

        // 九宫格检查
        for (int y = 0; y < 9; y += 3) {
            for (int x = 0; x < 9; x += 3) {
                Set<Integer> set = new HashSet<>();
                for (int i = x; i < x+3; i++) {
                    for (int j = y; j < y+3; j++) {
                        char c = board[i][j];
                        if(c == '.'){
                            continue;
                        }

                        if(set.contains(c - '1')){
                            return false;
                        }
                        set.add(c - '1');
                    }

                }
            }
        }

        return true;
    }
}
