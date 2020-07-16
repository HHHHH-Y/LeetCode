import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 删除公共字符
 * 输入两个字符串, 从第一个字符串中删除第二个字符串中所有的字符.
 * 例如: 输入"They are students". 和 "aeiou", 则删除之后的第一个字符串变成 "Thy r stdnts"
 * 输入描述:
 * 每个测试输入包含 2 个字符串
 * 输出描述:
 * 输出删除后的字符串
 * User: HHH.Y
 * Date: 2020-07-16
 */
public class RemoveCommonCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine(); // They are students.
            String str = scanner.nextLine(); // aeiou
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < str.length(); i++) {
                set.add(str.charAt(i));
            }
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < input.length(); i++) {
                list.add(input.charAt(i));
            }
            for (int i = 0; i < list.size(); i++) {
                if(set.contains(list.get(i))) {
                    list.remove(i--);
                }
            }
            for (char c:list) {
                System.out.print(c);
            }
        }
    }
}
