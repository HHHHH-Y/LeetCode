
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 求和
 * 输入两个整数 n 和 m, 从数列 1, 2, 3,..., n 中随意取几个数, 使其和等于 m
 * 要求将其中所有的可能组合列出来
 *
 * 输入描述:
 * 每个测试输入包含两个整数, n 和 m
 * 输出描述:
 * 按每个组合的字典序排列输出, 每行输出一种组合
 *
 * 思路: 实质上就是暴力解决问题, 把所有的情况都枚举出来, 然后筛选出自己想要的打印即可
 * 对于 1, 2, 3, ... , n 的数中随便选出几个来, 只要和是 m, 就以字典序进行打印输出
 * 对于数字 1 而言, 我只有两种选择, 要么要, 要么不要, 要的话就将它加入到结果集中, 不要就直接跳过
 * 对于数字 2 而言, 我也只有两种选择, 要么要, 要么不要. 要的话就将它加到结果集中, 不要的话直接略过.
 * ...
 * 直到数字 n .
 * 结束标志就是直到找到最后一个数字 n 结束之后, 判断结果集的总和是否等于 m, 相等就输出, 不相等就不输出
 * User: HHH.Y
 * Date: 2020-07-20
 */
public class Summation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt(); // n 个数
            int m = scanner.nextInt(); // 和为 m
            int sum = 0; // 用来计算最后的结果
            String res = ""; // 结果字符串
            int[] num = new int[n];
            int j = 1;
            for (int i = 0; i < n; i++) {
                num[i] = j++;
            }
            summation(num, m, res, sum, 0);
        }
    }
    private static void summation(int[] num, int m, String res, int sum, int i) {
        // 如果最后 i 的值等于 num 数组的长度
        if(i == num.length) {
            if(sum == m) {
                System.out.println(res.trim());
            }
            return;
        }
        // 表示我要 num[i] 这个数
        summation(num, m, res + num[i] + " ", sum + num[i], i + 1);
        // 表示我不要 num[i] 这个数
        summation(num, m, res, sum, i + 1);
    }
}
