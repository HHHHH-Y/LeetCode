import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 最难的问题
 * 消息加密的办法是: 对消息原文中的每个字母, 分别用该字母之后的五个字母替换(例如: 消息原文中的每个字母A都分别替换成 F), 其他字符不变
 * 并且消息原文的所有字母都是大写的.密码中的字母与原文中的字母对应关系如下.
 * 密码字母: A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 * 原文字母: V M X Y Z A B C D E F G H I J K L M N O P Q R S T U
 *
 * 输入描述:
 * 输入包括多组数据, 每组数据一行, 为收到的密文
 * 密文仅有空格和大小写字母组成.
 *
 * 输出描述:
 * 对应每一组数据, 输出解密后的明文
 *
 * 思路:
 * 如果拿到的字符是处于 F 到 Z 之间, 直接让他们 -5 即可
 * 如果拿到的字符是处于 A 到 E 之间, 就让他们 +21 即可
 * User: HHH.Y
 * Date: 2020-06-24
 */
public class TheHardestQuestion {
    private static void encrypt(String input) {
        // 将字符串转换成字符数组的形式
        char[] chars = input.toCharArray();
        // 定义一个 stringBuffer 用于字符串的拼接
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < input.length(); i++) {
            // 拿到每一个字符
            char c = chars[i];
            if(c >= 'F' && c <= 'Z') {
                stringBuffer.append((char)(c - 5));
            } else if(c >= 'A' && c <= 'E') {
                stringBuffer.append((char)(c + 21));
            } else {
                stringBuffer.append(" ");
            }
        }
        System.out.println(stringBuffer.toString());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String inPut = scanner.nextLine(); // 收到的密文
            encrypt(inPut);
        }
    }
}
