package real.a;

import java.util.*;
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

public class zhihu1 {

        public static void main(String[] args) {
            int[] salaries = {5000, 1000, 2000};
            int[][] subordinates = {{2, 3}, {}, {}};
            int employeeId = 1;
            System.out.println(getSalaryCost(salaries, subordinates, employeeId));
        }

        public static int getSalaryCost(int[] salary, int[][] subordinate, int id) {
            int cost = salary[id - 1];
            for (int sub : subordinate[id - 1]) {
                cost += getSalaryCost(salary, subordinate, sub);
            }
            return cost;
        }


}
