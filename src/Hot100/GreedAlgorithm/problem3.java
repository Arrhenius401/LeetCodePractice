package Hot100.GreedAlgorithm;

public class problem3 {
    public int jump(int[] nums) {
        int max = 0, cur = 0, count = 0, lastMax = 0;

        while (cur < nums.length && cur <= max) {
            if(max >= nums.length-1){
                break;
            }

            for(int i=cur; i<=lastMax; i++){
                if (max < i + nums[i]) {
                    max = i + nums[i];
                }
            }
            cur = lastMax+1;
            lastMax = max;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,1,1,1};
        problem3 p = new problem3();

        System.out.println(p.jump(nums));
    }
}
