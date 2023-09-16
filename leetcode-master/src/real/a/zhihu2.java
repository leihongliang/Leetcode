package real.a;

/*
在一次公司组织的活动中， n 个参与者分别答题，每个人的得分都存储在 score[n]的数组当中。

需要按照下面两个要求，给参与者发放知乎吉祥物刘看山玩偶进行奖励：

每个人不管多少分，至少分得一个刘看山玩偶
任意两个相邻的人之间，得分较多的必须拿多一些刘看山玩偶
请计算出最少需要多少个刘看山玩偶可以满足发放要求。

示例1
输入输出示例仅供调试，后台判题数据一般不包含示例
输入
复制
[1,1,2]
输出
复制
4
说明
最优的分配方案为 1,1,2
* */

import java.util.Arrays;
import java.util.Scanner;

public class zhihu2 {
    public static void main(String[] args)  {


        int[] scores = {1,2,2};
        System.out.println(prize(scores));

    }
    public static int prize (int[] scores) {
        int n = scores.length;
        int[] candy = new int[n];
        Arrays.fill(candy, 1);
        for(int i = 1; i < n; i++){
            if(scores[i] > scores[i - 1] && candy[i] <= candy[i - 1])
                candy[i] = candy[i - 1] + 1;
        }
        for(int i = n - 2; i >= 0; i--){
            if(scores[i] > scores[i + 1] && candy[i] <= candy[i + 1])
                candy[i] = candy[i + 1] + 1;
        }
        int total = 0;
        for(int i = 0; i < n; i++) {
            total += candy[i];
        }
        return total;
    }
}
