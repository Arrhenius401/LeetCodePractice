package Huawei;

import java.util.Scanner;

//0709
//符号激活
public class problem4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(a + b);
//        }

        int n = in.nextInt();
        int[] runes = new int[n];
        for (int i = 0; i < n; i++) {
            runes[i] = in.nextInt();
        }

        int count = 0;
        boolean[] hasCrystal = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(runes[i] == 1){
                if(i > 0 && hasCrystal[i-1]){
                    continue;
                }

                if(i + 1 < n && runes[i+1] == 0){
                    hasCrystal[i+1] = true;
                    count++;
                }else if(i > 0 && runes[i-1] == 0){
                    hasCrystal[i-1] = true;
                    count++;
                }else {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(count);

    }
}
