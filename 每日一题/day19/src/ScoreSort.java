import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 成绩排序
 * 输入任意 (用户, 成绩) 序列, 可以获得成绩从高到低或从低到高的排序
 * 相同成绩都按照先录入排列在前的规则处理
 *
 * 输入描述:
 * 输入多行, 先输入要排序的人的个数, 然后输入排序方法 0 (降序) 或者 1 (升序)
 * 然后分别输入他们的名字和成绩, 以一个空格分开
 *
 * 输出描述:
 * 按照指定方式输出名字和成绩, 名字和成绩之间以一个空格分开
 *
 * 思路:
 * 1. 输入姓名和成绩, 将其放进一个 map 表中
 * 2. 创建一个 list 集合, 放入 map 对
 * 3. 根据不同的排序方式, 调用 Collections.sort() 构造一个比较器进行比较
 * 4. 打印
 * User: HHH.Y
 * Date: 2020-06-21
 */
public class ScoreSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int total = scanner.nextInt(); // 总人数
            int action = scanner.nextInt(); // 排序方式
            LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < total; i++) {
                String name = scanner.next();
                name = i + ":" + name; // 由于名字可能会重复, 所以前面加上一个序号
                int score = scanner.nextInt();
                map.put(name, score); // 将姓名和成绩放进哈希表中
            }
            LinkedList<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet()); // 将这个哈希表放入一个 list 集合中

            // 根据动作的不同, 对 list 进行排序
            if(action == 0) {
                // 从大到小
                // 调用 Collections.sort(), 根据指定比较器的顺序对指定的那个列表进行排序
                Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        return o2.getValue() - o1.getValue();
                    }
                });
            } else {
                // 从小到大
                Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        return o1.getValue() - o2.getValue();
                    }
                });
            }

            // 打印
            for (Map.Entry<String, Integer> entry:list) {
                String name = entry.getKey(); // i:name
                // String.indexof(String str): 返回 str 字符串的下标。
                // String.subString(int beginIndex): 从指定位置开始截取
                String trueName = name.substring(name.indexOf(":") + 1);
                System.out.println(trueName + " " + entry.getValue());
            }
        }
    }
}

