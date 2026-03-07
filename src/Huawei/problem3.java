package Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//0417
//从一副扑克牌中随机抽取n张牌组成一个序列，规定连续3张相同牌号的卡牌可以消除，剩余卡牌按照当前顺序重新合并成新的序列后继续消除，重复以上步骤直到无法消除，最后请输出结束后剩余的卡牌序列。注：存在连续4张相同牌号的情况，消除后剩余一张
public class problem3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String line = br.readLine().trim();
        String[] parts = line.split(" ");

        List<Character> ans = vanish(n, parts);

        putString(ans);
    }

    public static void putString(List<Character> ans){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ans.size(); i++) {
            if(i != 0){
                sb.append(" ");
            }
            sb.append(ans.get(i));
        }

        System.out.println(sb.toString());
    }

    public static List<Character> vanish(int n, String[] cards){
        List<Character> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ans.add(cards[i].charAt(0));
        }

        boolean isRemoved = true;
        while (isRemoved && !ans.isEmpty()) {
            isRemoved = false;
            char cur = ans.get(0);
            int count = 1;

            for (int i = 1; i < ans.size(); i++) {
                char next = ans.get(i);
                if(cur == next){
                    count++;
                    if(count == 3){
                        ans.remove(i);
                        ans.remove(i-1);
                        ans.remove(i-2);

                        isRemoved = true;
                        break;
                    }
                }else {
                    cur = next;
                    count = 1;
                }
            }
        }

        return ans;
    }

    //应该使用栈
}
