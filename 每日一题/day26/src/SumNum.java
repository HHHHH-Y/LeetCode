import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 数字之和
 * 对于给定的正整数 n , 计算其十进制形式下所有位置数字之和, 并计算其平方的分为数字之和
 * 输入描述:
 * 每行输入数据包括一个正整数 n (0 < n < 40000)
 *
 * 输出描述:
 * 对于每个输入数据, 计算其各位数字之和, 以及其平方值的数字之和, 输出在一行中, 之间用一个空格分隔, 但行末不要有空格
 * User: HHH.Y
 * Date: 2020-06-30
 */
public class SumNum {
    private static void sumOfNums(int num) {
        int tmp = num;
        int sum1 = 0;
        int sum2 = 0;
        while (tmp != 0) {
            sum1 += tmp % 10;
            tmp /= 10;
        }
        num = num * num;
        while (num != 0) {
            sum2 += num % 10;
            num /= 10;
        }
        System.out.print(sum1 + " " + sum2);

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            sumOfNums(num);
        }
    }
}
