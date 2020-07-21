
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 单词倒排
 * 对字符串中的所有单词进行倒排
 * 说明:
 * 非构成单词的字符均视为单词间隔符
 * 如果原字符串中相邻单词间有多个间隔符时, 倒排转换后也只允许出现一个空格间隔符
 *
 * 思路: 首先将原字符串通过非字母(正则表达式)进行划分
 * 然后从后向前遍历打印
 * 如果字符串数组中下标为 0 的元素时空串, 则从小标为 0 的元素结束, 否则, 就要输出下标为 1 的元素和下标为 0 的元素
 * User: HHH.Y
 * Date: 2020-07-21
 */
public class InvertedOrderOfWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String words = scanner.nextLine();
            outputWords(words);
        }
    }

    private static void outputWords(String words) {
        // 通过正则表达式, 以非字符串进行分割
        String[] split = words.split("[^a-zA-Z]+");
        for (int i = split.length - 1; i >= 2 ; i--) {
            System.out.print(split[i] + " ");
        }
        if(split[0].length() == 0) {
            System.out.print(split[1]);
        } else {
            System.out.print(split[1] + " " + split[0]);
        }
    }
}
