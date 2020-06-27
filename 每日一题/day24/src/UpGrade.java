import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 小易的升级之路
 * User: HHH.Y
 * Date: 2020-06-27
 */
public class UpGrade {
    private static int the_Biggest_Common_Restrain(int a, int b) {
        // 使用辗转相除法求最大公约数
        int c = a % b;
        while (c != 0) {
            a = b;
            b = c;
            c = a % b;
        }
        return b;
    }
    private static void ability_Value(int a, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] <= a) {
                a += array[i];
            } else {
                a += the_Biggest_Common_Restrain(a, array[i]);
            }
        }
        System.out.println(a);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            ability_Value(a, array);
        }
    }
}
