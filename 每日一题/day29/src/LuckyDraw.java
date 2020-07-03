import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 年会抽奖
 * 输入描述:
 * 输入包含多组数据, 每组数据包含一个正整数 n (2 <= n <= 20)
 * 输出描述:
 * 对应每一组数据, 以 "xx.xx%" 的格式输出发生无人获奖的概率
 *
 * 使用错排算法进行求解
 * User: HHH.Y
 * Date: 2020-07-03
 */
public class LuckyDraw {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            double probability = (count(n) / totalCount(n) ) * 100.0;
            // String,format(String format, Object...args): 制定字符串格式和参数, 生成格式化的新字符串
            System.out.println(String.format("%.2f", probability) + "%");
        }
    }

    // 总共会抽取的次数 (num!)
    private static int totalCount(int n) {
        if(n == 0) {
            return 1;
        }
        return n * totalCount(n - 1);
    }

    // 没有抽中自己名字的抽取次数
    private static double count(int n) {
        if(n == 1) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
        return (n - 1) * (count(n - 1) + count(n - 2));
    }
}
