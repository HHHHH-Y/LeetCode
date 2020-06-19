import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 火车进站
 * 给定一个正整数 N 代表火车数量，0 < N < 10
 * 接下来输入火车入栈的序列，一共 N 辆或者，每辆火车以数字 0 - 9 编号。
 * 要求以字典序排序输出火车出栈的序号
 *
 * 输入描述：
 * 有多组测试用例，每一组第一行输入一个正整数 N（0 < N < 10），第二行包括 N 个 整数，范围是 1 到 9
 *
 * 输出描述：
 * 输出以字典序从小到大排序的火车出栈列号，每个编号以空格隔开，每个输出序列换行，具体见 sample
 *
 * 输入： 3
 *       1 2 3
 * 输出：
 *       1 2 3
 *       1 3 2
 *       2 1 3
 *       2 3 1
 *       3 2 1
 *
 * 本题就是求有几种出栈顺序，并分别打印这些出栈顺序
 * User: HHH.Y
 * Date: 2020-06-19
 */
public class TrainGoIntoStation {
    private static void stackOutput(int[] push) {

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int[] push = new int[N];
            for (int i = 0; i < N; i++) {
                push[i] = scanner.nextInt();
            }
            stackOutput(push);
        }
    }
}
