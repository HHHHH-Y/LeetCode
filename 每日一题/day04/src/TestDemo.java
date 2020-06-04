import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 问题描述
 * 小易去附近的商店买苹果， 商贩使用了捆绑交易， 只提供6个每袋和8个每袋的包装
 * 小易只想购买n个苹果， 小易想购买尽量少的袋数方便携带， 如果不能购买恰好 n个苹果， 小易将不会购买
 * <p>
 * 输入描述： 输入一个整数 n, 表示小易想购买的苹果数（1 <= n <= 100）
 * 输出描述: 输出一个整数表示最少需要购买的袋数, 如果不能买恰好 n 个苹果则输出-1;
 * User: HHH.Y
 * Date: 2020-06-04
 */
public class TestDemo {
    public static int nums(int n) {
        // 由 6 和 8 的特性可以得知,袋子中只能装偶数个苹果, 不能装奇数个苹果
        if (n < 6 || n == 10 || n % 2 == 1) {
            return -1;
        }
        // 由于要用最少的袋子装苹果, 因此应该选择尽可能用 8 个袋子装
        // 1. 如果 n % 8 == 0, 说明直接可以用容量为 8 的袋子装下
        if (n % 8 == 0) {
            return n / 8;
        }
        // 2. 如果 n % 8 != 0, n % 8 只可能为 2, 4, 6
        // 3. 如果余数为6, 直接一个容量为 6 的袋子装, n / 8 + 1;
        // 4. 如果余数为4, 去掉一个容量为 8 的袋子, 使用两个容量为6的袋子, n / 8 - 1 + 2 = n / 8 + 1;
        // 5. 如果余数为2, 去掉两个容量为 8 的袋子, 使用3个容量为6的袋子, n / 8 - 2 + 3 = n / 8 + 1
        return n / 8 + 1;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(nums(n));
    }
}
