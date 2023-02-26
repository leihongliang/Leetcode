package algorithm_09_greedy;

public class m714买卖股票的最佳时机含手续费 {
    public static int maxProfit(int[] prices, int fee) {
        int buy = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            }
            if (prices[i] > buy + fee) {
                res += prices[i] - buy - fee;
                buy = prices[i] - fee;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 9};
        int res = maxProfit(prices, 2);
        System.out.println(res);
    }
}
