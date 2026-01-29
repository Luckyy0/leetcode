package leetcode.P667_BeautifulArrangementII;

class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int left = 1, right = n;

        // Generate k distinct differences by alternating
        // Tạo k sự khác biệt riêng biệt bằng cách xen kẽ
        for (int i = 0; i < k; i++) {
            if (i % 2 == 0)
                res[i] = left++;
            else
                res[i] = right--;
        }

        // Fill the rest in a way that generates 1 difference
        // Điền phần còn lại theo cách tạo ra 1 sự khác biệt
        if (k % 2 == 0) {
            // Last was picking from 'right', so we need to continue descending
            for (int i = k; i < n; i++)
                res[i] = right--;
        } else {
            // Last was picking from 'right' (if k=1, i=0 was left, next is right)
            // Wait, logic check: i=0 (left=1), i=1 (right=n)...
            // If k=2: i=0 (1), i=1 (n). Then i=2 should be n-1, n-2...
            for (int i = k; i < n; i++)
                res[i] = right--;
        }

        return res;
    }
}
