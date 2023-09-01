package real.a;

import java.util.HashMap;
import java.util.Map;

class Main {
    public static void main2(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("a", 1);
        System.out.println(map.size());
    }



    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        // 读取输入的三个整数 x, y, z
        int x = 1;
        int y = 2;
        int z = 10;
//        sc.close();
        // 创建一个数组 dp，表示每天的成长值
        int[] dp = new int[z + 1];
        // 初始化第一天的成长值为 x
        dp[1] = x;
        // 从第二天开始，遍历每一天的成长值
        for (int i = 2; i <= z; i++) {
            // 如果前一天的成长值加上浇水的成长值大于等于果树成熟的成长值，那么直接输出 i 并结束程序
            if (dp[i - 1] + x >= z) {
                System.out.println(i);
                return;
            }
            // 否则，计算当前天的成长值为前一天的成长值加上浇水的成长值
            dp[i] = dp[i - 1] + x;
            // 如果当前天距离上次施肥的时间大于等于 2 天，那么可以考虑施肥
            if (i >= 3) {
                // 如果前两天的成长值加上施肥的成长值大于等于果树成熟的成长值，那么直接输出 i 并结束程序
                if (dp[i - 2] + y >= z) {
                    System.out.println(i);
                    return;
                }
                // 否则，比较当前天的成长值和前两天的成长值加上施肥的成长值，取较大者作为当前天的成长值
                dp[i] = Math.max(dp[i], dp[i - 2] + y);
            }
        }
}


}