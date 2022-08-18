package algorithm_03_hashtable;

import java.util.HashMap;
import java.util.Map;

public class e454_四数相加2 {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0 ;
        for ( int i = 0; i < nums1.length; i++ ) {
            for ( int j = 0; j < nums2.length; j++ ) {
                if ( map.containsKey( nums1[i] + nums2[j] ) ) {
                    map.put( nums1[i] + nums2[j] , map.get( nums1[i] + nums2[j] ) + 1 );
                }else {
                    map.put( nums1[i] + nums2[j] , 1 );
                }
            }
        }
        for ( int i = 0; i < nums3.length; i++ ) {
            for ( int j = 0; j < nums4.length; j++ ) {
                if ( map.containsKey( 0 - nums3[i] - nums4[j] ) ) {
                    res += map.get( 0 - nums3[i] - nums4[j] );
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};
        int res = fourSumCount(nums1, nums2, nums3, nums4);
        System.out.println(res);
    }
}
