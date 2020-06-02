import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:给你一个字符串数组, 数组中的每个字符串都可以看做是一个单词.请你按照任意顺序返回数组中是其他单词的子字符串的所有单词
 *
 * 思路: 先将所有字符串拼接起来,每拼接一个单词, 就拼接一个空格,形成一个长字符串
 *       (为什么要拼接一个空格? 防止两个单词拼接在一起后, 在寻找过程中, 一个字符串在两个单词拼接中出现, 造成困扰)
 *       遍历字符串数组, 若该字符串在长字符串中出现了两次, 说明该字符串就是一个子字符串, 否则就不是子字符串
 * User: HHH.Y
 * Date: 2020-06-02
 */
public class Solution {
    public int contains(String string, String str) {
        int len = str.length();
        int index = string.indexOf(str);
        if(index != -1) {
            int index1 = string.indexOf(str, index + len);
            if(index1 != -1) {
                return 2;
            }
        }
        return -1;
    }
    public List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]).append(" ");
        }
        String str = sb.toString();
        for (int i = 0; i < words.length; i++) {
            if(contains(str, words[i]) == 2) {
                list.add(words[i]);
            }
        }
        return list;
    }
}
