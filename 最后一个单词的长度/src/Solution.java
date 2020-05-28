/**
 * Created with IntelliJ IDEA.
 * Description: 求字符串中最后一个单词的长度
 * 1. 如果没有最后一个单词， 就返回 0
 * 2. 去掉字符串中前后的空格
 * 3. 从后向前遍历字符串, 若遇见空格, 说明最后一个单词已经遍历完, 返回最后一个字符串长度
 * User: HHH.Y
 * Date: 2020-05-28
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null) {
            return 0;
        }
        String ret = s.trim(); // 去掉字符串前后空格
        int count = 0;
        for (int i = ret.length() - 1; i >= 0; i--) {
            if(ret.charAt(i) != ' ') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
