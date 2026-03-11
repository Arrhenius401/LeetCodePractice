package Huawei;

//0723
//星尘轨迹分析

import java.util.*;

public class problem7 {
    private static int star1 = -1;
    private static int star2 = -1;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(a + b);
//        }

        List<Integer> stars = new ArrayList<>();
        List<Integer> times = new ArrayList<>();

        while (in.hasNext()){
            stars.add(in.nextInt());
            times.add(in.nextInt());
        }

        solution(stars, times);

        System.out.println(star1 + " " + star2);
    }

    private static void solution(List<Integer> stars, List<Integer> times) {
        int n = stars.size();
        int[][] sort = new int[n][2];

        for (int i = 0; i < n; i++) {
            sort[i][0] = stars.get(i);
            sort[i][1] = i == 0 ? times.get(i) : times.get(i) - times.get(i-1);
        }

        Arrays.sort(sort, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }
        });

        star1 = sort[0][0];

        Arrays.sort(sort, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o2[0] - o1[0];
                }

                return o1[1] - o2[1];
            }
        });

        star2 = sort[n-1][0];
    }
}
