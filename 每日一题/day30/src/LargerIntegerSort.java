import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 大整数排序
 * 对 N 个长度最长可达 1000 的数进行排序
 * 输入描述:
 * 输入第一行为一个整数 N, (1 <= N <= 100)
 * 接下来的 N 行每行有一个数, 数的长度范围为: 1 <= len <= 1000
 * 每个数都是一个正数, 并且保证不包含前缀零
 *
 * 输出描述:
 * 可能多组测试数据, 对于每组数据, 将给出的 N 个数从小到大进行排序, 输出排序后的结果, 每个数占一行
 * User: HHH.Y
 * Date: 2020-07-05
 */
public class LargerIntegerSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            ArrayList<BigInteger> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                list.add(new BigInteger(scanner.next()));
            }
            Collections.sort(list);
            for (BigInteger num:list) {
                System.out.println(num);
            }
        }
    }
}
