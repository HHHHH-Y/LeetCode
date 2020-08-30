package huyue;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: 冒泡排序
 * User: HHH.Y
 * Date: 2020-08-30
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 4, 5, 8, 0};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void bubbleSort(int[] array) {
        // 用 i 来表示冒泡排序的趟数
        for (int i = 0; i < array.length; i++) {
            // 用 j 来表示每一趟排序的比较次数
            for (int j = 0; j < array.length - 1 - i; j++) {
                if(array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }
}
