/**
 * Created with IntelliJ IDEA.
 * Description: 变态青蛙跳台阶问题
 * 一只青蛙一次可以跳上 1 级台阶, 也可以跳上 2级台阶.... 也可以跳上 n 级台阶, 求该青蛙跳上一个 n 级台阶有多少种跳法
 *
 * f(1): [1]
 * f(2): [1,1]. [2]
 * f(3): [1,2], [1,1,1], [2,1], [3]
 * f(4): [1,3], [1,1,2], [2,2], [1,2,1], [1,1,1,1], [2,1,1], [3,1], [4]
 *
 * 可以看出: f(1) = 1, f(2) = 2, f(3) = 4, f(4) = 8;
 * 从 f(2) 开始往后, 都是上一个数的 2 倍
 * User: HHH.Y
 * Date: 2020-09-05
 */
public class Abnormal_Frog_Jumps_The_Step {
    public int JumpFloorII(int target) {
        // 使用动态规划求解
        if(target == 0) {
            return 0;
        }
        // 初始条件: f(1) = 1;
        int ret = 1;
        // 从 f(2) 开始, 都是上一个数的 2 倍
        for (int i = 2; i <= target; i++) {
            ret *= 2;
        }
        return ret;
    }
}
