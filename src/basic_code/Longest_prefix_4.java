package basic_code;

public class Longest_prefix_4 {
    // Lấy phần tử đầu tiên làm prefix, for từ phần tử thứ 2, nếu không start with với prefix, cắt prefix đi 1 kí tự
    // Nếu prefix empty return
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder(strs.length > 0 ? strs[0] : "");
        for (int i = 1; i < strs.length;i++) {
            String s = strs[i];
            while (!s.startsWith(prefix.toString()) && !prefix.isEmpty()) {
                prefix.deleteCharAt(prefix.length() - 1);
            }
            if (prefix.isEmpty()) {
                break;
            }
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        String s[] = new String[] { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(s));
    }
}
