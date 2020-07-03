import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 数字和为 sum
 * 给定一个有 n 个正整数的数组 A 和一个整数 sum, 求选择数组 A 中部分数字和为 sum 的方案数
 * 当两种选取方案有一个数字的下标不一样, 我们就认为是不同的组成方案
 *
 * 思路: 使用动态规划求解
 * 将数组元素想象成 重量为 A[i] 的石头
 * 将 sum 想象成 体积为 sum 的背包
 * User: HHH.Y
 * Date: 2020-07-03
 */
public class SumNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = scanner.nextInt();
        int[] arr = new int[n + 1]; // 数组 A 中的元素(包括 0 元素)
        long[][] dp = new long[n + 1][sum + 1]; // 定义一个二维数组, 以 sum 的值为横坐标, 以 A 中元素值为纵坐标
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1; // A[i] 重量的石头放进体积为 0 的背包的方法只有 1 种, 就是不放进去
        }
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
            for (int j = 0; j <= sum; j++) {
                if(j >= arr[i]) {
                    // 如果放进去石头的重量 A[i] 是小于 j 的, 放入的方法为: 没有放入 A[i] 重量的石头前的放法 + 放入 A[i] 重量的石头后的放法
                    //  放入 A[i] 重量的石头后的放法 == 放入 A[i] 重量的石头前, 背包体积为 j - A[i] 时的放法.
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i]];
                } else {
                    // 如果放进去石头的重量 A[i] 是大于 j 的, 放入它和没放的情况是一样的
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][sum]);
    }
}
