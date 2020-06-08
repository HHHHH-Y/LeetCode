import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 问题描述
 *
 * 二货小易有一个W*H的网格盒子，网格的行编号为0~H-1，网格的列编号为0~W-1。
 * 每个格子至多可以放一块蛋糕，任意两块蛋糕的欧几里得距离不能等于2。
 * 对于两个格子坐标(x1,y1),(x2,y2)的欧几里得距离为:
 * ( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) ) 的算术平方根
 * 小易想知道最多可以放多少块蛋糕在网格盒子里。
 *
 * 输入: 每组数组包含网格长宽W,H，用空格分割.(1 ≤ W、H ≤ 1000)     3   2
 * 输出: 输出一个最多可以放的蛋糕数,                              4
 *
 * 思路: 通过题意, 进行画图, 可以得到一个有规律的图, 如下所示
 *   1 1 0 0 1 1 0 0 1 1 0
 *   1 1 0 0 1 1 0 0 1 1 0
 *   0 0 1 1 0 0 1 1 0 0 1
 *   0 0 1 1 0 0 1 1 0 0 1
 *   1 1 0 0 1 1 0 0 1 1 0
 * 可以得到:
 * 1. 如果行(列)是 4 的倍数, 那么每一行(列)就可以放行(列)的一半, 所以总共可以放 (行 * 列) / 2 这么多蛋糕
 * 2. 如果行和列均不是 4 的倍数, 每放两个蛋糕, 就需要隔开两个格之后再放, 所以存的蛋糕数是 奇数个 + 1
 * User: HHH.Y
 * Date: 2020-06-08
 */
public class Euclid {
    private static int cakeNums(int width, int length) {
        int count = 0;
        if(width % 4 == 0 || length % 4 == 0) {
            // 行(列)是 4 的倍数, 存放 一半的蛋糕
            count = (width * length) / 2;
        } else {
            // 行和列均不是 4 的倍数, 存放 奇数个 + 1 个蛋糕
            count = (width * length) / 2 + 1;
        }
        return count;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = scanner.nextInt();
        int length = scanner.nextInt();
        System.out.println(cakeNums(width, length));
    }
}
