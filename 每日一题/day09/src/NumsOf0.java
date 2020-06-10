import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 输入一个正整数 n(1 <= n <= 1000), 求 n!末尾有多少个 0? 如: n = 10, n! = 3628800, 所以返回 2
 *
 * 思路:
 * 若 n 较大, 由于直接计算出 n!会产生溢出, 所以应该采用另一种方式
 * 由于 2 * 5 一定会产生一个 0, 但是由于在 n 个数中, 包含有 2 的因子太多, 如: 2, 4, 6, 8..., 所以问题就转化成了求包含 5 的因子
 * 包含 5 的因子只有 5 的倍数.
 * 问题就转化成了求 5 的个数, 有几个5, 就说明有几个 0
 * User: HHH.Y
 * Date: 2020-06-10
 */
public class NumsOf0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        for (int i = n; i >= 5; i--) {
            int tmp = i;
            while (tmp % 5 == 0) {
                // 说明 tmp 一定是 5 的倍数
                // 求 tmp 中有多少个 5
                count++;
                tmp /= 5;
            }
            //  否则说明 tmp 一定不是 5 的倍数
        }
        System.out.println(count);
    }
}
