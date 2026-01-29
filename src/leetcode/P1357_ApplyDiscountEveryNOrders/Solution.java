package leetcode.P1357_ApplyDiscountEveryNOrders;

import java.util.HashMap;
import java.util.Map;

class Cashier {
    private int n;
    private int discount;
    private int count;
    private Map<Integer, Integer> priceMap;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        this.count = 0;
        this.priceMap = new HashMap<>();
        for (int i = 0; i < products.length; i++) {
            priceMap.put(products[i], prices[i]);
        }
    }

    public double getBill(int[] product, int[] amount) {
        count++;
        double total = 0;
        for (int i = 0; i < product.length; i++) {
            total += (double) priceMap.get(product[i]) * amount[i];
        }

        if (count % n == 0) {
            total = total - (discount * total) / 100.0;
        }

        return total;
    }
}
