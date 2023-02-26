package algorithm_09_greedy;

class Solution3 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int res = -1;
        int cur = 0;
        for (int i = 0; i < gas.length; i++) {
            cur += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if(cur < 0) {
                res = (i + 1) % gas.length ;
                cur = 0;
            }
        }
        if (sum < 0) res = -1;
        return res;
    }
}
public class m134加油站 {
    public static void main(String[] args) {
        int[] gas = {3,1,1};
        int[] cost = {1,2,2};
        int res = new Solution3().canCompleteCircuit(gas, cost);
        System.out.println(res);
    }
}
