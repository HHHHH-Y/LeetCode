import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HHH.Y
 * Date: 2020-05-28
 */
public class TestDemo {
    public static void main(String[] args) {
//        String[] worlds = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        String[] worlds = {"i", "love", "LeetCode", "i", "love", "coding"};
        int k = 2;
        Solution solution = new Solution();
        List<String> list = solution.topKFrequent(worlds, k);
        System.out.println(list);
    }
}
