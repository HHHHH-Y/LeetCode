import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 和奥巴马一起画正方形

 * 美国总统奥巴马不仅呼吁所有人都学习编程，甚至以身作则编写代码，成为美国历史上首位编写计算机代码的总统
 * 2014年底，为庆祝“计算机科学教育周”正式启动，奥巴马编写了很简单的计算机代码：在屏幕上画一个正方形。现在你也跟他一起画吧！
 *
 * 输入描述:
 * 输入在一行中给出正方形边长N（3<=N<=20）和组成正方形边的某种字符C，间隔一个空格。
 *
 * 输出描述:
 * 输出由给定字符C画出的正方形。但是注意到行间距比列间距大，所以为了让结果看上去更像正方形，我们输出的行数实际上是列数的50%
 * （四舍五入取整）。
 * 例如： 输入：10 a
 *       输出：aaaaaaaaaa
 *            a        a
 *            a        a
 *            a        a
 *            aaaaaaaaaa
 * User: HHH.Y
 * Date: 2020-06-14
 */
public class DrawSquare {
    /*private static void draw(int n, char c) {
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = c;
        }
        long middleRow = Math.round(n * 0.5) - 2;
        for (char ch:chars) {
            System.out.print(ch);
        }
        System.out.println();
        for (int i = 0; i < middleRow; i++) {
            for (int j = 0; j < chars.length; j++) {
                if(j == 0 || j == chars.length - 1) {
                    System.out.print(c);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (char ch:chars) {
            System.out.print(ch);
        }
    }*/
    private static void draw(int n, char c) {
        long row = Math.round(n * 0.5);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 || i == row - 1) {
                    System.out.print(c);
                } else {
                    if(j == 0 || j == n - 1) {
                        System.out.print(c);
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char c = scanner.nextLine().charAt(1);
        draw(n, c);
    }
}
