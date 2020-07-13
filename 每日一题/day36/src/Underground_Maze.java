import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 地下迷宫(n * m 格子的地下迷宫)
 * 输入描述:
 * 输入包括 n + 1 行, 第一行为 3 个整数 n, m, P, 接下来的 n 行, 每行 m 个 0 或者 1, 以空格分开.
 *
 * 输出描述:
 * 如果能逃离迷宫, 则输出一行体力消耗最小的路径, 如果不能逃出迷宫, 则输出: "Can not escape!"
 *
 * 4  4  10
 * 1 0 0 1
 * 1 1 0 1
 * 0 1 1 1
 * 0 0 1 1
 *
 * [0, 0], [1, 0], [1, 1], [2, 1], [2, 2], [2, 3],  [1, 3], [0, 3]
 * User: HHH.Y
 * Date: 2020-07-13
 */
public class Underground_Maze {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
        // n*m迷宫,小青蛙初始在(0,0)位置,地下迷宫的出口在(0,m-1)
        // 小青蛙在迷宫中水平移动一个单位距离需要消耗1点体力值,向
        // 上爬一个单位距离需要消耗3个单位的体力值,向下移动不消耗体力值
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        // 剩余体力值
        int p = scanner.nextInt();
        int[][] array = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++)
                array[i][j] = scanner.nextInt();
        }
        System.out.println(pathOut(n , m, array, p));
    }
}

    static String path = "";
    public static String pathOut(int n, int m, int[][] maze, int power){
        // 如果迷宫并没有网格, 就逃离失败
        if(n <= 0)
            return "Can not escape!";
        // 代表节点是否被访问过
        boolean[][] visited = new boolean[n][m];
        findPath(n, m, maze, 0, 0, "", visited, power);

        return path;
    }

    public static void findPath(int n, int m, int[][] array, int nowx, int nowy, String res, boolean[][] visited, int power){
        // 当此节点为最终的节点, 且值为 1 时
        if(nowx == 0 && nowy == m - 1 && array[0][m - 1] == 1){
            // 如果还有力量, 就可以进行逃脱
            if(power >= 0)
                path = res + "[0," + (m - 1) + "]";
            // 否则就逃离失败
            else
                path = "Can not escape!";
            return;
        }

        // 如果此节点位于网格之中(不是网格的边节点), 且此节点的值为 1, 且没有被访问过
        if(nowx < n && nowy < m && nowx >= 0 && nowy >= 0 && array[nowx][nowy] == 1 && !visited[nowx][nowy]){
            visited[nowx][nowy] = true;
            res += "[" + nowx + "," + nowy + "],";
            // 水平向右
            findPath(n, m, array, nowx, nowy + 1, res, visited, power - 1);
            // 向下
            findPath(n, m, array, nowx + 1, nowy, res, visited, power);
            // 水平向左
            findPath(n, m, array, nowx, nowy - 1, res, visited, power - 1);
            // 向上
            findPath(n, m, array, nowx - 1, nowy, res, visited, power - 3);
        }

    }
}
