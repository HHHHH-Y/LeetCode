
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
 * 然后从后向前遍历并放入到 StringBuffer 中
 * 最后的结果去掉两边的空格即可
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
        StringBuffer stringBuffer = new StringBuffer();
        // 通过正则表达式, 以非字符串进行分割
        String[] split = words.split("[^a-zA-Z]+");
        for (int i = split.length - 1; i >= 0 ; i--) {
            stringBuffer.append(split[i] + " ");
        }
        System.out.println(stringBuffer.toString().trim());
    }
}
