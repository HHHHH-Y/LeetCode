/**
 * Created with IntelliJ IDEA.
 * Description: 取出每一位的数字挨个相加，不够位数补0
 *
 * 将数字字符转换成数字的方法:
 * 例如: '3' -> 3   只需要通过 '3' - '0' 就可得到
 * User: HHH.Y
 * Date: 2020-06-08
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuffer stringBuffer = new StringBuffer(""); // 用于拼接字符串
        int i = num1.length() - 1; // i 表示的是字符串 num1 的最后一位
        int j = num2.length() - 1; // j 表示的是字符串 num2 的最后一位
        int carry = 0; // carry 表示的是进位值
        while (i >= 0 || j >= 0) {
            int n1 = (i >= 0 ? num1.charAt(i) - '0' : 0); // 如果 i < 0, 就补0, 否则将所有的字符通过charAt(i) - '0'的方式转换成数字的形式
            int n2 = (j >= 0 ? num2.charAt(j) - '0' : 0);
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            stringBuffer.append(tmp % 10 );
            i--;
            j--;
        }
        // num1 和 num2 全部都遍历完成
        if(carry == 1) {
            stringBuffer.append("1");
        }
        return stringBuffer.reverse().toString();
    }
}
