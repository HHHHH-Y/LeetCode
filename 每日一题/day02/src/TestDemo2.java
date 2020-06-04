/**
 * Created with IntelliJ IDEA.
 * Description: 问题描述
 * 有一组数, 对于其中任意两个数字, 若前面一个大于后面一个数字, 则这两个数字组成一个逆序对
 * 请设计一个高效的算法, 计算给定数组中的逆序对个数
 *
 * 给定一个 int数组 A 和它的大小 n, 请返回 A 中的逆序对个数, 保证 n 小于等于 5000
 * User: HHH.Y
 * Date: 2020-06-02
 */
public class TestDemo2 {
    // 暴力解法
    public static int count1(int[] A, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(A[i] > A[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // 分治解法: 使用归并的方式
    public static int count(int[] A, int n) {
        if (A == null || n == 0) {
            return 0;
        }
        return mergeSortRecurtion(A, 0, n - 1);
    }
    public static int mergeSortRecurtion(int[] A, int left, int right) {
        if(left == right) {
            return 0;
        }
        int mid = (left + right) >>> 1;
        // 逆序对的总数 = 左边数组的逆序对数量 + 右边数组的逆序对数量 + 左右结合的新的顺序数组时逆序对的数量
        return mergeSortRecurtion(A, left, mid) + mergeSortRecurtion(A, mid + 1, right) + merge(A, left, mid, right);
    }
    public static int merge(int[] A, int left, int mid, int right) {
        int s1 = left;
        int s2 = mid + 1;
        int[] tmp = new int[right - left + 1];
        int index = 0;
        int reverseNum = 0;
        while (s1 <= mid && s2 <= right) {
            if(A[s1] <= A[s2]) {
                tmp[index++] = A[s1++];
            } else {
                reverseNum += (mid - left + 1);
                tmp[index++] = A[s2++];
            }
        }
        while (s1 <= mid) {
            tmp[index++] = A[s1++];
        }
        while (s2 <= right) {
            tmp[index++] = A[s2++];
        }
        for (int i = 0; i < tmp.length; i++) {
            A[left++] = tmp[i];
        }
        return reverseNum;
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 0};
        int n = 8;
        System.out.println(count(A, n));
    }
}
