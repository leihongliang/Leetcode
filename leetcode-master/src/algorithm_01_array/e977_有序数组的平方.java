package algorithm_01_array;
import java.util.Arrays;

public class e977_有序数组的平方 {
    public static int[] sortedSquares(int[] nums) {
        for ( int i = 0; i < nums.length; i++){
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
    public static int[] sortedSquares2(int[] nums) {
        int l = 0;
        int r = nums.length -1;
        int[] ans = new int[nums.length];
        for ( int i = nums.length - 1; i > -1; i-- ){
            if ( nums[l] * nums[l] > nums[r] * nums[r] ) {
                ans[i] = nums[l]*nums[l];
                l++;
            }else {
                ans[i] = nums[r] * nums[r];
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = { 0,1,2,2,3,0,4,2 };
        int[] nums = { -3,-2,1,4 };
        nums = sortedSquares2(nums);
        for (  int num : nums) {
            System.out.println(num);
        }
    }
}

