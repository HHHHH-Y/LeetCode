import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 尼科彻斯定理
 * 验证尼科彻斯定理, 即: 任何一个整数 m 的立方都可以写成 m 个连续奇数之和
 * 例如:
 * 1 ^ 3 = 1;
 * 2 ^ 3 = 3 + 5;
 * 3 ^ 3 = 7 + 9 + 11;
 * 4 ^ 3 = 13 + 15 + 17 + 19
 * User: HHH.Y
 * Date: 2020-06-16
 */
//public class NicoChusTheorem {
//    private static void GetSequeOddNum(int m) {
//        int n = (m * (m - 1)) / 2;
//        int num = 1;
//        for (int i = 1; i < n; i++) {
//            num += 2;
//        }
//        for (int i = 1; i <= m; i++) {
//            num += 2;
//            if(i != m) {
//                System.out.print(num + "+");
//            } else {
//                System.out.print(num);
//            }
//        }
//    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int m = scanner.nextInt();
//        GetSequeOddNum(m);
//    }
//}
public class NicoChusTheorem {
    private static void GetSequeOddNum(int m) {
        int n = (m * (m - 1)) / 2;
        int num = 1;
        for (int i = 1; i < n; i++) {
            num += 2;
        }
        for (int i = 1; i <= m; i++) {
            num += 2;
            if(i != m) {
                System.out.print(num + "+");
            } else {
                System.out.print(num);
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            GetSequeOddNum(m);
        }
    }
}