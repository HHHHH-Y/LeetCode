import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 简单错误记录
 * 开发一个简单错误记录功能小模块, 能够记录出错的代码所在文件名称和行号
 * 处理:
 * 1. 记录最多 8 条错误记录, 循环记录, 对相同的错误记录 (净文件名称和行号完全匹配) 只记录一条, 错误计数增加;
 * 2. 超过 16 个字符的文件名称, 只记录文件的最后有效 16 个字符
 * 3. 输入的文件可能带路径, 记录文件名称不能带路径
 *
 * 输入描述:
 * 一行或多行字符串, 每行包括带路径文件名称, 行号, 以空格隔开
 * 输出描述:
 * 将所有的记录统计并将结果输出, 格式: 文件名 代码行数 数目, 一个空格隔开
 *
 * 输入:
 * E:\V1R2\product\fpgadrive.c    1325
 * 输出:fpgadrive.c 1325 1
 *
 * User: HHH.Y
 * Date: 2020-07-23
 */
public class SimpleErrorRecord {
    public static void main(String[] args) {
        // 只需要记录净文件名称和行号即可
        Map<String, Integer> map = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String path = scanner.nextLine();
            String[] split = path.split("\\s+");
            int lineNum = Integer.parseInt(split[1]);
            String[] split1 = split[0].split("\\\\");
            String filename = split1[split1.length - 1]; // 净文件名称
            if(filename.length() > 16) {
                filename = filename.substring(filename.length() - 16);
            }
            String s = filename + " " + lineNum; // 表示净文件名和行号

            // 每输入一个路径, 就往 map 中存放一个
            int value = 1;
            // 查看 map 中是否包括 filename 这一个 key
            if(map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, value);
            }
        }
        // 只用输出最后 8 条记录即可
        int count = 0;
        for (String string : map.keySet()) {
            count++;
            if(count > (map.keySet().size() - 8)) {
                System.out.println(string + " " + map.get(string));
            }
        }
    }
}
