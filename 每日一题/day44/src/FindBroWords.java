
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 查找兄弟单词
 * 输入描述: 先输入字典中单词的个数 n, 再输入 n 个单词作为字典单词
 * 输入一个单词, 查找其在字典中兄弟单词的个数 m,
 * 再输入数字 k
 *
 * 输出描述:
 * 根据输入, 输出查找到的兄弟单词的个数 m
 * 然后输出查找到的兄弟单词的第 k 个单词
 * User: HHH.Y
 * Date: 2020-07-22
 */
public class FindBroWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt(); // 字典中单词的个数
            String[] words = new String[n];
            for (int i = 0; i < n; i++) {
                words[i] = scanner.next();
            }
            String inputWord = scanner.next(); // 要查找兄弟单词的单词
            int k = scanner.nextInt(); // 要输出兄弟单词中的第几个单词

            int count = 0; // 兄弟单词的个数
            List<String> list = new ArrayList<>();
            // 遍历整个单词数组
            for (int i = 0; i < n; i++) {
                // 如果是兄弟单词, 就放进集合中
                if(isBroWord(words[i], inputWord)) {
                    count++;
                    list.add(words[i]);
                }
            }
            System.out.println(count); // 打印兄弟单词的个数
            if(count >= k) {
                Collections.sort(list);
                System.out.println(list.get(k - 1));
            }
        }
    }

    private static boolean isBroWord(String word, String inputWord) {
        if(word.equals(inputWord) || word.length() != inputWord.length()) {
            return false;
        }
        // 分别将两个单词重新排序, 再进行比较, 如果相等, 说明 inputWord 是兄弟单词, 否则不是
        char[] chars1 = word.toCharArray();
        char[] chars2 = inputWord.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        if(!String.valueOf(chars1).equals(String.valueOf(chars2))) {
            return false;
        }
        return true;
    }
}
