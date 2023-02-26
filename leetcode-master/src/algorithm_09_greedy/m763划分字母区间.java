package algorithm_09_greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class m763划分字母区间 {
    public static List<Integer> partitionLabels(String s) {
        List<Integer> list = new LinkedList<>();
        int[] edge = new int[26];
        for (int i = 0; i < s.length(); i++) {
            edge[s.charAt(i) - 'a'] = i;
        }
        int left = -1;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(edge[s.charAt(i) - 'a'], right);
            if (i == right) {
                list.add(i - left);
                left = i;
            }
        }
        return list;
    }


    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }
}
