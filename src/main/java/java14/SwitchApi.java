package java14;


/**
 * jdk 12 13预览
 * 14正式推出
 */
public class SwitchApi {

    public static void main(String[] args) {
        System.out.println(switchJava12("december"));
    }


    // 通过传入月份，输出月份所属的季节
    public static String switchJava12(String month) {
        return switch (month) {
            case "march", "april", "may"            -> "春天";
            case "june", "july", "august"           -> "夏天";
            case "september", "october", "november" -> "秋天";
            case "december", "january", "february"  -> "冬天";
            default -> "month erro";
        };
    }
    // 通过传入月份，输出月份所属的季节
    public static String switchJava13(String month) {
        return switch (month) {
            case "march", "april", "may":
                yield "春天";
            case "june", "july", "august":
                yield "夏天";
            case "september", "october", "november":
                yield "秋天";
            case "december", "january", "february":
                yield "冬天";
            default:
                yield "month error";
        };
    }

}
