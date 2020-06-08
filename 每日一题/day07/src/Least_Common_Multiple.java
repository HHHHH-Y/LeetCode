import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 问题描述
 * 求最小公倍数
 * User: HHH.Y
 * Date: 2020-06-08
 */
public class Least_Common_Multiple {
    private static void func(int A, int B) {
        int max = Math.max(A, B);
        int i = max;
        for (; i < A * B; i++) {
            if(i % A == 0 && i % B == 0) {
                System.out.println(i);
                break;
            }
        }
        if(i == A * B) {
            System.out.println(A * B);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        func(A, B);
    }
}
