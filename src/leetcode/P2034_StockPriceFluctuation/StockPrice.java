package leetcode.P2034_StockPriceFluctuation;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StockPrice {
    Map<Integer, Integer> timestampMap;
    TreeMap<Integer, Integer> priceMap;
    int maxTimestamp;

    public StockPrice() {
        timestampMap = new HashMap<>();
        priceMap = new TreeMap<>();
        maxTimestamp = 0;
    }

    public void update(int timestamp, int price) {
        if (timestampMap.containsKey(timestamp)) {
            int oldPrice = timestampMap.get(timestamp);
            priceMap.put(oldPrice, priceMap.get(oldPrice) - 1);
            if (priceMap.get(oldPrice) == 0) {
                priceMap.remove(oldPrice);
            }
        }
        timestampMap.put(timestamp, price);
        priceMap.put(price, priceMap.getOrDefault(price, 0) + 1);
        maxTimestamp = Math.max(maxTimestamp, timestamp);
    }

    public int current() {
        return timestampMap.get(maxTimestamp);
    }

    public int maximum() {
        return priceMap.lastKey();
    }

    public int minimum() {
        return priceMap.firstKey();
    }
}
