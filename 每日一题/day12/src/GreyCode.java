/**
 * Created with IntelliJ IDEA.
 * Description: 生成格雷码

 * 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同， 则称这种编码为格雷码(Gray Code)
 * 请编写一个函数，使用递归的方法生成 N 位的格雷码。
 * 给定一个整数n，请返回n位的格雷码，顺序为从0开始。
 *
 * 测试样例：
 * 1
 * 返回：["0","1"]
 *
 * 思路：
 * n 位的格雷码是由 n-1 位的格雷码高位补 0 或 1 得到的。
 * 例如： n = 1 的格雷码为 {"0", "1"};
 *       n = 2 的格雷码就是在 n = 1 的格雷码的高位补 0 或 1
 *       添加 0 后，就变成了 {"00",  "01"};
 *       添加 1 后，就变成了 {"10", "11"};
 *       但是在拼接的时候，需要将添加了 1 之后的元素顺序进行反向，才可以生成有效的格雷码
 *       即：{"00", "01", "11", "10"};
 * User: HHH.Y
 * Date: 2020-06-13
 */
public class GreyCode {
    public String[] getGray(int n) {
        // 定义一个需要返回的数组
        String[] ret = null;
        // 递归结束的条件
        if(n == 1) {
            ret = new String[] {"0", "1"};
        } else {
            String[] retStr = getGray(n - 1); // 拿到前 n - 1 位的格雷码
            // n 位的格雷码数是n - 1 位格雷码数的两倍
            ret = new String[2 * retStr.length];
            // 遍历 n - 1 位的格雷码，对其高位进行加“0” 和 “1”的操作
            for (int i = 0; i < retStr.length; i++) {
                // 前半部分二进制码添加 “0”
                ret[i] = "0" + retStr[i];
                // 反向添加 “1”，后半部分二进制码添加“1”
                ret[ret.length - 1 - i] = "1" + retStr[i];
            }
        }
        return ret;
    }
}
