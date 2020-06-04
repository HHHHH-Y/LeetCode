import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 问题描述: 删除公共字符
 * 输入两个字符串, 从第一个字符串中删除第二个字符串中所有字符
 * 输入: They are students. 和 aeiou, 则删除之后第一个字符串变成: Thy r stdnts.
 * User: HHH.Y
 * Date: 2020-06-04
 */
public class TestDemo2 {
    public static void deleteSame(String str, String s) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        StringBuffer res= new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if(!list.contains(str.charAt(i))) {
                res.append(str.charAt(i));
            }
        }
        String showString = res.toString();
        System.out.println(showString);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String s = scanner.nextLine();
        deleteSame(str, s);
    }
}
