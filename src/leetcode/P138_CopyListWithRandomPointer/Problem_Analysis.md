# 138. Copy List with Random Pointer / Sao Chép Danh Sách Với Con Trỏ Ngẫu Nhiên

## Problem Description / Mô tả bài toán
A linked list of length `n` is given such that each node contains an additional random pointer, which could point to any node in the list, or `null`.
Một danh sách liên kết có độ dài `n` được đưa ra sao cho mỗi nút chứa một con trỏ ngẫu nhiên bổ sung, có thể trỏ đến bất kỳ nút nào trong danh sách, hoặc `null`.

Construct a **deep copy** of the list.
Xây dựng một **bản sao sâu** của danh sách.

```java
class Node {
    int val;
    Node next;
    Node random;
}
```

## Constraints / Ràng buộc
- `0 <= n <= 1000`
- `-10^4 <= Node.val <= 10^4`
- `Node.random` is `null` or is pointing to some node in the linked list.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Deep Copying Graphs/Lists / Sao chép Sâu Đồ thị/Danh sách
Like Problem 133 (Clone Graph), the challenge is correctly mapping original nodes to their copies so that the `random` pointers point to the correct cloned instances.
Giống như bài toán 133 (Clone Graph), thách thức là ánh xạ chính xác các nút gốc sang các bản sao của chúng sao cho các con trỏ `random` trỏ đến đúng các phiên bản đã được sao chép.

### Strategies / Chiến lược

#### 1. HashMap Approach / Tiếp cận bằng HashMap
- Use a `Map<Node, Node>` to store `original -> copy`.
- First pass: create all copy nodes and store them in the map.
- Second pass: link `next` and `random` pointers using the map.
- **Space**: O(N).

#### 2. Interweaving Approach / Tiếp cận bằng Cách Đan Xen
- **Step 1**: Create a copy of each node and insert it directly after the original node (`A -> A' -> B -> B' -> ...`).
- **Step 2**: Set `random` pointers: `A'.random = A.random.next` (if `A.random` exists).
- **Step 3**: Separate the interweaved list into the original and the clone.
- **Space**: O(1) (excluding the cloned list output).

---

## Analysis / Phân tích

### Approach: Interweaving (O(1) Extra Space) / Cách Đan Xen (Không gian Bổ sung O(1))

**Algorithm**:
1.  **Iterate and Copy**: Create `curr.next = new Node(curr.val, curr.next)`.
2.  **Assign Random**: `curr.next.random = (curr.random != null) ? curr.random.next : null`.
3.  **Restore and Separate**: Unlink the original nodes from the clones.

**Complexity / Độ phức tạp**:
- **Time**: O(N) - 3 passes over the list.
- **Space**: O(1) - if we don't count the returned copy list.

---

## Edge Cases / Các trường hợp biên
1.  **Empty List**: Return `null`.
2.  **Circular Random Pointers**: Handled correctly as copying happens node by node.
3.  **Random pointer to self**: Handled correctly.
4.  **All Random pointers are null**: Handled correctly.
