package real.a;

/*
*
数字为1~N的扑克牌组成一组，每次从1~N的一组牌中等概率抽中一张牌，下一次抽会从另一组数字为1~N的扑克牌中抽牌，有无限组1~N的牌
当累加和小于a时，你将一直抽牌，当累加和大于等于a，小于b时，你将获胜，当累加和大于等于b时，你将失败。返回获胜的概率，概率值为小于1的double类型浮点数，给定的参数为N,a,b，其中N 小于等于13，a,b小于等于100
示例1
输入输出示例仅供调试，后台判题数据一般不包含示例
输入
10,17,21
输出
0.62929
* */
public class qunaer3求扑克牌获胜概率 {


    public static double percent(int N, int a, int b) {
        if(N < 1 || a >= b || a < 0){
            return 0.0;
        }
        if(b-a>=N){
            return 1.0;
        }
        return p2(0,N,a,b);
    }
    public static double p2(int cur,int N,int a,int b){
        if(cur>=a&&cur<b){
            return 1.0;
        }
        if(cur>=b){
            return 0.0;
        }
        double w=0.0;
        for (int i = 1; i <=N ; i++) {
            w+=p2(cur+i,N,a,b);
        }
        return w/N;
    }

    public static void main(String[] args) {
        int N = 10;
        int a = 17;
        int b = 21;
        double result = percent(N, a, b);
        System.out.printf("%.5f\n", result);
    }

}

