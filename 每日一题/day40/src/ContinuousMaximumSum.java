import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 连续最大和
 * 一个数组有 N 个元素, 求廉租子数组的最大和.
 * 例如: [-1, 2, 1], 和最大的连续子数组为[2, 1], 其和为 3
 *
 * 输入描述:
 * 输入为两行. 第一行一个整数 n (1 <= n <= 100000), 表示一共有 n 个元素
 * 第二行为 n 个数, 即每个元素, 每个整数都在 32 位 int 范围内. 以空格分开
 *
 * 输出描述:
 * 所有连续子数中和最大的值.
 * User: HHH.Y
 * Date: 2020-07-17
 */
public class ContinuousMaximumSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            maxSum(array);
        }
    }

    private static void maxSum(int[] array) {
        int sum = array[0];
        int max = array[0];
        // 从第二个数开始进行遍历
        for (int i = 1; i < array.length; i++) {
            // 只要前面的数的和是 > 0 的, 说明对后面计算连续最大和是有帮助的, 应该在这个和的基础上再进行计算
            if(sum >= 0) {
                sum += array[i];
            } else {
                // 如果前面的数的和 < 0, 则对后面计算连续最大和是没有帮助的, 所以应该丢掉, 让其和直接等于当前值
                sum = array[i];
            }
            if(sum > max) {
                max = sum;
            }
        }
        System.out.println(max);
    }
}
