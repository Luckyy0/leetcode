package leetcode.P1067_DigitCountInRange;

class Solution {
    public int digitsCount(int d, int low, int high) {
        return count(high, d) - count(low - 1, d);
    }

    private int count(int n, int d) {
        if (n < 0)
            return 0;
        if (n == 0)
            return d == 0 ? 1 : 0; // Usually range is 1 to n, but problem says low could be 0?
        // Actually for digit count logic, usually handle 1..n.
        // If n=0, digit 0 appears once. But leading zeros?
        // Logic: low >= 1 usually. If low=0 and d=0, we count 0.
        // Let's stick to standard math logic which naturally works for range.

        String s = String.valueOf(n);
        int len = s.length();
        int total = 0;

        for (int i = 0; i < len; i++) {
            // Processing digit at index i (from left, 0-indexed)
            // Weight i.e. power of 10. len-1-i power.
            long power = (long) Math.pow(10, len - 1 - i);
            int digit = s.charAt(i) - '0';

            // Higher part (prefix before current digit)
            int highPart = i == 0 ? 0 : Integer.parseInt(s.substring(0, i));

            // Contributions from fully passed full-blocks
            total += highPart * power;

            // Corrections for current digit
            if (digit > d) {
                total += power;
            } else if (digit == d) {
                // Lower part + 1
                int lowPart = i == len - 1 ? 0 : Integer.parseInt(s.substring(i + 1));
                total += lowPart + 1;
            }

            // Correction for d=0 (leading zeros)
            if (d == 0) {
                total -= power; // Remove cases where this position is 0 but number has leading zeros (invalid
                                // 0s)
            }
        }

        // If d=0 and n includes 0? P1067 constraints 1 <= low <= high.
        // Wait, typical problem "Digit Count in Range" handles d=0 carefully.
        // My logic for d=0: "total -= power" removes imaginary leading zeros
        // contributions.
        // Example n=20, d=0.
        // i=0 (digit 2, power 10). high=0. total += 0*10 = 0. dig=2 > 0 -> total+=10.
        // d=0 -> total-=10. -> 0.
        // i=1 (digit 0, power 1). high=2. total += 2*1 = 2. dig=0 == 0 -> low=0 ->
        // total+=1 -> 3. d=0 -> total-=1 -> 2.
        // Total 2. Numbers: 10, 20. Correct.

        // Wait, if input n=0? But problem says low >= 0? Maybe low can be 0.
        // If range includes 0 and d=0, we should count it. My logic calculates for 1..n
        // properly essentially.
        // It treats 0 as non-existent "000". But actual number 0 has one zero.
        // If input range starts at 0, we might need +1 if d=0.

        return total + (d == 0 ? 1 : 0); // Logic usually counts 1..N. If we need to include 0 itself for d=0.
    }

    // Correction: actually typical Digit Counting excludes leading zeros and counts
    // digits in 1..n.
    // And for n=0?
    // If input low=0, high=10, d=0. Should be 0, 10 -> 2 zeros?
    // My formula returns count(10, 0) - count(-1, 0).
    // count(10, 0): 10 has '0'. '1'.. '9' no. So 1.
    // Plus the "+ (d==0?1:0)" makes it 2. Which is correct for including number 0.
}
