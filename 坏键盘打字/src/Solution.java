import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 坏键盘打字
 * 输入两行字符串, 分别为预期输出字符串, 实际输出字符串, 通过这两行字符串, 判断出是那些键坏了
 * 注意: 输出的坏键中, 凡是英文的全部以大写形式输出
 * User: HHH.Y
 * Date: 2020-05-29
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String excepted = scanner.nextLine(); // 7_This_is_a_test
        String actual = scanner.nextLine(); // _hs_s_a_es

        List<Character> list = new ArrayList<>();
        for (char act:actual.toUpperCase().toCharArray()) {
            list.add(act);
        }

        Set<Character> set = new HashSet<>();
        for (char ex:excepted.toUpperCase().toCharArray()) {
            if(!list.contains(ex) && !set.contains(ex)) {
                System.out.print(ex);
                set.add(ex);
            }
        }
    }
}
