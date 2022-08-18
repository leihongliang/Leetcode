package algorithm_01_array;

public class e209_长度最小的子数组 {
    public static int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        for ( int i = 0; i < nums.length; i++) {
            int sum = 0;
            for ( int j = i; j < nums.length; j++) {
                sum += nums[j];
                if ( sum >= target){
                    res = res > j - i + 1 ? j - i + 1 : res ;
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    public static int minSubArrayLen2(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        int sum = 0;
        for ( r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= target) {
                res = Math.min( res, r - l +1);
                sum -= nums[l];
                l++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    public static void main(String[] args) {
//        int[] nums = { 0,1,2,2,3,0,4,2 };
        int[] nums = { 1,2,3,4,5 };
        int res = minSubArrayLen2(15, nums);
        System.out.println(res);
    }
}

