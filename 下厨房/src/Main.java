import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description: 牛牛想做饭, 每种料理需要一些不同的材料, 问完成所有的料理需要准备多少种不同的材料
 * User: HHH.Y
 * Date: 2020-06-03
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while (scanner.hasNext()) {
            set.add(scanner.nextLine().toUpperCase());
        }
        System.out.println(set.size());
    }
}
