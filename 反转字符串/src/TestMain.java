import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HHH.Y
 * Date: 2020-05-16
 */
public class TestMain {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String str = "hello";
        char[] s = str.toCharArray();
        solution.reverseString(s);
    }
}
