package Classic150.BFS;

//基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
//
//假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
//
//例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
//另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 bank 中）
//
//给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成此基因变化，返回 -1 。
//
//注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。

import java.util.*;

public class problem2 {
    public int minMutation(String startGene, String endGene, String[] bank) {
        char[] gene = {'A', 'T', 'C', 'G'};
        Set<String> set = new HashSet<>();
        Map<String, Boolean> isVisit = new HashMap<>();

        for (String s : bank) {
            set.add(s);
            isVisit.put(s, false);
        }

        if (!set.contains(endGene)) {
            return -1;
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(startGene);
        int step = 1;
        while (!queue.isEmpty()) {
            int qLen = queue.size();
            for (int i = 0; i < qLen; i++) {
                String cur = queue.poll();
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (cur.charAt(j) != gene[k]) {
                            StringBuilder build = new StringBuilder(cur);
                            build.setCharAt(j, gene[k]);
                            String next = build.toString();
                            if (set.contains(next) && !isVisit.get(next)) {
                                if (endGene.equals(next)) {
                                    return step;
                                }
                                queue.offer(next);
                                isVisit.put(next, true);
                            }
                        }
                    }

                }
            }
            step++;
        }

        return -1;
    }
}
