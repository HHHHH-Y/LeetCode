import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 输入一个数, 找到它与最近的斐波那契数的距离
 * 斐波那契数列: 0 1 1 2 3 5 8 13...
 * 输入15, 和其最近的斐波那契数是13, 因此相距2, 所以输出2
 * User: HHH.Y
 * Date: 2020-06-03
 */
public class Main {
    public static void main(String[] args) {
        int f1 = 0;
        int f2 = 1;
        int f3 = f1 + f2;
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        while (true) {
            if(f2 == x) {
                System.out.println(0);
                break;
            } else if(f2 > x) {
                if(Math.abs(f2 - x) > Math.abs(x - f1)) {
                    System.out.println(Math.abs(x - f1));
                } else {
                    System.out.println(Math.abs(x - f2));
                }
                break;
            }
            f1 = f2;
            f2 = f3;
            f3 = f1 + f2;
        }
    }
}
