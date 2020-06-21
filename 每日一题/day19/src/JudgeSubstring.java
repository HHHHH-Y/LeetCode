import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: 子串判断
 * User: HHH.Y
 * Date: 2020-06-21
 */
public class JudgeSubstring {
    public static boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[] ret = new boolean[n];
        for (int i = 0; i < p.length; i++) {
            if(s.contains(p[i])) {
                ret[i] = true;
            } else {
                ret[i] = false;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String[] p = {"a", "b", "c", "d"};
        int n = 4;
        String s = "abc";
        boolean[] ret = chkSubStr(p, n, s);
        System.out.println(Arrays.toString(ret));
    }
}
