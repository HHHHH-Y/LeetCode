import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 合唱团
 * 有 n 个学生站成一排, 每个学生有一个能力值, 牛牛想从这 n 个学生中按照顺序选取 k 名学生
 * 要求相邻两个学生的位置编号的差不超过 d, 使得这 k 个学生的能力值的乘积最大, 你能返回最大的乘积吗?
 *
 * 输入描述:
 * 每个输入包含 1 个测试用例. 每个测试数据的第一行包含一个整数 n (1 <= n <= 50), 表示学生的个数
 * 接下来的一行, 包含 n 个整数, 按顺序表示每个学生的能力值 ai (-50 <= ai <= 50).
 * 接下来的一行包含两个整数, k 和 d (1 <= k <= 10, 1 <= d <= 50).
 *
 * 输出描述:
 * 输出一行表示最大的乘积
 *
 * 使用 动态规划 求解
 * User: HHH.Y
 * Date: 2020-07-24
 */
public class GleeClub {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 总人数
            int n = scanner.nextInt();
            // 学生能力值数组, 第 i 个人直接对应 arr[i]
            int[] arr = new int[n + 1];
            // 初始化
            for (int i = 1; i <= n; i++) {
                arr[i] = scanner.nextInt();
            }
            // 选择的学生数
            int kk = scanner.nextInt();
            // 间距
            int dd = scanner.nextInt();

            output(n, arr, kk , dd);
        }
    }

    private static void output(int n, int[] arr, int kk, int dd) {
        /**
         * 递推的时候, 以 f[one][k] 的形式表示
         * 其中: one 表示最后一个人的位置, k 为包括这个人, 一共有 k 个人
         * 原问题和子问题关系: f[one][k] = max{f[left][k - 1] * arr[one], g[left][k - 1] * arr[one]}
         */
        // 规划数组
        long[][] f = new long[n + 1][kk + 1]; // 人直接对应坐标, n 和 k 都要 + 1
        long[][] g = new long[n + 1][kk + 1];
        // 初始化 k = 1 的情况
        for (int one = 1; one <= n; one++) {
            f[one][1] = arr[one];
            g[one][1] = arr[one];
        }
        // 自底向上递推
        for (int k = 2; k <= kk; k++) {
            for (int one = k; one <= n; one++) {
                f[one][k] = Long.MIN_VALUE;
                g[one][k] = Long.MAX_VALUE;
                for (int left = Math.max(k - 1, one - dd); left <= one - 1; left++) {
                    f[one][k] = Math.max(f[one][k], Math.max(f[left][k - 1] * arr[one], g[left][k - 1] * arr[one]));
                    g[one][k] = Math.min(g[one][k], Math.min(f[left][k - 1] * arr[one], g[left][k - 1] * arr[one]));
                }
            }
        }
        // 当计算出第 k 个人所有可能位置的最大乘积后, 只需要从这些所有可能位置中挑选出最大的那个乘积即可
        long result = Long.MIN_VALUE;
        for (int one = kk; one <= n; one++) {
            if(result < f[one][kk]) {
                result = f[one][kk];
            }
        }
        System.out.println(result);
    }
}
