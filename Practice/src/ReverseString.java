import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 字符串逆序
 * 输入: I am a student
 * 输出: tneduts a ma I
 * User: HHH.Y
 * Date: 2020-09-04
 */
public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            String output = reverseString(input);
            System.out.println(output);
        }
    }

    private static String reverseString(String input) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < input.length(); i++) {
            stringBuffer.append(input.charAt(i));
        }
        return stringBuffer.reverse().toString();
    }
}
