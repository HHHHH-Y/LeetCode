import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 字符串中找出连续最长的数字串
 * 读入一个字符串 str, 输出字符串 str 中的连续最长的数字串
 * <p>
 * User: HHH.Y
 * Date: 2020-08-03
 */
public class MaximumNumberString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        List<String> list = new ArrayList<>();
        char[] chars = str.toCharArray();
        int k = 0;
        for (int i = 0; i < chars.length; i++) {
            // i 指向了数字
            if (chars[i] >= '0' && chars[i] <= '9') {
                int j = i;
                for (; j < chars.length; j++) {
                    if (chars[j] < '0' || chars[j] > '9') {
                        k = j;
                        break;
                    }
                }
                if(j == chars.length) {
                    String subString = str.substring(i);
                    list.add(subString);
                } else {
                    String substring = str.substring(i, k);
                    list.add(substring);
                    i = k - 1;
                }
            }
        }
        int max = list.get(0).length();
        int index = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).length() > max) {
                max = list.get(i).length();
                index = i;
            }
        }
        System.out.println(list.get(index));
    }
}
