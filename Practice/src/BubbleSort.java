import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: 冒泡排序
 * User: HHH.Y
 * Date: 2020-09-09
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7, 3, 6, 4, 5, 8, 0};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        // 使用 i 来控制冒泡泡排序的趟数
        for (int i = 0; i < arr.length; i++) {
            // 使用 j 来控制一次排序需要比较的次数
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
