package Classic150.Bitwise;

//给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。

public class problem5 {
    public int rangeBitwiseAnd(int left, int right) {
        int step = 0;
        for (; step < 32; step++) {
            if (left == right){
                break;
            }
            left >>>= 1;
            right >>>= 1;
        }
        return left <<= step;
    }
}
