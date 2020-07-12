import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 木棒拼图问题
 * 思路:
 * 1. 由于会有多组输入, 则一组一组的进行处理
 * 2. 每输入一组, 都会根据其前面的数字为 1 或者 0 进行判断
 *    如果前面的数字为 1, 则就将其对应的长度放入集合中, 并算入棍子总长中.
 *    如果前面的数字为 2, 则就将其对应的长度从集合中删除, 并从棍子的总长中减去.
 * 3. 将最终集合中的元素进行排序, 最后一个元素就是最大的木棍的长度.
 * 4. 只有最大木棍的长度小于其他所有木棍的长度时, 才可以组成一个简单多边形, 否则就不可以
 * User: HHH.Y
 * Date: 2020-07-12
 */
public class Stick_The_Puzzle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 操作的组数
        int sum = 0; // 所有棍子的总长度
        int max = 0; // 所有棍子中, 最长的那根棍子长度
        List<Integer> list = new ArrayList<>();

        while (scanner.hasNext()) {
            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                scanner.nextLine();
                if(x == 1) {
                    list.add(y); // 如果 x = 1, 就将其对应的长度加入到集合中.
                    sum += y; // 所有棍子的长度 + y;
                } else {
                    list.remove(list.indexOf(y)); // 如果 x = 2, 就 将其对应的长度从集合中取出
                    sum -= y; // 所有棍子的长度 - y;
                }

                Collections.sort(list);
                if(list.size() > 0) {
                    max = list.get(list.size() - 1);
                }
                if(max < sum - max) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }
}
