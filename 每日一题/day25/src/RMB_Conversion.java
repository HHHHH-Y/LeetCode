import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 人民币转换
 * 1. 中文大写金额数字到 元 为止, 在元之后, 应写整字
 * 如: ¥532.00 应写成 "人民币伍佰叁拾贰元整". 在 角 和 分 后面不写政子
 * 2. 阿拉伯数字中间有 "0" 时, 中文大写要写 "零" 字, 阿拉伯数字中间连续有几个 "0", 中文大写金额中间只写一个 "零" 字
 * 如: ¥6007.14, 应该写成 "人民币陆仟零柒元壹角柒分".
 *
 * User: HHH.Y
 * Date: 2020-06-29
 */

public class RMB_Conversion {
    private static final char[] NUM = {'零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖', '拾', '佰', '仟', '万', '亿'};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double d = scanner.nextDouble();
        System.out.println(conversion(d));
    }

    private static String conversion(double d) {
        long n = (long) d; // 将输入的阿拉伯数字转换成一个整型的数字
        StringBuffer stringBuffer = new StringBuffer("人民币");

        // 处理整数部分, 前提是整数部分大于 0
        if(n > 0) {
            convert(n, stringBuffer);
            stringBuffer.append("元");
        }
        // 加上 0.0001 是为了防止 d * 100 发生失真
        int v = (int) (d * 100 - n * 100 + 0.0001); // 得到了小数部分的 值
        int i = v / 10; // 对应的 角
        int j = v % 10; // 对应的 分

        if(i != 0) {
            stringBuffer.append(NUM[i]).append('角');
        }
        if(j != 0) {
            stringBuffer.append(NUM[j]).append('分');
        }

        return stringBuffer.toString();
    }
    private static void convert(long n, StringBuffer stringBuffer) {
        // 大于一亿
        if(n > 100000000) {
            long q = n / 100000000; // 总共是 q 亿
            long r = n % 100000000; // 除去 亿元 后的数字

            convert(q, stringBuffer);
            stringBuffer.append('亿');

            // 不是 亿 的整数倍
            if(r != 0) {
                convert(r, stringBuffer);
            } else {
                stringBuffer.append('整');
            }
        } else if(n >= 10000) {
            // 大于一万
            long q = n / 10000;
            long r = n % 10000;

            convert(q, stringBuffer);
            stringBuffer.append('万');

            // 不是 万 的整数倍
            if(r != 0) {
                if(r < 100) {
                    stringBuffer.append('零');
                }
                convert(r, stringBuffer);
            } else {
                stringBuffer.append('整');
            }
        } else if(n >= 1000) {
            // 大于一千
            long q = n / 1000;
            long r = n % 1000;

            convert(q, stringBuffer);
            stringBuffer.append('仟');

            // 不是 千 的整数倍
            if(r != 0) {
                if(r < 100) {
                    stringBuffer.append('零');
                }
                convert(r, stringBuffer);
            } else {
                stringBuffer.append('整');
            }
        } else if(n >= 100) {
            long q = n / 100;
            long r = n % 100;

            convert(q, stringBuffer);
            stringBuffer.append('佰');

            if(r != 0) {
                if(r < 10) {
                    stringBuffer.append('零');
                }
                convert(r, stringBuffer);
            } else {
                stringBuffer.append('整');
            }
        } else if(n >= 10) {
            long q = n / 10;
            long r = n % 10;

            convert(q, stringBuffer);
            stringBuffer.append('拾');

            if(r != 0) {
                convert(r, stringBuffer);
            } else {
                stringBuffer.append('整');
            }
        } else {
            stringBuffer.append(NUM[(int)n]);
        }

    }
}
