
/**
 * Created with IntelliJ IDEA.
 * Description: 问题描述
 * 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。
 * 给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
 *
 * 思路： 如果是 1 * 1 的网格，就只有一种走法
 *       如果是 1 * 2 或 2 * 1 的网格，也只有一种走法
 *       如果是 2 * 2 的网格，如果先向右走一步，就是 2 * 1 的情况，如果向下走一步，就是 1 * 2 的情况
 *       因此，2 * 2 的网格，就等于 2 * 1 的值 + 1 * 2 的值
 * User: HHH.Y
 * Date: 2020-06-11
 */
public class Robot {
    public int countWays(int x, int y) {
        if(x == 1 || y == 1) {
            return 1;
        }
        return countWays(x - 1, y) + countWays(x, y - 1);
    }
}
