import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 问题描述
 * Fibonacci数列是这样定义的：
 * F[0] = 0
 * F[1] = 1
 * for each i ≥ 2: F[i] = F[i-1] + F[i-2]
 * 因此，Fibonacci数列就形如：0, 1, 1, 2, 3, 5, 8, 13, ...
 * 在Fibonacci数列中的数我们称为Fibonacci数。
 * 给你一个N，你想让其变为一个Fibonacci数，每一步你可以把当前数字X变为X-1或者X+1
 * 现在给你一个数N求最少需要多少步可以变为Fibonacci数。
 *
 * 输入描述:
 * 输入为一个正整数N(1 ≤ N ≤ 1,000,000)  15
 *
 * 输出描述:
 * 输出一个最小的步数变为Fibonacci数"  2
 * User: HHH.Y
 * Date: 2020-06-11
 */
public class FibonacciArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int f1 = 0;
        int f2 = 1;
        int f3 = f1 + f2;
        while (true) {
            if(f2 == n) {
                System.out.println(0);
                break;
            } else if(f2 > n){
                if(Math.abs(f2 - n) > Math.abs(n - f1)) {
                    System.out.println(Math.abs(n - f1));
                } else {
                    System.out.println(Math.abs(f2 - n));
                }
                break;
            }
            f1 = f2;
            f2 = f3;
            f3 = f1 + f2;
        }
    }
}
