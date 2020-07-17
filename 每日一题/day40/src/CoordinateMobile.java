import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 坐标移动
 * 开发一个坐标计算工具. A 表示向左移动, D 表示向右移动, W 表示向上移动, S 表示向下移动.
 * 从 (0, 0) 点开始移动, 从输入字符串里面读取一些坐标, 并将最终输入结果输出文件里面.
 * 输入: 合法坐标为 A (或者 D 或者 W 或者 S) + 数字(两位以内), 坐标之间以 ; 分隔, 非法坐标点需要丢弃.
 *
 * 思路:
 * 首先按照 ; 将字符串进行划分, 分成了一个字符串数组
 * 如果字符串为空, 或者字符串长度 < 2, 或者字符串长度 > 3, 都应该属于无效的字符串
 * 如果长度为 2 的字符串中含有不属于 0 - 9 的数字, 也应该属于无效字符串
 * 然后根据后面的子串长度, 计算坐标.
 * User: HHH.Y
 * Date: 2020-07-17
 */
public class CoordinateMobile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            String[] split = input.split(";");
            mobile(split);
        }
    }

    private static void mobile(String[] split) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < split.length; i++) {
            if(split[i] == null || split[i].length() < 2 || split[i].length() > 3) {
                continue;
            }
            char[] chars = split[i].substring(1).toCharArray();
            int j = 0;
            for (; j < chars.length; j++) {
                if(chars[j] < '0' || chars[j] > '9') {
                    break;
                }
            }
            if(j != chars.length) {
                continue;
            }
            int num = Integer.parseInt(split[i].substring(1));
            if(split[i].charAt(0) == 'A') {
                x -= num;
            } else if(split[i].charAt(0) == 'D') {
                x += num;
            } else if(split[i].charAt(0) == 'W') {
                y += num;
            } else if(split[i].charAt(0) == 'S'){
                y -= num;
            }
        }
        System.out.println(x + "," + y);
    }
}
