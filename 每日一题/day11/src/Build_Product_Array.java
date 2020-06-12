import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: 构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 *
 * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 *
 * 思路: 先计算 i 之前的元素积, 然后再计算 i 之后的元素积, 然后和前面的元素积相乘
 * 以数组大小为 5 举例:
 * 计算 i 之前的元素积
 * b[0] = 1;
 * b[1] = b[0] * a[0] = a[0];
 * b[2] = b[1] * a[1] = a[0] * a[1];
 * b[3] = b[2] * a[2] = a[0] * a[1] * a[2];
 * b[4] = b[3] * a[3] = a[0] * a[1] * a[2] * a[3];
 *
 * 计算 i 之后的元素积, 然后和前面的元素积相乘
 * int tmp = 1;
 * tmp * a[4] = a[4];
 * b[3] = b[3] * tmp = a[0] * a[1] * a[2] * a[4];
 *
 * tmp * a[3]  = a[3] * a[4];
 * b[2] = b[2] * tmp = a[0] * a[1]  * a[3] * a[4];
 *
 * tmp * a[2] = a[2] * a[3] * a[4];
 * b[1] = b[1] * tmp = a[0] * a[2] * a[3] * a[4];
 *
 * tmp * a[1] = a[1] * a[2] * a[3] * a[4];
 * b[0] = b[0] * tmp = a[1] * a[2] * a[3] * a[4];
 * User: HHH.Y
 * Date: 2020-06-12
 */
public class Build_Product_Array {
    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if(length != 0) {
            // 先计算 i 左边的值
            B[0] = 1;
            for (int i = 1; i < length; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }
            // 计算 i 右边的值 并与对应左边的值相乘, 就可以得到相应的 B[i]
            int tmp = 1;
            for (int i = length - 2; i >= 0; i--) {
                tmp *= A[i + 1];
                B[i] *= tmp;
            }
        }
        return B;
    }
}
