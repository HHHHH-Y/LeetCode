import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description: n个数里出现次数大于等于 n/2的数
 * 题目描述:
 * 输入n个整数，输出出现次数大于等于数组长度一半的数。
 * <p>
 * 输入: 每个测试输入包含 n个空格分割的n个整数，n不超过100，其中有一个整数出现次数大于等于n/2
 * 3 9 3 2 5 6 7 3 2 3 3 3
 * 输出: 输出出现次数大于等于n/2的数。
 * 3
 * <p>
 * 思路: 通过暴力解法进行解题
 * 计算数组中每个元素的出现次数, 只要有一个元素的出现次数 >= n / 2, 就直接返回.
 * User: HHH.Y
 * Date: 2020-06-06
 */
public class Larger_than_nums {
    public static void nums(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int j = 0; j < array.length; j++) {
                if(array[i] == array[j]) {
                    count++;
                }
            }
            if(count >= array.length / 2) {
                System.out.println(array[i]);
                break;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strings = str.split(" ");
        int[] array = new int[strings.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(strings[i]);
        }
        nums(array);
    }
}
