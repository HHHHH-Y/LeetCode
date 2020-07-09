import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 球的半径和体积
 * 输入球的中心点和球上某一点的坐标, 计算球的半径和体积
 * 输入描述:
 * 球的中心点和球上某一点的坐标, 以如下形式输入: x0 y0 z0 x1 y1 z1
 * 输出描述:
 * 输入可能有多组, 对于多组输入, 输出球的半径和体积, 并且结果保留三位小数
 * 为避免精度问题, PI值请使用 arccos(-1)
 * User: HHH.Y
 * Date: 2020-07-09
 */
public class BallRadiusAndVolume {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double x0 = scanner.nextInt();
            double y0 = scanner.nextInt();
            double z0 = scanner.nextInt();
            double x1 = scanner.nextInt();
            double y1 = scanner.nextInt();
            double z1 = scanner.nextInt();
            double tmp = Math.pow((x1 - x0), 2) + Math.pow((y1 - y0), 2) + Math.pow((z1 - z0), 2);
            double radius = Math.sqrt(tmp);
            System.out.printf("%.3f", radius);
            double volume = (4 / 3.0) * Math.acos(-1.0) * Math.pow(radius, 3);
            System.out.printf(" %.3f", volume);
        }
    }
}
