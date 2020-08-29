package pointertoffer;

/**
 * @author lizhanzhan
 * @date 2020/8/2
 * @explanation 替换空格
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class ReplaceSpace05 {
    public static String replaceSpace(String s) {
        return s.replace(" ", "20%");
    }

    public static void main(String[] args) {
        System.out.println(ReplaceSpace05.replaceSpace("we are happy.  "));
    }
}
