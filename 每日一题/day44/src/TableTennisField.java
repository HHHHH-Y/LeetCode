import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 乒乓球框
 * nowcoder 有两盒 (A, B)乒乓球, 有红双喜的, 有亚里亚的 ...
 * 现在他需要判断 A盒是否包含了 B 盒中所有的种类, 并且每种球的数量不少于 B盒中的数量
 * User: HHH.Y
 * Date: 2020-07-22
 */
public class TableTennisField {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            String[] s = input.split(" ");
            if(output(s) == true) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean output(String[] s) {
        char[] b = s[1].toCharArray();
        // 将 A 中的元素全部放进  list 集合中
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s[0].length(); i++) {
            list.add(s[0].charAt(i));
        }
        // 1. 判断 A 中是否已经包含了 B 中的所有种类
        for (int i = 0; i < b.length; i++) {
            if(!list.contains(b[i])) {
                return false;
            }
        }
        // 判断是否每种球的数量都不少于 B 中的数量
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < b.length; i++) {
            if(map.get(b[i]) == null) {
                map.put(b[i], 1);
            } else {
                map.put(b[i], map.get(b[i]) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry:map.entrySet()) {
            int count = 0;
            Character key = entry.getKey();
            for (int i = 0; i < list.size(); i++) {
                if(key == list.get(i)) {
                    count++;
                }
            }
            if(count < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
