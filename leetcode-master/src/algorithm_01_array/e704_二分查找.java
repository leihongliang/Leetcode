package algorithm_01_array;

public class e704_二分查找 {
    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while ( l <= r){
            mid = l + (( r - l ) >> 1);
            if ( target > nums[mid] ) {
                l = mid + 1;
            }else if  ( target < nums[mid] ){
                r = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        System.out.println(search(nums, 9));
    }
}

