

/**
 * Created with IntelliJ IDEA.
 * Description: 微信红包
 * 春节期间小明使用微信收到了很多个红包, 非常开心.
 * 在查看领取红包记录时发现, 某个红包金额出现的次数超过了红包总数的一半.
 * 请帮 小明找到该红包的金额. 写出具体算法思路和代码实现. 要求算法尽可能高效.
 * 给定一个红包的金额数组 gifts 及它的大小 n, 请返回所求红包的金额.若没有金额超过总数的一半, 返回0
 *
 * [1, 2, 3, 2, 2], 5     返回 2
 * User: HHH.Y
 * Date: 2020-06-24
 */
public class Red_Packet {
    public static int getValue(int[] gifts, int n) {
        int num  = n / 2;
        for (int i = 0; i < gifts.length; i++) {
            int count = 0;
            for (int j = 0; j < gifts.length; j++) {
                if(gifts[j] == gifts[i]) {
                    count++;
                }
            }
            if(count >= num) {
                return gifts[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] gifts = {1, 2, 3, 2, 2};
        int n = 5;
        System.out.println(getValue(gifts, n));
    }
}
