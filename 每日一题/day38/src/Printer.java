/**
 * Created with IntelliJ IDEA.
 * Description: 二维数组的打印
 * 有一个二维数组(n * n), 写程序实现从右上角到左下角沿主对角线方向打印.
 * 给定一个二维数组 arr 及题目中的参数 n, 请 返回结果数组
 * User: HHH.Y
 * Date: 2020-07-15
 */
public class Printer {
    public int[] arrayPrint(int[][] arr, int n) {
        int[] out = new int[n * n];
        // 打印上三角包括中间 00 - nn 的对角线
        int index = 0;
        for (int j = n - 1; j >= 0; j--) {
            int k = j;
            for (int i = 0; i < n - j; i++) {
                out[index++] = arr[i][k++];
            }
        }
        // 打印剩下的下三角
        for (int i = 1; i < n; i++) {
            int k = i;
            for (int j = 0; j < n - i; j++) {
                out[index++] = arr[k++][j];
            }
        }
        return out;
    }
}
