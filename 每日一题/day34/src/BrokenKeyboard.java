import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: Broken Keyboard
 * 输入两行字符串, 分别为预期输出字符串和实际输出字符串, 通过这两行字符串, 判断出示哪些键坏了
 * 注意: 输出的坏键中, 凡是英文的全部以答谢的形式输出
 * User: HHH.Y
 * Date: 2020-07-09
 */
public class BrokenKeyboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String output = scanner.nextLine(); // 7_This_is_a_test
        String actOutput = scanner.nextLine(); // _hs_s_a_es

        JudgeBroken(output, actOutput);
    }

    private static void JudgeBroken(String output, String actOutput) {
        output = output.toUpperCase();
        actOutput = actOutput.toUpperCase();
        Set<Character> brokenSet = new HashSet<>();
        char[] chars = output.toCharArray();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < actOutput.length(); i++) {
            list.add(actOutput.charAt(i));
        }
        for (int i = 0; i < chars.length; i++) {
            if(!list.contains(chars[i]) && !brokenSet.contains(chars[i])) {
                System.out.print(chars[i]); // 加进 set 中就进行打印, 所以结果是有序的
                brokenSet.add(chars[i]);
            }
        }
    }
}
