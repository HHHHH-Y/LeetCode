import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 洗牌问题
 * 洗牌在生活中十分常见，现在需要写一个程序模拟洗牌的过程。
 * 现在需要洗2n张牌，从上到下依次是第1张，第2张，第3张一直到第2n张。
 * 首先，我们把这2n张牌分成两堆，左手拿着第1张到第n张（上半堆），右手拿着第n+1张到第2n张（下半堆）
 * 接着就开始洗牌的过程，
 * 先放下右手的最后一张牌，再放下左手的最后一张牌，接着放下右手的倒数第二张牌，再放下左手的倒数第二张牌，直到最后放下左手的第一张牌。
 * 接着把牌合并起来就可以了。
 * 例如有6张牌，最开始牌的序列是1,2,3,4,5,6。
 * 首先分成两组，左手拿着1,2,3；右手拿着4,5,6。
 * 在洗牌过程中按顺序放下了6,3,5,2,4,1。把这六张牌再次合成一组牌之后，我们按照从上往下的顺序看这组牌，就变成了序列1,4,2,5,3,6。
 * 现在给出一个原始牌组，请输出这副牌洗牌k次之后从上往下的序列。
 *
 * 输入描述:
 * 第一行一个数T(T ≤ 100)，表示数据组数。
 * 对于每组数据，第一行两个数n,k(1 ≤ n,k ≤ 100)，接下来一行有2n个数a1,a2,...,a2n(1 ≤ ai ≤ 1000000000)。表示原始牌组从上到下的序列。
 *
 * 输出描述:
 * 对于每组数据，输出一行，最终的序列。数字之间用空格隔开，不要在行末输出多余的空格。
 *
 * 思路：
 * 排序前     1  2  3  4  5  6
 *           0  1  2  3  4  5
 *
 * 排序后     1  4  2  5  3  6
 *           0  1  2  3  4  5
 *
 * 由此可见：
 * 当下标小于 n 时，洗牌后下标的变化：
 *          洗牌前0 洗牌后0
 *          洗牌前1 洗牌后2    相当于：2*下标
 *          洗牌前2 洗牌后4
 *  当下标大于 n 时，洗牌后下标的变化：
 *          洗牌前3 洗牌后1
 *          洗牌前4 洗牌后3    相当于：2*（下标-1）+ 1
 *          洗牌前5 洗牌后5
 * User: HHH.Y
 * Date: 2020-06-18
 */
public class Shuffle {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int m = scanner.nextInt(); // m 表示数据组数
            while(m!=0){
                int n = scanner.nextInt();
                int k = scanner.nextInt(); // k 表示洗牌次数
                int [] arr = new int[2*n]; // arr 用于存放输入的牌
                //计算下标，将下标确定好之后再进行输入
                for(int i = 0; i < 2*n;i++){
                    int temp = i;
                    for(int j = 0; j < k ;j++){
                        // 进行 k 次洗牌
                        if(temp < n){
                            temp = 2*temp;
                        }else{
                            temp = 2*(temp-n) + 1;
                        }
                    }
                    //temp为元素经历k次洗牌之后的下标
                    arr[temp] = scanner.nextInt();
                }
                //输出
                for(int i = 0;i < 2*n;i++){
                    if(i == 2*n-1){
                        System.out.print(arr[i]);
                    }else {
                        System.out.print(arr[i]+" ");
                    }
                }
                System.out.println();
                m--;
            }
        }
    }
}
