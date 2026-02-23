package leet_code.Problem_271_Medium_Encode_And_Decode_Strings;

import java.util.ArrayList;
import java.util.List;

public class Codec {

    // Encodes a list of strings to a single string.
    // Mã hóa một danh sách chuỗi thành một chuỗi duy nhất.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            // Append length, sharp delimiter, and content
            // Thêm độ dài, dấu phân cách thăng, và nội dung
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    // Giải mã một chuỗi duy nhất thành một danh sách chuỗi.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            // Find the delimiter
            // Tìm dấu phân cách
            int slash = s.indexOf('#', i);

            // Parse length
            // Phân tích độ dài
            int size = Integer.parseInt(s.substring(i, slash));

            // Extract content
            // Trích xuất nội dung
            // Start after slash, end at start + size
            String content = s.substring(slash + 1, slash + 1 + size);
            result.add(content);

            // Move pointer
            // Di chuyển con trỏ
            i = slash + 1 + size;
        }
        return result;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        List<String> strs = new ArrayList<>();
        strs.add("Hello");
        strs.add("World");
        strs.add("Safe#Code"); // Contains delimiter

        String encoded = codec.encode(strs);
        System.out.println("Encoded: " + encoded);

        List<String> decoded = codec.decode(encoded);
        System.out.println("Decoded: " + decoded);
    }
}
