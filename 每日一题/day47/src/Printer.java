/**
 * Created with IntelliJ IDEA.
 * Description: 顺时针打印矩阵
 * 对于一个矩阵, 请设计一个算法从左上角(mat[0][0])开始, 顺时针打印矩阵元素
 * 给定 int 矩阵 mat, 以及它的维数 n x m, 请返回一个数组, 数组中的元素为矩阵元素的顺时针输出
 *
 * 思路: 所谓的顺时针打印, 就是从外向内的顺时针打印
 * 先打印大矩形, 再打印小矩形, 按照顺时针的方向
 * User: HHH.Y
 * Date: 2020-07-26
 */
public class Printer {
    public int[] clockwisePrint(int[][] mat, int n, int m) {
        int startX = 0;
        int endX = m - 1;
        int startY = 0;
        int endY = n - 1;
        int index = 0;
        int[] ret = new int[n * m];

        while (startX <= endX && startY <= endY) {

            // 从左向右打印
            if(startX <= endX) {
                for (int i = startX; i <= endX; i++) {
                    ret[index++] = mat[startY][i];
                }
            }

            // 从上向下打印
            if(startY < endY) {
                for (int i = startY + 1; i <= endY; i++) {
                    ret[index++] = mat[i][endX];
                }
            }

            // 从右向左打印
            if(startY < endY && endX > startX) {
                for (int i = endX - 1; i >= startX; i--) {
                    ret[index++] = mat[endY][i];
                }
            }

            // 从下向上打印
            if(startY < endY && endX > startX) {
                for (int i = endY - 1; i >= startY + 1; i--) {
                    ret[index++] = mat[i][startX];
                }
            }

            startX++;
            endX--;
            startY++;
            endY--;
        }
        return ret;
    }
}
