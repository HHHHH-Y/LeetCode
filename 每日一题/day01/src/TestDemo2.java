import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: 给定一个整数数组, 使用快排的方式, 获取第 K 大的数
 * User: HHH.Y
 * Date: 2020-06-01
 */
public class TestDemo2 {
    public static int partition(int[] array, int left, int right) {
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

    public static void quick(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int par = partition(array, left, right);
        quick(array, left, par - 1);
        quick(array, par + 1, right);
    }

    public static void quickSort(int[] array) {
        quick(array, 0, array.length - 1);
    }

    public static int findKth(int[] a, int n, int K) {
        quickSort(a);
        int count = K - 1;
        int i = n -1;
        while (count != 0) {
            i--;
            count--;
        }
        return a[i];
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 2, 2};
        System.out.println(findKth(a, 5, 3));
    }
}
