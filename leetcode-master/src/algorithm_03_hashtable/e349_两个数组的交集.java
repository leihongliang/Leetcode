package algorithm_03_hashtable;

import java.util.Arrays;
import java.util.HashSet;

public class e349_两个数组的交集 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();

        for ( int i = 0; i < nums1.length; i++ ) {
            set1.add(nums1[i]);
        }
        for ( int i = 0; i < nums2.length; i++ ) {
            if ( set1.contains(nums2[i]) ) {
                set2.add(nums2[i]);
            }
        }
        int[] res = new int[set2.size()];
        int i = 0;
        for ( int set : set2 ) {
            res[i++] = set;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3};
        int[] b = {2, 2};
        int[] res = intersection(a, b);
        System.out.println(Arrays.toString(res));


    }
}
