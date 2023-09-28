package real.a;

/*
人力资源部门需要统计公司某个员工的薪酬成本，该成本由以下两部分加和组成：

该员工的薪酬
该员工的所有下属的薪酬
给出两个数组，第一个数组每个元素是员工的薪酬；第二个数组每个元素是该员工的直接下属编号列表；数组下标+1 即为员工的编号
现在输入一个公司的所有员工信息列表，以及单个员工的编号 ，返回这个员工的薪酬成本

示例1
输入输出示例仅供调试，后台判题数据一般不包含示例
输入
[5000, 1000, 2000],[[2, 3], [], []],1

输出
8000
说明
员工 1 的薪酬是 5000，他有两个直接下属 2 和 3 ；员工 2 的薪酬是 1000，没有直接下属；员工 3 的薪酬是 2000，没有直接下属。因此员工 1 的薪酬成本是 5000+1000+2000=8000

* */

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class xunlei2合并区间 {

        public static void main(String[] args) {
            int[] salaries = {5000, 1000, 2000};
            int[][] subordinates = {{2, 3}, {}, {}};
            int employeeId = 1;
        }

    public int[] solution(int[] intervals) {
        // 在这⾥写代码
        int n = intervals.length / 2;
        int[][] intervalArr = new int[n][2];
        int index = 0;
        for (int i = 0; i < n; i++) {
            intervalArr[i][0] = intervals[index++];
            intervalArr[i][1] = intervals[index++];
        }
        LinkedList<int[]> res = new LinkedList<>();
        Arrays.sort(intervalArr, Comparator.comparingInt(a -> a[0]));
        res.add(intervalArr[0]);
        for (int i = 1; i < n; i++) {
            if (intervalArr[i][0] <= res.getLast()[1]) {
                int start = res.getLast()[0];
                int end = Math.max(intervalArr[i][1], res.getLast()[1]);
                res.removeLast();
                res.add(new int[] {start, end});
            }
            else {
                res.add(intervalArr[i]);
            }
        }
        int[] ans = new int[res.size() * 2];
        index = 0;
        for (int i = 0; i < ans.length; i += 2) {
            ans[i] = res.get(index)[0];
            ans[i + 1] = res.get(index)[1];
            index++;
        }
        return ans;
    }


}
