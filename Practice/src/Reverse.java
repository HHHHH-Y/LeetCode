/**
 * Created with IntelliJ IDEA.
 * Description: 将 hello world 变成 world hello
 * User: HHH.Y
 * Date: 2020-09-08
 */
public class Reverse {
    public static void main(String[] args) {
        String input = "hello world";
        String output = rev(input);
        System.out.println(output);
    }

    private static String rev(String input) {
        String[] str = input.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = str.length - 1; i >= 0; i--) {
            stringBuffer.append(str[i] + " ");
        }
        return stringBuffer.toString();
    }
}
