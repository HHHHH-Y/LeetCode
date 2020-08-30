package huyue;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: 归并排序练习
 * User: HHH.Y
 * Date: 2020-08-30
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = {10, 6, 7, 1, 3, 9, 4, 5};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int[] array) {
        mergeSortInternal(array, 0, array.length - 1);
    }

    private static void mergeSortInternal(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }

        // 分解
        int mid = (left + right) >>> 1;
        mergeSortInternal(array, left, mid);
        mergeSortInternal(array, mid + 1, right);

        // 合并
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int s1 = left;
        int s2 = mid + 1;
        int len = right - left + 1;
        int[] ret = new int[len];
        int index = 0;
        while (s1 <= mid && s2 <= right) {
            if(array[s1] <= array[s2]) {
                ret[index++] = array[s1++];
            } else {
                ret[index++] = array[s2++];
            }
        }
        while (s1 <= mid) {
            ret[index++] = array[s1++];
        }
        while (s2 <= right) {
            ret[index++] = array[s2++];
        }

        for (int i = 0; i < ret.length; i++) {
            array[i + left] = ret[i];
        }
    }
}
