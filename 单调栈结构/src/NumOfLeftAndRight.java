import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 单调栈结构
 * 给定一个不含有重复值的数组 arr, 找到每一个 i 位置左边和右边离 i 位置最近且值比 arr[i] 小的位置
 * 返回所有位置响应的信息
 * User: HHH.Y
 * Date: 2020-07-20
 */
public class NumOfLeftAndRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            outputIndexOfLeftAndRight(arr);
        }
    }

    private static void outputIndexOfLeftAndRight(int[] arr) {
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if(arr[j] < min) {
                    leftIndex = j;
                    break;
                }
            }
            if(j < 0) {
                leftIndex = -1;
            }
            int k = i + 1;
            for (; k < arr.length; k++) {
                if(arr[k] < min) {
                    rightIndex = k;
                    break;
                }
            }
            if(k == arr.length) {
                rightIndex = -1;
            }
            System.out.println(leftIndex + " " + rightIndex);
        }
    }
}
