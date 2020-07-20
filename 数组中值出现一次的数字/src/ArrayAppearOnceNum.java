import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 数组中值出现一次的数字
 * User: HHH.Y
 * Date: 2020-07-20
 */
public class ArrayAppearOnceNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            findAppearOddsNum(array);
        }
    }

    private static void findAppearOddsNum(int[] array) {
        int tmp = 0;
        for (int i = 0; i < array.length; i++) {
            tmp ^= array[i];
        }
        // 取二进制的最后一位
        int digit = tmp & 1;
        int count = 0;
        while (digit != 1) {
            tmp = tmp >>> 1;
            digit = tmp & 1;
            count++;
        }
        int res1 = 0;
        int res2 = 0;
        for (int i = 0; i < array.length; i++) {
            int t = (array[i] >>> count) & 1;
            if(t == digit) {
                res1 ^= array[i];
            } else {
                res2 ^= array[i];
            }
        }
        if(res1 < res2) {
            System.out.println(res1 + " " + res2);
        } else {
            System.out.println(res2 + " " + res1);
        }
    }
}
