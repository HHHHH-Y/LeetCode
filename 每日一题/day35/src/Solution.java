/**
 * Created with IntelliJ IDEA.
 * Description: 风口的猪 - 中国牛市
 * User: HHH.Y
 * Date: 2020-07-10
 */
public class Solution {
    public static int calculateMax(int[] prices) {
        int firstBuy = Integer.MAX_VALUE; // 第一次买入的价格
        int afterFirstSell = 0; // 第一次的收益
        int afterSecondBuy = Integer.MIN_VALUE; // 第二次买完之后剩的钱
        int afterSecondSell = 0; // 第二次的收益

        for (int curPrice:prices) {
            // 1. 第一次买入股票的价钱, 越小越好
            firstBuy = Math.min(firstBuy, curPrice);
            // 2.第一次的收益, 越多越好
            afterFirstSell = Math.max(afterFirstSell, curPrice - firstBuy);
            // 3. 第二次买完后剩的钱, 越多越好
            afterSecondBuy = Math.max(afterSecondBuy, afterFirstSell - curPrice);
            // 4. 第二次的收益, 越多越好
            afterSecondSell = Math.max(afterSecondSell, afterSecondBuy + curPrice);
        }
        return afterSecondSell;
    }

    public static void main(String[] args) {
        int[] prices = {3, 8, 5, 1, 7, 8};
        System.out.println(calculateMax(prices));
    }
}
