package huyue;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: 快速排序练习
 * User: HHH.Y
 * Date: 2020-08-30
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {6, 1, 2, 7, 9, 3};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    // 使用递归进行快速排序
    private static void quickSort(int[] array) {
        quick(array, 0, array.length - 1);
    }

    private static void quick(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }
        // 求出基准值
        int par = partition(array, left, right);
        // 开始递归
        quick(array, left, par - 1);
        quick(array, par + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int tmp = array[left];
        while (left < right) {
            while (left < right && array[right] >= tmp) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= tmp) {
                left++;
            }
            array[right] = array[left];
        }
        array[right] = tmp;
        return right;
    }
}
