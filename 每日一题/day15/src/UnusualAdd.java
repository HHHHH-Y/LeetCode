/**
 * Created with IntelliJ IDEA.
 * Description: 另类加法
 * 请编写一个函数, 将两个数字相加, 不得使用 + 或者其他算术运算符
 * 给定两个 int A 和 B. 请返回 A + B 的值
 * User: HHH.Y
 * Date: 2020-06-17
 */
public class UnusualAdd {
    public static int addAB(int A, int B) {
        while (B != 0) {
            int ret = A ^ B;
            B = (A & B) << 1;
            A = ret;
        }
        return A;
    }

    public static void main(String[] args) {
        int A = 1;
        int B = 2;
        System.out.println(addAB(A, B));
    }
}
