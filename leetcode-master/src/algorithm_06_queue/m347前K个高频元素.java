package algorithm_06_queue;

import java.util.*;


class m347前K个高频元素 {
    public static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            res[i] = queue.poll().getKey();
        }
        return res;
    }
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,4,4,4,4};
        int[] res = topKFrequent(nums, 2);
        System.out.println(Arrays.toString(res));
    }
}

