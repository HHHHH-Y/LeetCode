import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 字符串加解密
 * 对输入的字符串进行加解密, 并输出.
 * 加密方法为:
 * 当内容是英文字母时则用该英文字母的后一个字母进行替换, 同时字母变换大小写.
 * 如: 字母 a 时则替换字母 B, 字母 Z 时则替换字母 a;
 * 当内容是数字时则把数字加一, 如: 0 替换成 1, 1 替换成 2, 9 替换成 0
 * 其他字符不做变化
 * 3. 解密方法为加密的逆过程
 *
 * 输入描述:
 * 输入说明 输入一串要加密的密码, 输入一串加过密的密码
 * 输出描述:
 * 输出说明 输出加密后的字符, 输出解密后的字符
 * User: HHH.Y
 * Date: 2020-07-18
 */
public class StringEncryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String unencrypted = scanner.nextLine();
            String encrypted = scanner.nextLine();
            System.out.println(encryptionProcess(unencrypted));
            System.out.println(decryptionProcess(encrypted));
        }
    }

    private static String decryptionProcess(String encrypted) {
        char[] chars = encrypted.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] >= '1' && chars[i] <= '9') {
                char c1 = (char) (chars[i] - 1);
                stringBuffer.append(c1);
            } else if(chars[i] == '0') {
                stringBuffer.append('9');
            } else if(chars[i] >= 'b' && chars[i] <= 'z') {
                char c2 = (char) (chars[i] - 33);
                stringBuffer.append(c2);
            } else if(chars[i] == 'a') {
                stringBuffer.append('Z');
            } else if(chars[i] >= 'B' && chars[i] <= 'Z') {
                char c3 = (char) (chars[i] + 31);
                stringBuffer.append(c3);
            } else if(chars[i] == 'A') {
                stringBuffer.append('z');
            }
        }
        return stringBuffer.toString();
    }

    private static String encryptionProcess(String unencrypted) {
        char[] chars = unencrypted.toCharArray();
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            // 如果是数字, 就将数字加一
            if(chars[i] >= '0' && chars[i] < '9') {
                char c1 = (char) (chars[i] + 1);
                s.append(c1);
            } else if(chars[i] == '9') {
                s.append('0');
            } else if(chars[i] >= 'a' && chars[i] < 'z') {
                char c2 = (char) (chars[i] - 31);
                s.append(c2);
            } else if(chars[i] == 'z') {
                s.append('A');
            } else if(chars[i] >= 'A' && chars[i] < 'Z') {
                char c3 = (char) (chars[i] + 33);
                s.append(c3);
            } else if(chars[i] == 'Z') {
                s.append('a');
            }
        }
        return s.toString();
    }
}
