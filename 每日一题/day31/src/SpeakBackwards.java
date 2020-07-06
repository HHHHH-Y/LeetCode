
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 说反话
 * 给定一句英语, 要求你编写程序, 将句中所有的单词颠倒输出
 * 输入描述:
 * 测试输入包含一个测试用例, 在一行内给出总长度不超过 80 的字符串.
 * 字符串由若干单词和若干空格组成
 * 其中单词是由英文字母(大小写有区分)组成的字符串, 单词之间用 1 个空格分开, 输入保证句子末尾没有多余的空格
 *
 * 输出描述:
 * 每个测试用例的数据占一行, 输出倒序后的句子
 *
 * 思路: 先整体逆序, 再进行局部的逆序
 * User: HHH.Y
 * Date: 2020-07-06
 */
public class SpeakBackwards {
    private static void invertedOutput(char[] chars) {
        StringBuffer stringBuffer1 = new StringBuffer();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            stringBuffer1.append(chars[i]);
        }
        // 先进行整体的反转
        StringBuffer reverseAll = stringBuffer1.reverse();
        // 将每个单词按照空格进行拆分
        String[] words = reverseAll.toString().split(" ");
        // 将每个单词进行反转
        for (int i = 0; i < words.length; i++) {
            StringBuffer reversePart = new StringBuffer().append(words[i]).reverse();
            stringBuffer.append(reversePart + " ");
        }
        System.out.println(stringBuffer.toString());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String english = scanner.nextLine();
        char[] chars = english.toCharArray();
        invertedOutput(chars);
    }
}
