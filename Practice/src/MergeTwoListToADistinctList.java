import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 两个 list 合并成无重复的 List
 *
 * 使用 set, 因为 set 具有去重的作用
 * 将两个 list 全部加入到一个 set 中, 然后将这个 set 再转换成 list 即可
 * User: HHH.Y
 * Date: 2020-09-05
 */
public class MergeTwoListToADistinctList {
    // 将两个 list 合并成一个不重复的 list
    public static void main(String[] args) {
        String[] arr1 = {"a", "b", "c", "d", "e"};
        // Arrays.asList(数组): 将 数组 转换成 list 集合
        List<String> list1 = new ArrayList<>(Arrays.asList(arr1));

        String[] arr2 = {"d", "e", "f", "g", "h"};
        List<String> list2 = new ArrayList<>(Arrays.asList(arr2));

        // 创建一个 set 集合, 将两个 list 都加入到这个 set 集合中
        Set<String> set = new HashSet<>(list1);
        set.addAll(list2);

        // 将这个 set 转换成一个 List
        List<String> list = new ArrayList<>(set);
        System.out.println(list);

    }
}
