import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 判断一个字符串是否是一个合法的 ip 地址
 * 合法的 ip 地址格式: (1 - 255).(0 - 255).(0 - 255).(0 - 255)
 *
 * 思路:
 * 需要穷举出是非法 ip 地址的情况
 * 1. 先判断字符串是否符合合法 ip 的规定:
 *      1. 判断字符串是否为空: 如果字符串为空, 就是非法 ip 地址
 *      2. 判断字符串的长度: 合法 ip 地址的长度中, 最短为: x.x.x.x (7位), 最长为: xxx.xxx.xxx.xxx (15位), 所以不在这个范围内的都是非法 ip
 *      3. 判断字符串的首末字符: 如果字符串的首末字符出现了 '.', 说明是非法 ip 地址
 * 2. 判断分割后的字符串数组是否符合合法 ip 的规定:
 *      1. 按照 "." 进行分割, 看分割出来的字符串个数: 如果字符串个数不等于 4, 则是非法 ip
 *      2. 对每一个字符串进行检查: 如果该字符串是由多个字符组成且首字符是 '0', 则是非法 ip
 *      3. 检查字符串的字符: 字符串的字符必须是由 0-9 组成的, 如果不是, 则是非法 ip
 *      4. 检查每个字符串对应的数字: 第一个对应的数字应该在 1-255 之间, 剩余三个应该在 0-255 之间, 否则就是非法 ip
 *
 * 只有当上述条件都满足时, 才是合法 ip
 *
 *
 * User: HHH.Y
 * Date: 2020-07-28
 */
public class IsIp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        boolean isIpLegal = isIpLegal(str);
        if(isIpLegal == true) {
            System.out.println(str + "是 ip 地址");
        } else {
            System.out.println(str + "不是 ip 地址");
        }
    }

    private static boolean isIpLegal(String str) {
        // 1. 检查 ip 地址是否为空
        if(str == null) {
            return false;
        }

        // 2. 检查 ip 地址的长度是否合法
        //    ip 地址的长度最短为: x.x.x.x 7位
        //    ip 地址的长度最长为: xxx.xxx.xxx.xxx 15位
        if(str.length() < 7 || str.length() > 15) {
            return false;
        }

        // 3. 对 ip 地址的首末字符进行判断, 如果首末字符出现".", 则说明是非法 ip
        if(str.charAt(0) == '.' || str.charAt(str.length() - 1) == '.') {
            return false;
        }

        // 4. 对字符串以 . 进行分割, 看分割出来的长度, 如果不是 4 个, 则说明是非法 ip
        String[] split = str.split("\\.");
        if(split.length != 4) {
            return false;
        }

        // 5. 对分割出来的每一个字符串进行单独的判断
        for (int i = 0; i < split.length; i++) {
            // 5.1 如果每个字符串不是一位字符, 且是以 0 开头的, 说明是非法 ip
            if(split[i].length() > 1 && split[i].charAt(0) == '0') {
                return false;
            }
            // 5.2 对字符串的每个字符进行逐一的判断, 如果不是 0-9, 则说明是非法 ip
            for (int j = 0; j < split[i].length(); j++) {
                if(split[i].charAt(j) < '0' || split[i].charAt(j) > '9') {
                    return false;
                }
            }
        }

        // 6. 对拆分出来的每个字符串转换成数字, 判断数字的范围是否合法
        //    即: 第一个数字的范围应该在 1-255, 剩下的数字的范围应该在 0-255 之间
        for (int i = 0; i < split.length; i++) {
            int num = Integer.parseInt(split[i]);
            if(i == 0) {
                if(num < 1 || num > 255) {
                    return false;
                }
            } else {
                if(num < 0 || num > 255) {
                    return false;
                }
            }
        }
        return true;
    }

}
