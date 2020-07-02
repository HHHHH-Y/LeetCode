import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 找 x
 * 输入一个数 n, 然后输入 n 个数值各不相同, 在输入一个值 x, 输出这个值在这个数组中的下标(从 0 开始, 若不在数组中则输出 -1)
 *
 * 输入描述:
 * 测试数据有多组, 输入n (1 <= n <= 200), 接着输入 n 个数, 然后输入 x
 *
 * 输出描述:
 * 对于每组输入, 请输出结果
 * User: HHH.Y
 * Date: 2020-07-02
 */
public class findX {
    private static int indexOfX(int[] array, int x) {
        int i = 0;
        int ret = 0;
        for (; i < array.length; i++) {
            if(array[i] == x) {
                ret = i;
                break;
            }
        }
        if(i == array.length) {
            ret = -1;
        }
        return ret;

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            int x = scanner.nextInt();
            System.out.println(indexOfX(array, x));
        }
    }
}
