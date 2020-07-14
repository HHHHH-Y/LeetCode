import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 空格替换
 * 请编写一个方法, 将字符串中的空格全部替换为 "%20".
 * 假定该字符串有足够的空间存放新增字符串, 并且知道字符串的真实长度 (小于等于 1000), 同时保证字符串由大小写的英文字母组成
 * 给定一个 string iniString 为原始的串, 以及串的长度 int len, 返回替换后的 string
 *
 * 测试:
 * "Mr John Smith", 13
 * 返回: "Mr%20John%20Smith"
 * "Hello  World", 12
 * 返回: "Hello%20%20World"
 * User: HHH.Y
 * Date: 2020-07-14
 */
public class SpacesReplaced {
    public static String replaceSpace(String iniString, int length) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] chars = iniString.toCharArray();
        for (int i = 0; i < length; i++) {
            if(chars[i] != ' ') {
                stringBuffer.append(chars[i]);
            } else {
                stringBuffer.append("%20");
            }
        }
        String res = stringBuffer.toString();
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int len = scanner.nextInt();
        System.out.println(replaceSpace(str, len));
    }
}
