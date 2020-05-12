import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HHH.Y
 * Date: 2020-05-12
 */
public class Solution {
        public List<List<Integer>> generate(int numRows) {
            // 1. 创建一个集合, 用于存放各行的集合
            // 2. 判断numRows的值, 如果为0, 就返回一个空集合
            // 3. 杨辉三角的第一行中, 只有一个1 (下标从0开始计算)
            // 4. 从第二行开始, 每行的第一个元素都为1, 最后一个元素为1
            // 5. 中间的元素[i, j] = [i-1, j] + [i-1, j-1]
            // 6. 每写完一行, 就将这一行加到集合中
            List< List<Integer> > ret = new ArrayList<>();
            if(numRows == 0) {
                return ret;
            }
            // 每次往集合里放时, 都要创建一个集合
            ret.add(new ArrayList<>());
            ret.get(0).add(1);
            for (int i = 1; i < numRows; i++) {
                List<Integer> curRow = new ArrayList<>(); // 每一行都需要创建一个集合
                curRow.add(1);
                // 获得前一行
                List<Integer> prevRow = ret.get(i - 1);
                for (int j = 1; j < i; j++) {
                    // 除第一个元素和最后一个元素以外, 中间的元素 [i, j] = [i-1, j] + [i-1, j-1]
                    int x = prevRow.get(j);
                    int y = prevRow.get(j - 1);
                    curRow.add(x + y);
                }
                curRow.add(1);
                ret.add(curRow);
            }
            return ret;
        }
}
