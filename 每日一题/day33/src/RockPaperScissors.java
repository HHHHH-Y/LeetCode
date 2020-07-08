import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 石头剪刀布
 * 现在给出两人的交锋记录, 请统计双方的胜, 平, 负次数, 并且给出双方分别出什么手势的胜算最大
 *
 * 输入描述:
 * 输入第 1 行给出正整数 N( <= 105), 即双方交锋的次数, 随后的 N 行, 每行给出交锋的信息, 即甲乙双方同时给出的手势.
 * "C" 代表锤子, "J" 代表剪刀, "B" 代表布, 第 1 个字母代表甲方, 第 2 个代表乙方, 中间有一个空格
 *
 * 输出描述:
 * 输出的第一, 二行分别代表甲乙双方的胜, 平, 负的次数. 第三行给出两个字母, 分别表示甲, 乙 双方获胜次数最多的手势, 中间有一个空格
 * 如果解不唯一, 则输出按照字母序最小的解
 *
 * C > J, B > C, J > B
 * C > J > B, B > C
 * User: HHH.Y
 * Date: 2020-07-08
 */
public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            Map<String, Integer> mapA = new HashMap<>();
            Map<String, Integer> mapB = new HashMap<>();
            int n = scanner.nextInt(); // 交锋的次数
            int winA = 0;
            int drawA = 0;
            int failA = 0;
            int winB = 0;
            int drawB = 0;
            int failB = 0;
            scanner.nextLine(); // 用于接收回车
            for (int i = 0; i < n; i++) {
                String input = scanner.nextLine();
                String[] s = input.split(" ");
                String A = s[0];
                String B = s[1];
                if(isWin(A, B) == 1) {
                    winA++;
                    failB++;
                    if(mapA.get(A) == null) {
                        mapA.put(A, 1);
                    } else {
                        mapA.put(A, mapA.get(A) + 1);
                    }
                } else if(isWin(A, B) == -1) {
                    failA++;
                    winB++;
                    if(mapB.get(B) == null) {
                        mapB.put(B, 1);
                    } else {
                        mapB.put(B, mapB.get(B) + 1);
                    }
                } else {
                    drawA++;
                    drawB++;
                }
            }
            System.out.print(winA + " " + drawA + " " + failA);
            System.out.println();
            System.out.print(winB + " " + drawB + " " + failB);
            System.out.println();
            // 寻找最大的 value 值对应的 key 值
            findMaxValueCorrespondingKey(mapA);
            System.out.print(" ");
            findMaxValueCorrespondingKey(mapB);
        }
    }

    private static void findMaxValueCorrespondingKey(Map<String, Integer> map) {
        // 先找到最大的 value 值
        int maxValue = findMaxValue(map);
        String key = null;
        // 根据最大的 value 值寻找对应的 key 值
        for (Map.Entry<String, Integer> entry:map.entrySet()) {
            if(maxValue == entry.getValue()) {
                key = entry.getKey();
                break;
            }
        }
        if(key == null) {
            System.out.print("B");
        } else {
            System.out.print(key);
        }
    }

    private static int findMaxValue(Map<String, Integer> map) {
        if(map.size() == 0) {
            return 0;
        }
        // 使用 map.values() 方法, 可以获得 map 集合中的所以 value 集合
        Collection<Integer> collection = map.values();
        // collection.toArray() 方法是将集合转换成数组的形式
        Object[] objects = collection.toArray();
        Arrays.sort(objects);
        return (int)objects[objects.length - 1];
    }

    private static int isWin(String a, String b) {
        if(a.equals(b)) {
            return 0;
        }
        if(a.equals("C") && b.equals("J") || a.equals("J") && b.equals("B") || a.equals("B") && b.equals("C")) {
            return 1;
        }
        return -1;
    }
}
