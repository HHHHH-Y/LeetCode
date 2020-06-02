import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 某商店规定: 三个空汽水瓶可以换一瓶汽水. 小张手上有十个空汽水瓶, 她最多可以换多少瓶汽水喝?   答案是5瓶, 方法如下:
 * 先用9个空瓶子换3瓶汽水, 喝掉3瓶满的, 喝完以后4个空瓶子, 用3个再换一瓶, 喝掉这瓶满的, 这时候剩2个空瓶子, 然后你让老板先借你一瓶汽水,
 * 喝掉这瓶满的, 喝完以后用3个空瓶子换一瓶满的还给老板.
 * 如果小张手上有n个空瓶子, 最多可以换多少瓶汽水喝?
 *
 * 输入: 输入文件最多包含10组测试用例,每个数据占一行, 仅包含一个正整数n (1 <= n <= 100), 表示小张手上的空汽水瓶数
 * n = 0 表示输入街商户, 你的程序不应当处理这行
 *
 * 输出: 对于每组测试数据, 输出一行, 表示最多可以喝的汽水瓶数, 如果一瓶也喝不到, 就输出0
 * User: HHH.Y
 * Date: 2020-06-02
 */
public class TestDemo {
    public static int canDrink(int n) {
        if(n < 3) {
            return 0;
        }
        int num = 0; // 表示可以喝到多少瓶汽水
        while (n > 2) {
            num += (n / 3);
            n = (n / 3) + (n % 3);
        }
        if(n == 2) {
            num= num + 1;
            return num;
        }
        return num;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if(n == 0) {
                break;
            }
            System.out.println(canDrink(n));
        }
    }
}
