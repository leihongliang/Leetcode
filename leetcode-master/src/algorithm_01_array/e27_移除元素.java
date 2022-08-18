package algorithm_01_array;

public class e27_移除元素 {
    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        for ( int i = 0; i < length; i++) {
            if ( nums[i] == val ){
                for (int j = i ; j < length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                i--;
                length--;
            }
        }
        return length;
    }
    public static int removeElement2(int[] nums, int val) {
        int fast = 0;
        int slow = 0;
        for ( fast = 0; fast < nums.length; fast++) {
            if ( nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    /**
     * 22.8.6 二刷
     */
    public static int removeElement3(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        for (fast = 0; fast < nums.length; fast ++) {
            if (val != nums[fast]) {
                nums[slow] = nums[fast];
                slow ++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
//        int[] nums = { 0,1,2,2,3,0,4,2 };
        int[] nums = { 0,2,3,2 };
        int res = removeElement3(nums, 2);
        System.out.println(res);
    }
}

