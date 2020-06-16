import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 组个最小数
 * 给定数字 0 - 9 各若干. 你可以任意顺序排列这些数字, 但必须全部使用
 * 目标是是的最后得到的数尽可能小(注意, 0不能做首位).
 * 例如: 给定两个0,  两个1, 三个5, 一个8, 我们得到的最小数就是: 10015558
 * 现给定数字, 请编写程序输出能够组成的最小的数
 * User: HHH.Y
 * Date: 2020-06-16
 */
public class GroupOfMiniNum {
    private static void minNum(int[] input) {
        for (int i = 1; i < input.length; i++) {
            if(input[i] != 0) {
                System.out.print(i);
                input[i] = input[i] - 1;
                break;
            }
        }
        for (int i = 0; i < input.length; i++) {
            if(input[i] != 0) {
                for (int j = 0; j < input[i]; j++) {
                    System.out.print(i);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = new int[10];
        for (int i = 0; i < input.length; i++) {
            input[i] = scanner.nextInt();
        }
        minNum(input);
    }
}
