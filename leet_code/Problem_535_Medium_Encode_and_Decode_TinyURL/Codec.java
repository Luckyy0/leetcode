package leet_code.Problem_535_Medium_Encode_and_Decode_TinyURL;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Codec {

    // Store Short -> Long
    private Map<String, String> map;
    private Random rand;
    private final String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String BASE_HOST = "http://tinyurl.com/";

    public Codec() {
        map = new HashMap<>();
        rand = new Random();
    }

    // Encodes a URL to a shortened URL.
    // Strategy: Simple random key generation. Check collision.
    public String encode(String longUrl) {
        String key = generateKey();
        while (map.containsKey(key)) {
            key = generateKey();
        }
        map.put(key, longUrl);
        return BASE_HOST + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String key = shortUrl.replace(BASE_HOST, "");
        return map.get(key);
    }

    private String generateKey() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        String url = "https://leetcode.com/problems/design-tinyurl";
        String tiny = codec.encode(url);
        System.out.println("Tiny: " + tiny);
        System.out.println("Original: " + codec.decode(tiny));
    }
}
