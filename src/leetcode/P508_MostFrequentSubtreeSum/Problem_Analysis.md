# 508. Most Frequent Subtree Sum / Tổng Cây Con Xuất Hiện Nhiều Nhất

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, return the most frequent subtree sum. If there is a tie, return all the values with the highest frequency in any order.
Cho `root` của một cây nhị phân, hãy trả về tổng cây con xuất hiện thường xuyên nhất. Nếu có sự trùng lặp về tần suất, hãy trả về tất cả các giá trị có tần suất cao nhất theo bất kỳ thứ tự nào.

The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).
Tổng cây con của một nút được định nghĩa là tổng của tất cả các giá trị của các nút trong cây con có gốc tại nút đó (bao gồm cả chính nút đó).

### Example 1:
```text
Input: root = [5,2,-3]
Output: [2,-3,4]
```

### Example 2:
```text
Input: root = [5,2,-5]
Output: [2]
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[1, 10^4]`.
- `-10^5 <= Node.val <= 10^5`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Recursive Subtree Summation / Tính tổng cây con đệ quy
The sum of a subtree rooted at `node` is `node.val + sum(node.left) + sum(node.right)`.
We can use Post-order traversal (bottom-up) to compute the sum of every subtree.

Algorithm:
1. Use a `HashMap<Integer, Integer>` to store the frequency of each subtree sum.
2. Define a recursive function `calculateSum(node)`:
   - If `node == null`, return 0.
   - `leftSum = calculateSum(node.left)`.
   - `rightSum = calculateSum(node.right)`.
   - `totalSum = node.val + leftSum + rightSum`.
   - Increment `map[totalSum]`.
   - Update `maxFrequency = max(maxFrequency, map[totalSum])`.
   - Return `totalSum`.
3. After traversal, collect all sums from the map that have frequency equal to `maxFrequency`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the number of nodes.
- **Space**: O(N) to store the sums in the map.

---

## Analysis / Phân tích

### Approach: Post-Order Frequency Mapping

**Algorithm**:
1.  Recursively compute subtree sums.
2.  Store results in a frequency map.
3.  Track global maximum frequency.
4.  Filter and return modes.

---
