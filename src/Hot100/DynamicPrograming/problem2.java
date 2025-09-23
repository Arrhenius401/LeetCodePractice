package Hot100.DynamicPrograming;

import java.util.ArrayList;
import java.util.List;

public class problem2 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> preList = new ArrayList<>();
        preList.add(1);
        List<Integer> curList = new ArrayList<>(preList);
        curList.add(1);
        List<Integer> initList = new ArrayList<>(curList);

        if(numRows == 0){
            return ans;
        } else if (numRows == 1) {
            ans.add(preList);
        } else if (numRows == 2) {
            ans.add(preList);
            ans.add(curList);
        } else {
            ans.add(preList);
            ans.add(curList);
            for(int i=2; i<numRows; i++){
                // 初始化链表
                preList = curList;
                curList = new ArrayList<>(initList);

                int n = preList.size();
                for(int j=0; j<n-1; j++){
                    int sum = preList.get(j) + preList.get(j+1);
                    curList.add(j+1, sum);
                }
                ans.add(curList);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int numRows = 5;
        problem2 p = new problem2();

        List<List<Integer>> ans = p.generate(numRows);
    }
}
