import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: 快速排序
 * User: HHH.Y
 * Date: 2020-09-09
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 7, 9, 3};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr) {
        quick(arr, 0, arr.length - 1);
    }

    private static void quick(int[] arr, int left, int right) {
        // 1. 递归结束的条件
        if(left >= right) {
            return;
        }
        // 2. 找到基准值
        int par = partition(arr, left, right);
        // 3. 左递归
        quick(arr, left, par - 1);
        // 4. 右递归
        quick(arr, par + 1, right);
    }

    // 寻找基准值
    private static int partition(int[] arr, int left, int right) {
        int tmp = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= tmp) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= tmp) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[right] = tmp;
        return right;
    }
}
