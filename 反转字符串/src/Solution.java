import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HHH.Y
 * Date: 2020-05-16
 */
public class Solution {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length-1;
        while(i <= j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
        System.out.println(Arrays.toString(s));
    }
}
