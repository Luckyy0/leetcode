package leetcode.P751_IPToCIDR;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> ipToCIDR(String ip, int n) {
        long startIp = ipToLong(ip);
        List<String> res = new ArrayList<>();

        while (n > 0) {
            // Find the lowest bit set (power of 2)
            // Tìm bit thấp nhất được đặt (lũy thừa của 2)
            long step = startIp & -startIp;
            if (step == 0)
                step = (long) 1 << 31; // For 0.0.0.0

            while (step > n)
                step /= 2;

            res.add(longToIp(startIp) + "/" + (32 - (int) (Math.log(step) / Math.log(2))));

            startIp += step;
            n -= step;
        }
        return res;
    }

    private long ipToLong(String ip) {
        String[] parts = ip.split("\\.");
        long res = 0;
        for (String part : parts) {
            res = res * 256 + Integer.parseInt(part);
        }
        return res;
    }

    private String longToIp(long ip) {
        return (ip >> 24 & 255) + "." + (ip >> 16 & 255) + "." + (ip >> 8 & 255) + "." + (ip & 255);
    }
}
