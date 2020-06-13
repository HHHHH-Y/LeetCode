
/**
 * Created with IntelliJ IDEA.
 * Description: (1, 2) -> (2, 1);
 * 前提：在不使用任何临时变量的情况下进行交换
 *
 * 可以使用异或进行求解
 * User: HHH.Y
 * Date: 2020-06-13
 */
public class Exchange {
    public int[] exchangeAB(int[] AB) { // 1 001   2 010
//        AB[0] = AB[0] + AB[1];
//        AB[1] = AB[0] - AB[1];
//        AB[0] = AB[0] - AB[1];
        AB[0] = AB[0] ^ AB[1]; // 001 ^ 010 = 011 3
        AB[1] = AB[0] ^ AB[1]; // 011 ^ 010 = 001 1
        AB[0] = AB[0] ^ AB[1]; // 011 ^ 001 = 010 2
        return AB;
    }

}
