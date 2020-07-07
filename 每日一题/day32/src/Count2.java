/**
 * Created with IntelliJ IDEA.
 * Description: 2 的个数
 * 给定一个正整数 n, 请返回 0 到 n(包括 n)的数字中, 2 出现了几次
 * 思路:
 * (flag 为当前位数)
 * 1. 如果当前位 < 2, 此时 2 的个数 = 高位 * flag
 * 2. 如果当前位 = 2, 此时 2 的个数 = 高位 * flag + 低位 + 1
 * 3. 如果当前位 > 2, 此时 2 的个数 = (高位 + 1) * flag
 * User: HHH.Y
 * Date: 2020-07-06
 */
public class Count2 {
    public int countNumberOf2s(int n) {
        int count = 0;
        int low = 0; // 低位
        int current = 0; // 当前位
        int high = 0; // 高位
        int flag = 1; // flag 表示当前位的位数
        while (n / flag != 0) {
            low = n - (n / flag) * flag; // 计算低位
            current = (n / flag) % 10; // 计算当前位
            high = (n / flag) / 10;
            if(current == 0 || current == 1) {
                count += high * flag;
            } else if(current == 2) {
                count += high * flag + low + 1;
            } else {
                count += (high + 1) * flag;
            }
            flag *= 10;
        }
        return count;
    }
}
