package leet_code.Problem_927_Hard_Three_Equal_Parts;

import java.util.*;

/**
 * Problem 927: Three Equal Parts
 * https://leetcode.com/problems/three-equal-parts/
 */
public class Solution {

    /**
     * Divides the array into three parts with equal binary value.
     * Strategy: Two-pass with Ones Counting and Pattern Matching.
     * 
     * @param arr Input binary array.
     * @return [i, j] split indices or [-1, -1].
     * 
     *         Tóm tắt chiến lược:
     *         1. Đếm tổng số lượng số 1 trong mảng (countOnes).
     *         2. Nếu countOnes không chia hết cho 3, không thể chia mảng thành 3
     *         phần bằng nhau về mặt nhị phân -> Trả về [-1, -1].
     *         3. Nếu countOnes = 0, nghĩa là toàn số 0. Ta có thể chia bất kỳ, ví
     *         dụ [0, 2] (nếu mảng đủ dài).
     *         4. Gọi k = countOnes / 3. Mỗi phần phải chứa đúng k số 1.
     *         5. Tìm vị trí xuất hiện đầu tiên của số 1 trong mỗi phần:
     *         - i1: Vị trí của số 1 đầu tiên (số 1 thứ 1 trong tổng số countOnes).
     *         - i2: Vị trí của số 1 đầu tiên của phần 2 (số 1 thứ k+1).
     *         - i3: Vị trí của số 1 đầu tiên của phần 3 (số 1 thứ 2k+1).
     *         6. Phần thứ 3 bắt đầu từ i3 và kéo dài đến hết mảng. Độ dài và mẫu
     *         bits của phần này là CHUẨN.
     *         Ta so sánh từng bit của phần 3 (từ i3 đến end) với phần 1 (từ i1) và
     *         phần 2 (từ i2).
     *         7. Nếu tất cả các bit khớp nhau cho đến khi phần 3 kết thúc, ta đã
     *         tìm được mẫu hợp lệ.
     *         Khi đó, i1 sẽ trỏ đến ngay sau phần 1, và i2 trỏ đến ngay sau phần 2.
     *         Kết quả trả về là [i1 - 1, i2].
     */
    public int[] threeEqualParts(int[] arr) {
        int countOnes = 0;
        for (int x : arr)
            countOnes += x;

        if (countOnes % 3 != 0)
            return new int[] { -1, -1 };
        if (countOnes == 0)
            return new int[] { 0, arr.length - 1 }; // Valid split for all zeros

        int k = countOnes / 3;
        int i1 = -1, i2 = -1, i3 = -1;
        int currentOneCount = 0;

        // Find the starting 1 for each part
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                currentOneCount++;
                if (currentOneCount == 1)
                    i1 = i;
                else if (currentOneCount == k + 1)
                    i2 = i;
                else if (currentOneCount == 2 * k + 1)
                    i3 = i;
            }
        }

        // The third part defines the pattern from i3 to the end of array
        // We must ensure part 1 (starting at i1) and part 2 (starting at i2) match this
        // pattern
        while (i3 < arr.length) {
            if (arr[i1] == arr[i3] && arr[i2] == arr[i3]) {
                i1++;
                i2++;
                i3++;
            } else {
                return new int[] { -1, -1 };
            }
        }

        // i1 - 1 is the end of the first part
        // i2 is the start of the third part? No.
        // The problem asks for [i, j] s.t.
        // Part 1: arr[0]...arr[i]
        // Part 2: arr[i+1]...arr[j-1]
        // Part 3: arr[j]...arr[end]

        // After loop:
        // i1 points to the index after the matching segment of Part 1.
        // i2 points to the index after the matching segment of Part 2.

        // Is it possible there are unmatched zeros between the parts?
        // Since we matched until the end of the array (i3 hit length), the trailing
        // zeros of Part 3 are matched
        // to trailing zeros of Part 1 and Part 2.
        // So the boundaries are tightly defined by the matches.

        // We need to check if i1 <= i2 (Part 1 doesn't overlap/pass start of Part 2)
        // Wait, i2 was the *start* index of part 2 matching loop.
        // Original i2 was start. Loop advanced it.
        // Actually, the problem defines j as the start of part 3.
        // But our i2 is advancing through part 2.

        // Let's re-verify return values.
        // i1-1 is the index of the last element of Part 1. So i = i1 - 1.
        // The second part starts at i1.
        // The third part starts at... wait.
        // i2 was incremented. It is now at the start of Part 3? Not necessarily.
        // i2 is at the index after the end of the matching block of Part 2.
        // The third part starts where?
        // Actually, matching the *suffix* of the array means we matched the 1s and
        // trailing 0s.
        // Any zeros *between* Part 1 and Part 2 must belong to Part 2 (leading zeros)
        // or Part 1 (trailing zeros).
        // BUT, since we matched trailing zeros of Part 3, Part 1 must have exhausted
        // its trailing zeros.
        // So i1-1 is indeed the end of Part 1.
        // And i2-1 is the end of Part 2. So Part 3 starts at i2? No.
        // Part 2 ends at i2 - 1. So Part 3 starts at i2?
        // Let's trace.
        // i3 went from start_of_part3 to end.
        // i2 went from start_of_part2 to end_of_part2 + 1.
        // So Part 2 is [start_of_part2, i2-1].
        // Part 3 is [start_of_part3, end].
        // The return value j is the index where Part 3 starts.
        // But i2 might not be the start of Part 3. There could be leading zeros in Part
        // 3?
        // No, Part 3 includes everything from j to end.
        // The logic `while (i3 < arr.length)` means we matched exact length.
        // The gap between end of Part 1 and start of Part 2 (leading zeros of P2) is
        // allowed? Yes.
        // The gap between end of Part 2 and start of Part 3 (leading zeros of P3) is
        // allowed? Yes.
        // However, we just verified that P1, P2, P3 have the same value.
        // Value includes trailing zeros.
        // Effectively, `i` = i1 - 1.
        // `j` = i2 (the start of the matching block for Part 2? No, i2 advanced).
        // Wait, i2 from the loop is the index AFTER Part 2's matching block.
        // The start of Part 3 is determined by the original logic.
        // Actually, a valid split means P1 = P2 = P3.
        // P3 is fixed as `arr[current_i3...end]`.
        // P1 ends at `i1-1`.
        // P2 ends at `i2-1`.
        // Is `j` = `i2`?
        // If we return `[i1-1, i2]`, then P3 starts at `i2`.
        // Does P3 start at `i2`? `i2` is the index after P2.
        // This implies P2 and P3 are adjacent? Yes, j is the start of P3.
        // But the loop advanced `i2`.
        // Let's check Example 1: [1,0,1,0,1]. Ones=3. k=1.
        // i1=0 (val 1). i2=2 (val 1). i3=4 (val 1).
        // Loop:
        // 1. arr[0]==arr[2]==arr[4]=1. i1=1, i2=3, i3=5.
        // Loop ends.
        // Ret [0, 3].
        // P1: arr[0..0] = [1].
        // P2: arr[1..2] = [0,1]. (Val 1).
        // P3: arr[3..4] = [0,1]. (Val 1).
        // Correct.
        // So `j` should be `i2`?
        // But wait, in the example output is [0,3]. i2 became 3. So yes, j = i2.

        // One check: i1 <= start of P2?
        // i1-1 needs to be < j.
        // i1-1 < i2. Since i1 started < i2, and they incremented equally, yes.
        // But we need to ensure partitions are non-empty and well formed.
        // The logic guarantees matching non-empty parts unless k=0 handled separately.

        return new int[] { i1 - 1, i2 };
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] r1 = sol.threeEqualParts(new int[] { 1, 0, 1, 0, 1 });
        System.out.println("Result: [" + r1[0] + ", " + r1[1] + "]"); // [0, 3]

        int[] r2 = sol.threeEqualParts(new int[] { 1, 1, 0, 1, 1 });
        System.out.println("Result: [" + r2[0] + ", " + r2[1] + "]"); // [-1, -1]

        int[] r3 = sol.threeEqualParts(new int[] { 1, 1, 0, 0, 1 });
        System.out.println("Result: [" + r3[0] + ", " + r3[1] + "]"); // [0, 2]
    }
}
