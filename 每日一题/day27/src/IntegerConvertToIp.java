import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 整数与 IP 地址之间的转化
 *
 * 输入:
 * 1. 输入 IP 地址
 * 2. 输入 10 进制型的 IP 地址
 *
 * 输出:
 * 1. 输出转换成 10 进制的 IP 地址
 * 2. 输出转换后的 IP 地址
 * User: HHH.Y
 * Date: 2020-07-02
 */
public class IntegerConvertToIp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String ip = scanner.nextLine();
            String ip10 = scanner.nextLine();
            System.out.println(convertIP10(ip));
            System.out.println(convertIP(ip10));
        }
    }

    //
    private static long convertIP10(String ip) {
        String[] split = ip.split("\\.");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < split.length; i++) {
            // 十进制转换成二进制字符串
            // 将所有的二进制字符串进行拼接
            stringBuffer.append(binaryString(split[i]));
        }
        // 将二进制字符串转化成 10 进制数字(使用 Long 进行表示)
        long ret = Long.parseLong(stringBuffer.toString(), 2);
        return ret;
    }

    // 将十进制转换成二进制
    private static String binaryString(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        int num = Integer.parseInt(s);
        int k = 1 << 7;
        for (int i = 0; i < 8; i++) {
            int flg = ((num&k) == 0 ? 0 : 1);
            stringBuffer.append(flg);
            num = num << 1;
        }
        return stringBuffer.toString();
    }

    // 10 进制字符串转 ip 地址
    // 按照每段 8 位进行拆分, 每段转 10 进制, 不足 32 位补位, 拼接 4 段组成 ip 地址
    private static String convertIP(String ip10) {
        StringBuffer stringBuffer = new StringBuffer();
        // 长整型转二进制字符串, long 的静态方法
        String ip2 = Long.toBinaryString(Long.parseLong(ip10));
        String as = "";
        if(ip2.length() < 32) {
            // 不足 32 位前面补 0
            for (int i = 0; i < 32 - ip2.length(); i++) {
                as += "0";
            }
        }
        ip2 = as + ip2;
        // Ip 地址每一段进行拼接
        String[] ip = new String[4];
        ip[0] = ip2.substring(0, 8);
        ip[1] = ip2.substring(8, 16);
        ip[2] = ip2.substring(16, 24);
        ip[3] = ip2.substring(24);
        for (int i = 0; i < 4; i++) {
            stringBuffer.append(Integer.parseInt(ip[i], 2));
            if(i != 3) {
                stringBuffer.append(".");
            }
        }
        return stringBuffer.toString();
    }
}
