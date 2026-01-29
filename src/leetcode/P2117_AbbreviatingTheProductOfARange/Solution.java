package leetcode.P2117_AbbreviatingTheProductOfARange;

public class Solution {
    public String abbreviateProduct(int left, int right) {
        long count2 = 0;
        long count5 = 0;
        double sumLog = 0.0;
        long suffix = 1;
        long MAX_SUFFIX = 100000; // Modulo for last 5 digits implies we need to track enough
        // Wait, intermediate multiplies can exceed long if mod is 10^5?
        // 10^5 * 10^6 = 10^11. Fits in long.
        // Actually to correctly compute last 5, we should carry more precision to avoid
        // edge cases?
        // But multiplying `suffix * num` then `% 100000` is standard.
        // Problem: trailing zeros.
        // We have to remove 2s and 5s from suffix calculation corresponding to trails.
        // This is hard on the fly.
        // Alternative for Suffix: Compute product mod 10^5 usually, but we need AFTER
        // removing zeros.
        // But 2s and 5s are removed.
        // Let's count TOTAL 2s and 5s available in [left, right].
        // Zeros C = min(total2, total5).
        // For suffix: multiply numbers, removing factors 2 and 5 temporarily?
        // Or simply multiply (num / 2^a / 5^b) mod 100000.
        // And then multiply back `abs(total2 - total5)` of 2s or 5s at the end.

        // For "Small Check":
        // Maintain `long fullProd`. If it exceeds 10^12 (with zeros removed), stop and
        // rely on Prefix/Suffix.

        long fullProd = 1;
        boolean over = false;
        long limit = 10000000000L; // 10 digits

        int total2 = 0;
        int total5 = 0;

        // First pass: count 2s and 5s for C
        // Actually we can do it in one pass if careful.
        // But C is needed to know how many 2s and 5s to remove from suffix?
        // No, we can remove ALL 2s and 5s from the suffix-product accumulation,
        // and then multiply back the excess later.

        for (int i = left; i <= right; i++) {
            int num = i;
            while (num % 2 == 0) {
                total2++;
                num /= 2;
            }
            while (num % 5 == 0) {
                total5++;
                num /= 5;
            }
        }

        int C = Math.min(total2, total5);
        int rem2 = total2 - C;
        int rem5 = total5 - C;

        // Suffix path
        long currSuffix = 1;
        long MOD = 100000;

        // Prefix path
        // sumLog is sum of log10(i). No removal of 2/5 (as prefix unaffected by
        // trailing zeros conceptually?
        // Wait. Trailing zeros removal shifts decimal point.
        // 1200 -> 12. log(1200) = 3.079. log(12) = 1.079. Fractional part same.
        // So `sumLog` determines digits regardless of trailing zeros shift.

        // Small check
        // We need to implement removal on the fly for small check.
        // Can we just run `left` to `right` again?

        for (int i = left; i <= right; i++) {
            sumLog += Math.log10(i);

            // Suffix calculation: remove all 2s and 5s from factors
            int temp = i;
            while (temp % 2 == 0)
                temp /= 2;
            while (temp % 5 == 0)
                temp /= 5;
            currSuffix = (currSuffix * temp) % MOD;

            // Full Prod calculation (for small check)
            if (!over) {
                long val = i;
                // We should NOT remove 2s and 5s here yet?
                // Or standard approach: accumulate, then remove zeros while possible?
                fullProd *= val;
                while (fullProd % 10 == 0)
                    fullProd /= 10;
                if (fullProd >= limit) {
                    over = true;
                }

                // Wait. fullProd tracks product with zeros removed greedily.
                // If it exceeds limit, we mark over.
                // Does greedy zero removal work?
                // Yes, product non-zero part depends on factors.
                // But fullProd * val might overflow Long Max before div 10?
                // 10^10 * 10^6 = 10^16. Fits in Long.
            }
        }

        if (!over) {
            return fullProd + "e" + C;
        }

        // Finalize Suffix
        // Multiply back excess
        for (int k = 0; k < rem2; k++)
            currSuffix = (currSuffix * 2) % MOD;
        for (int k = 0; k < rem5; k++)
            currSuffix = (currSuffix * 5) % MOD;

        String suffixStr = String.format("%05d", currSuffix);

        // Finalize Prefix
        double fractional = sumLog - Math.floor(sumLog);
        // Prefix needs to be 5 digits.
        // 10^(fractional + 4)
        double preVal = Math.pow(10, fractional + 4);
        int prefixInt = (int) preVal;

        return prefixInt + "..." + suffixStr + "e" + C;
    }
}
