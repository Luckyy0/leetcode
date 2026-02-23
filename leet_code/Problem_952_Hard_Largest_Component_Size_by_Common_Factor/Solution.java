package leet_code.Problem_952_Hard_Largest_Component_Size_by_Common_Factor;

import java.util.*;

/**
 * Problem 952: Largest Component Size by Common Factor
 * https://leetcode.com/problems/largest-component-size-by-common-factor/
 */
public class Solution {

    /**
     * Finds the size of the largest connected component where edges exist if GCD >
     * 1.
     * Strategy: Union-Find (DSU) on Prime Factors.
     * 
     * @param nums Array of unique integers.
     * @return Size of the largest component.
     * 
     *         Tóm tắt chiến lược:
     *         1. Hai số có GCD > 1 nghĩa là chúng chia sẻ ít nhất một thừa số
     *         nguyên tố chung.
     *         2. Ta có thể coi các thừa số nguyên tố như là "cầu nối" để liên kết
     *         các số trong mảng `nums`.
     *         3. Sử dụng Union-Find (DSU) để quản lý các tập hợp liên thông.
     *         - Kích thước của mảng cha `parent` sẽ bằng giá trị lớn nhất trong
     *         `nums` + 1 (để bao gồm tất cả các số và các thừa số có thể).
     *         4. Duyệt qua từng số `num` trong `nums`:
     *         - Phân tích `num` ra các thừa số nguyên tố.
     *         - Với mỗi thừa số nguyên tố `f` tìm được, thực hiện `union(num, f)`.
     *         Điều này nhóm `num` và tất cả các thừa số của nó vào cùng một tập
     *         hợp.
     *         Ví dụ: với số 6, ta union(6, 2) và union(6, 3). Khi đó 2, 3 và 6 sẽ
     *         thuộc cùng một tập hợp.
     *         Nếu số 15 cũng được xử lý (union(15, 3), union(15, 5)), thì qua cầu
     *         nối là 3, các số 2, 3, 5, 6, 15 sẽ thuộc cùng tập hợp.
     *         5. Sau khi xử lý xong tất cả các số, ta đếm xem mỗi thành phần liên
     *         thông chứa bao nhiêu số từ `nums`.
     *         - Sử dụng một HashMap hoặc mảng để đếm tần suất xuất hiện của mỗi
     *         "người đại diện" (root parent) của các số `num` trong `nums`.
     *         6. Trả về tần suất lớn nhất tìm được.
     */
    public int largestComponentSize(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        DSU dsu = new DSU(maxVal + 1);

        for (int num : nums) {
            int temp = num;
            // Prime factorization up to sqrt(num)
            for (int f = 2; f * f <= temp; f++) {
                if (temp % f == 0) {
                    dsu.union(num, f);
                    while (temp % f == 0) {
                        temp /= f;
                    }
                }
            }
            // If temp > 1, the remaining part is a prime factor
            if (temp > 1) {
                dsu.union(num, temp);
            }
        }

        // Count the size of each component for the numbers present in nums
        Map<Integer, Integer> componentSize = new HashMap<>();
        int maxSize = 0;

        for (int num : nums) {
            int root = dsu.find(num);
            int currentSize = componentSize.getOrDefault(root, 0) + 1;
            componentSize.put(root, currentSize);
            maxSize = Math.max(maxSize, currentSize);
        }

        return maxSize;
    }

    // Disjoint Set Union (DSU) helper class
    class DSU {
        int[] parent;

        public DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] n1 = { 4, 6, 15, 35 };
        System.out.println("Result: " + sol.largestComponentSize(n1)); // 4

        int[] n2 = { 20, 50, 9, 63 };
        System.out.println("Result: " + sol.largestComponentSize(n2)); // 2

        int[] n3 = { 2, 3, 6, 7, 4, 12, 21, 39 };
        System.out.println("Result: " + sol.largestComponentSize(n3)); // 8
    }
}
