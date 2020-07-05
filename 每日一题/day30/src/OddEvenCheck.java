import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 奇偶校验
 * 输入一个字符串, 然后对每个字符进行奇校验, 最后输出校验后的二进制数(如: '3', 输出: 10110011)
 * 输入描述:
 * 输入包括一个字符串, 字符串长度不超过100
 * 输出描述:
 * 可能有多组测试数据, 对于每组数据
 * 对于字符串中的每个字符, 输出按题目进行奇偶校验后的数, 每个字符校验的结果占一行
 *
 * 什么是奇校验: 查看被传输的二进制码中 '1' 的个数
 *              如果 1 的个数是奇数, 说明验证成功
 *              如果 1 的个数是偶数, 就需要在高位补 1, 才可以验证成功
 * User: HHH.Y
 * Date: 2020-07-05
 */
public class OddEvenCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            oddEvenCheck(input);
        }
    }

    private static void oddEvenCheck(String input) {
        char[] chars = input.toCharArray();
        for (char c:chars) {
            // 1. 将每一个字符都转换成二进制
            String s1 = Integer.toBinaryString(c);
            // 2. 二进制不够8位的, 前面补 0
            if(s1.length() < 8) {
                int lack = 8 - s1.length();
                for (int i = 0; i < lack; i++) {
                    s1 = "0" + s1;
                }
            }
            // 3. 截取二进制数的后 7 位
            String s2 = s1.substring(1);
            int count = 0;
            for (int i = 0; i < s2.length(); i++) {
                if(s2.charAt(i) == '1') {
                    count++;
                }
            }
            // 如果后 7 位中已经有奇数个 1, 就直接在前面补 0
            // 如果后 7 为中只偶数个 1, 就在前面补 1
            System.out.println(count % 2 == 0 ? "1" + s2 : "0" + s2);

        }
    }
}
