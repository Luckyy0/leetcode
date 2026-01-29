package leetcode.P535_EncodeAndDecodeTinyURL;

import java.util.*;

public class Codec {
    private Map<String, String> map = new HashMap<>();
    private String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private Random random = new Random();
    private String base = "http://tinyurl.com/";

    public String encode(String longUrl) {
        String key;
        do {
            key = generateKey();
        } while (map.containsKey(key));
        map.put(key, longUrl);
        return base + key;
    }

    public String decode(String shortUrl) {
        return map.get(shortUrl.replace(base, ""));
    }

    private String generateKey() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        String url = "https://leetcode.com/problems/design-tinyurl";
        String encoded = codec.encode(url);
        System.out.println("Encoded: " + encoded);
        System.out.println("Decoded: " + codec.decode(encoded));
    }
}
