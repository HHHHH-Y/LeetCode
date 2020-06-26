import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 数字分类
 * 给定一系列正整数，请按照要求对数字进行分类，并输出以下5个数字
 * A1 = 能被 5 整除的数字中所有偶数的和
 * A2 = 将被 5 除后余 1 的数字按给出顺序进行交错求和，即计算 n1 - n2 + n3 - n4 ...
 * A3 = 被 5 除后余 2 的数字的个数
 * A4 = 被 5 除后余 3 的数字的平均数，精确到小数点后 1 位
 * A5 = 被 5 除后余 4 的数字中最大数字
 *
 * User: HHH.Y
 * Date: 2020-06-26
 */
public class NumCategory {
    private static void output(int[] input) {
        int A1 = 0;
        int A2 = 0;
        int flag = 1;
        int A3 = 0;
        float A4 = 0;
        int count = 0;
        int A5 = 0;
        for (int i = 0; i < input.length; i++) {
            switch (input[i] % 5) {
                case 0:
                    if(input[i] % 2 == 0) {
                        A1 += input[i];
                    }
                    break;
                case 1:
                    A2 += flag * input[i];
                    flag = -flag;
                    break;
                case 2:
                    A3++;
                    break;
                case 3:
                    count++;
                    A4 += input[i];
                    break;
                case 4:
                    if(input[i] > A5) {
                        A5 = input[i];
                    }
                    break;
                default:
                    break;
            }
        }
        if(A1 != 0) {
            System.out.print(A1 + " ");
        } else {
            System.out.print("N" + " ");
        }
        if(A2 != 0) {
            System.out.print(A2 + " ");
        } else {
            System.out.print("N" + " ");
        }
        if(A3 != 0) {
            System.out.print(A3 + " ");
        } else {
            System.out.print("N" + " ");
        }
        if(A4 != 0) {
            // DecimalFormat类：用最快的速度将数字格式化为你需要的样子
            DecimalFormat decimalFormat = new DecimalFormat("0.0");
            System.out.print(decimalFormat.format(A4 / count) + " ");
        } else {
            System.out.print("N" + " ");
        }
        if(A5 != 0) {
            System.out.print(A5);
        } else {
            System.out.print("N");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        output(input);
    }
}
