import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HHH.Y
 * Date: 2020-09-16
 */
public class MaxSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[9];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        int ret = findMaxSumOFNumber(arr);
        System.out.println(ret);
    }

    private static int findMaxSumOFNumber(int[] arr) {
        int ret = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max + arr[i], arr[i]);
            ret = Math.max(max, ret);
        }
        return ret;
    }
}
