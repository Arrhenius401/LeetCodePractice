package Classic150.Array_SubString;

//给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
//
//根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且 至少 有 h 篇论文被引用次数大于等于 h 。如果 h 有多种可能的值，h 指数 是其中最大的那个。

import java.util.Arrays;

public class problem7 {
    public int hIndex(int[] citations) {
        int ans = 0;
        int n = citations.length;
        Arrays.sort(citations);

        for (int i = n-1; i >= 0; i--) {
            if(citations[i] < n-i){
                break;
            }
            ans++;
        }

        return ans;
    }
}
