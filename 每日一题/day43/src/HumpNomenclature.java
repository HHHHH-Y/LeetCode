import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 驼峰命名法
 * 除首个单词以外, 所有单词的首字母大写
 * 输入描述:
 * 输入包含多组数据
 * 每组数据一行, 包含一个C语言风格的变量名. 每个变量名长度不超过 100
 * 输出描述:
 * 对应每一组数据, 输出变量名对应的驼峰命名法.
 * User: HHH.Y
 * Date: 2020-07-21
 */
public class HumpNomenclature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            String[] split = input.split("_");
            System.out.print(split[0]);
            for (int i = 1; i < split.length; i++) {
                String first = split[i].substring(0, 1).toUpperCase();
                String remainder = split[i].substring(1);
                System.out.print(first + remainder);
            }
            System.out.println();
        }
    }
}
