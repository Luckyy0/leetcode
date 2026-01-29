package leetcode.P535_EncodeAndDecodeTinyURL;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Codec {
    Map<String, String> shortToLong = new HashMap<>();
    Map<String, String> longToShort = new HashMap<>();
    String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random rand = new Random();
    String baseUrl = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    // Mã hóa một URL thành URL rút gọn.
    public String encode(String longUrl) {
        if (longToShort.containsKey(longUrl)) {
            return baseUrl + longToShort.get(longUrl);
        }

        String key;
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append(chars.charAt(rand.nextInt(chars.length())));
            }
            key = sb.toString();
        } while (shortToLong.containsKey(key));

        shortToLong.put(key, longUrl);
        longToShort.put(longUrl, key);
        return baseUrl + key;
    }

    // Decodes a shortened URL to its original URL.
    // Giải mã một URL rút gọn về URL gốc của nó.
    public String decode(String shortUrl) {
        String key = shortUrl.substring(baseUrl.length());
        return shortToLong.get(key);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
