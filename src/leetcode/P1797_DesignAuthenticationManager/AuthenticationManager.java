package leetcode.P1797_DesignAuthenticationManager;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager {
    private int timeToLive;
    private Map<String, Integer> expiryMap;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.expiryMap = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        expiryMap.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        Integer expiry = expiryMap.get(tokenId);
        if (expiry != null && expiry > currentTime) {
            expiryMap.put(tokenId, currentTime + timeToLive);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (Integer expiry : expiryMap.values()) {
            if (expiry > currentTime) {
                count++;
            }
        }
        return count;
    }
}
