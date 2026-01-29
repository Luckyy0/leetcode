package leetcode.P1169_InvalidTransactions;

import java.util.ArrayList;
import java.util.List;

class Solution {
    class Transaction {
        String name;
        int time;
        int amount;
        String city;
        String original;
        int id;

        Transaction(String s, int id) {
            this.id = id;
            this.original = s;
            String[] parts = s.split(",");
            name = parts[0];
            time = Integer.parseInt(parts[1]);
            amount = Integer.parseInt(parts[2]);
            city = parts[3];
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        Transaction[] txs = new Transaction[n];
        for (int i = 0; i < n; i++) {
            txs[i] = new Transaction(transactions[i], i);
        }

        boolean[] invalid = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (txs[i].amount > 1000) {
                invalid[i] = true;
            }
            // Check conflict
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (txs[i].name.equals(txs[j].name)) {
                    if (Math.abs(txs[i].time - txs[j].time) <= 60 && !txs[i].city.equals(txs[j].city)) {
                        invalid[i] = true;
                        invalid[j] = true;
                    }
                }
            }
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (invalid[i])
                res.add(txs[i].original);
        }
        return res;
    }
}
