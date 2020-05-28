/**
 * Created with IntelliJ IDEA.
 * Description: 压缩字符串
 * 1. 定义三个变量, i 用于遍历数组, k 表示最后数组中应该存放的元素下标, count表示数组中重复元素的个数
 * 2. 在数组不为空的前提下, 先保留第一个字符, 然后从第二个字符开始遍历
 * 3. 如果相同, 就让 count + 1, 直到找到不相同的元素. 将 count 放入对应字符后面.
 * 4. 如果不相同, 就直接存放该字符
 *
 * 例如: chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'}
 * 最后数组为: {'a', '2', 'b', '2', 'c', '3'}
 * 返回数组长度为 6
 * User: HHH.Y
 * Date: 2020-05-28
 */
public class Solution {
    public int compress(char[] chars) {
        if(chars.length == 0) {
            return 0;
        }
        int i = 1; // 未更改数组下标
        int k = 0; // 更改的数组的下标
        int count = 1;
        chars[k++] = chars[0];
        while (i < chars.length) {
            if(chars[i] == chars[i - 1]) { // 如果后一个元素和第一个元素相同, count++
                count++;
            } else {
                // 只有 count 不为 1 的时候才需要放进数组中
                if(count > 1) {
                    char[] ch = String.valueOf(count).toCharArray(); // 先将数字转换成字符串,在将字符串转换成字符数组的形式
                    for (int n = 0; n < ch.length; n++) {
                        chars[k++] = ch[n];
                    }
                }
                count = 1;
                chars[k++] = chars[i];
            }
            i++;
        }
        if(count > 1) {
            char[] ch = String.valueOf(count).toCharArray();
            for (int n = 0; n < ch.length; n++) {
                chars[k++] = ch[n];
            }
        }
        return k;
    }
}
