import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description: 给定一个非空整数数组, 除了某个元素之出现一次以外, 其余每个元素均出现两次
 * 找出那个只出现一次的元素
 *
 * 例如: [2, 2, 1] --> 1
 *       [4, 1, 2, 1, 2] --> 4
 * User: HHH.Y
 * Date: 2020-05-26
 */
public class Solution {
    public int singleNumber1(int[] nums) {
        // 方法一: 使用异或的方式(最佳的方法)
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret ^= nums[i];
        }
        return ret;
    }

    public int singleNumber2(int[] nums) {
        // 方法二: 使用集合的方法
        // 因为题中给出, 只有一个出现一次的数字, 其余的数据均出现两次
        // 每次往集合中存放数据的时候先判断集合中是否有重复的数据, 若有, 就将集合中重复的数据删除. 若没有, 就将这个数据放入集合中
        // 最后集合中存放的元素一定就是出现一次的元素
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        Iterator<Integer> it = set.iterator();
        return it.next();
    }
}
