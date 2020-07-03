import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 守形数
 * 守形数是这样一种整数，它的平方的低位部分等于它本身，比如 25 的平方是 625，低位部分是25，因此 25 是一个守形数
 * 编写一个程序，判断 N 是否为守形数
 * 输入：
 * 输入包括 1 个整数 N，2 <= N < 100
 *
 * 输出描述：
 * 可能有多组测试数据，对于每组数据，输出"Yes!", 表示 N 是守形数
 * 输出 "No!", 表示 N 不是守形数
 * User: HHH.Y
 * Date: 2020-07-03
 */
public class KeepShapeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int inputNum = scanner.nextInt();
            judgeIsKeepShapeNum(inputNum);
        }
    }

    private static void judgeIsKeepShapeNum(int inputNum) {
        int squareNum = inputNum * inputNum;
        String ret = String.valueOf(squareNum);
        if(ret.endsWith(String.valueOf(inputNum))) {
            System.out.println("Yes!");
        } else {
            System.out.println("No!");
        }

    }
}
