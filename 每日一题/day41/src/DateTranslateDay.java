import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 计算日期到天数的转换
 * 根据输入的日期, 计算时这一年的第几天.
 * 输入某年某月某日, 判断这一天是这一年的第几天?
 *
 * 输入描述:
 * 输入三行, 分别是年, 月, 日
 * 输出描述:
 * 成功: 返回 outDay 输出计算后的第几天
 * 失败: 返回 -1
 * User: HHH.Y
 * Date: 2020-07-18
 */
public class DateTranslateDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            System.out.println(outDay(year, month, day));
        }
    }

    private static int outDay(int year, int month, int day) {
        // 将十二个月的天数放进一个数组中, 默认二月为 28 天
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(year <= 0 || month <= 0 || month > 12 || day > days[month - 1]) {
            return -1;
        }
        // 如果该年为闰年, 则二月为 29 天
        if(year % 4 == 0 && year % 100 != 0) {
            days[1] = 29;
        }
        int sum = 0;
        for (int i = 0; i < month - 1; i++) {
            sum += days[i];
        }
        sum = sum + day;
        return sum;
    }
}
