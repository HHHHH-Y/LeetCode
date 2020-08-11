import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: 快速排序
 * 算法思想:
 * 使用挖坑法进行快速排序
 * 首先默认左边第一个元素为基准值, 然后将这个基准值拿出来, 这个时候, 原来基准值的位置就会出现一个坑
 * 然后从右开始遍历数组, 如果遇到比基准值小的数, 就将它填到左边的坑中
 * 然后再从左边开始遍历数组, 如果遇到比基准值大的数, 就将它填到右边的坑中
 * 反复这个动作, 直到左右两个遍历的变量相遇, 这个地方就是基准值应该在的地方, 这是一次快排
 * 然后分别递归快排基准值左边的值和基准值右边的值
 * User: HHH.Y
 * Date: 2020-08-11
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
        if(left >= right) {
            return;
        }
        int par = partition(arr, left, right);
        quick(arr, left, par - 1);
        quick(arr, par + 1, right);
    }

    private static int partition(int[] arr, int low, int high) {
        int tmp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[high] = tmp;
        return high;
    }
}
