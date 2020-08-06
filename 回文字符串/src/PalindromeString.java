import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 回文字符串
 * 给出一个长度不超过 1000 的字符串, 判断它是不是回文(顺读, 逆读都相同)的
 * 输入: 输入包括一行字符串, 其长度不超过 1000
 * 输出: 可能有多组测试数据, 对于每组数据, 如果是回文串则输出"Yes!", 否则输出"No!"
 *
 * 输入: hellolleh    helloworld
 * 输出: Yes!         No!
 * User: HHH.Y
 * Date: 2020-08-06
 */
public class PalindromeString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            char[] chars = str.toCharArray();
            int i = 0;
            int j = chars.length - 1;
            while (i != j && i + 1 != j) {
                if(chars[i] != chars[j]) {
                    break;
                }
                i++;
                j--;
            }
            if(i != j && i + 1 != j) {
                System.out.println("No!");
            } else {
                System.out.println("Yes!");
            }
        }
    }
}
