import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: 归并排序
 * 算法思想:
 * 归并排序分为拆分和归并两步
 * User: HHH.Y
 * Date: 2020-08-11
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {10, 6, 7, 1, 3, 9, 4, 5};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr) {
        mergeSortInter(arr, 0, arr.length - 1);
    }

    private static void mergeSortInter(int[] arr, int left, int right) {
        if(left >= right) {
            return;
        }
        int mid = (left + right) >>> 1;
        mergeSortInter(arr, left, mid);
        mergeSortInter(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int s1 = left;
        int s2 = mid + 1;
        int len = right - left + 1;
        int[] ret = new int[len];
        int index = 0;
        while (s1 <= mid && s2 <= right) {
            if(arr[s1] <= arr[s2]) {
                ret[index++] = arr[s1++];
            } else {
                ret[index++] = arr[s2++];
            }
        }
        while (s1 <= mid) {
            ret[index++] = arr[s1++];
        }
        while (s2 <= right) {
            ret[index++] = arr[s2++];
        }

        for (int i = 0; i < ret.length; i++) {
            arr[i + left] = ret[i];
        }
    }


}
