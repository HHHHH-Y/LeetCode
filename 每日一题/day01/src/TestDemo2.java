import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: 给定一个整数数组, 使用快排的方式, 获取第 K 大的数
 * 每排一次, 查看当前基准值的位置是否就为k,若是就直接返回
 * 若基准值位置 > k, 去左边继续找
 * 若基准值位置 < k, 去右边继续找
 *
 * 这样进行寻找, 每排序一次, 就可以去掉一半的元素, 提高时间复杂度
 * User: HHH.Y
 * Date: 2020-06-01
 */
public class TestDemo2 {
    public int findKth(int[] a, int n, int K) {
        return findkth(a, 0, a.length - 1, K);
    }
    public int findkth(int[] array, int left, int right, int k) {
        // 先进行一次快排, 按照从大到小的顺序进行排列
        int par = partition(array, left, right); // par 左边的元素均大于 array[par], par 右边的元素均小于 array[par]
        // 1.  如果排好之后, par刚好就是第K个元素, 直接返回par即可
        if (par - left + 1 == k) {
            return array[par];
        }
        // 2. 如果排好之后, par所在位置 < k, 说明应该去par的右边找
        if (par - left + 1 < k) {
            return findkth(array, par + 1, right, k - par + left - 1);
        }
        // 3. 如果排好之后, par所在位置 > k, 说明应该去par的左边找
        return findkth(array, left, par - 1, k);
    }
    public int partition(int[] array, int left, int right) {
        int tmp = array[left];
        // 按照从大到小进行快排
        while (left < right) {
            while (left < right && array[right] <= tmp) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] >= tmp) {
                left++;
            }
            array[right] = array[left];
        }
        array[right] = tmp;
        return right;
    }
}
