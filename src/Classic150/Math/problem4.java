package Classic150.Math;

public class problem4 {
    public int trailingZeroes(int n) {
        int ans = 0;

        for (int i = 5; i <= n ; i += 5) {
            int temp = i;
            while(temp % 5 == 0){
                ans++;
                temp /= 5;
            }
        }
        
        return ans;
    }

    public static void main(String[] args) {
        int n = 13;
        problem4 p = new problem4();

        System.out.println(p.trailingZeroes(n));
    }
}
