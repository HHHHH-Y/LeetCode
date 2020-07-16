import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 句子逆序
 * User: HHH.Y
 * Date: 2020-07-16
 */
public class ReverseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String words = scanner.nextLine();
        String tmp = reverse(words);
        StringBuffer stringBuffer = new StringBuffer();
        String[] split = tmp.split(" ");
        for (String s:split) {
            stringBuffer.append(reverse(s)).append(" ");
        }
        System.out.println(stringBuffer.toString());
    }

    private static String reverse(String words) {
        char[] chars = words.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
        String ret = String.valueOf(chars);
        return ret;
    }
}
