/**
 * Created with IntelliJ IDEA.
 * Description: 上楼梯
 * 有个小孩正在上楼梯, 楼梯有 n 阶台阶, 小孩一次可以上 1 阶, 2 阶, 3 阶.
 * 请实现一个方法, 计算小孩有多少种上楼的方式. 为了防止溢出, 请将结果 Mod 1000000007
 * 给定一个正整数 n, 请返回一个数, 代表上楼的方式数. 保证 n <= 100000
 * User: HHH.Y
 * Date: 2020-07-08
 */
public class GoUpStaire {
    // 相当于青蛙跳台阶问题
    // 但是使用递归会发生栈溢出的现象, 所以本题只能采用迭代的方式进行求解
    public static int countWays(int n) {
        int a = 1;
        int b = 2;
        int c = 4;
        if(n == 1) {
            return a;
        }
        if(n == 2) {
            return b;
        }
        if(n == 3) {
            return c;
        }
        int ret = 0;
        for (int i = 4; i <= n; i++) {
            ret = ((a + b) % 1000000007 + c) % 1000000007;
            a = b;
            b = c;
            c = ret;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(countWays(36196));
    }
}
