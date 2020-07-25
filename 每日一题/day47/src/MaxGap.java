import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: 左右最值最大差
 * 给定一个长度为 N (N > 1) 的整型数组 A, 可以将 A 划分为左右两个部分, 左部分 A[0...k], 右部分 A[k + 1...n - 1]
 * k 可以的取值范围是 [0, n - 2].
 * 求这么多划分方案中, 左部分中的最大值减去右部分最大值的绝对值, 最大是多少?
 * 给定整数数组 A 和数组的大小 n, 请返回题目所求的答案.
 * User: HHH.Y
 * Date: 2020-07-25
 */
public class MaxGap {
    public int findMaxGap(int[] A, int n) {
        int max = 0;
        List<Integer> listLeft = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(A[i]);
        }
        for (int i = 0; i <= n - 2; i++) {
            listLeft.add(A[i]);
            int leftMax = findMax(listLeft);
            list.remove(0);
            int rightMax = findMax(list);
            int tmp = Math.abs(leftMax - rightMax);
            if(tmp > max) {
                max = tmp;
            }
        }
        return max;
    }

    private int findMax(List<Integer> list) {
        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }
}
