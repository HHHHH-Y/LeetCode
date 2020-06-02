import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HHH.Y
 * Date: 2020-06-02
 */
public class TestDemo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"mass", "as", "hero", "superhero"};
        List<String> list = solution.stringMatching(words);
        System.out.println(list);
    }
}
