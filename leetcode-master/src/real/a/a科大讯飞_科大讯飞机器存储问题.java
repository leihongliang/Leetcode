package real.a;

import java.util.*;


public class a科大讯飞_科大讯飞机器存储问题 {

    public static void main2(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 3, 1};
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) { //开头
            for (int j = i; j < nums1.length; j++) { //结尾
                List<Integer> list = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    list.add(nums1[k]);
                }
                res.add(list);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            for (int j = i; j < nums2.length; j++) {
                List<Integer> list = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    list.add(nums2[k]);
                }
                res.add(list);
            }
        }
        Set<List<Integer>> set = new HashSet<>(res);
        System.out.println(set.size());
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 3, 1};
        Map<List<Integer>, Integer> res = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) { //开头
            for (int j = i; j < nums1.length; j++) { //结尾
                List<Integer> list = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    list.add(nums1[k]);
                }
                res.put(list, res.getOrDefault(list, 0) + 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            for (int j = i; j < nums2.length; j++) {
                List<Integer> list = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    list.add(nums2[k]);
                }
                res.put(list, res.getOrDefault(list, 0) + 1);
            }
        }
//        Set<List<Integer>> set = new HashSet<>(res);
        System.out.println(res.size());
    }
}
