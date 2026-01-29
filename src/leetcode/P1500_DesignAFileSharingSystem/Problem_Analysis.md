# 1500. Design a File Sharing System / Thiết kế Hệ thống Chia sẻ Tệp

## Problem Description / Mô tả bài toán
Users join/leave, request files.
Data:
- User ID allocation (reuse smallest).
- User -> List of Files owned.
`join(ownedChunks)`: Assign smallest ID. Register chunks.
`leave(userID)`: Release ID. Remove chunks.
`request(userID, chunkID)`: Return list of user IDs owning chunk (sorted). Add chunk to requester.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Priority Queue + Data Structures
`minHeap` for available User IDs. Max user count? Usually not super large constraints or implied infinite but sparse.
`chunkOwners`: Map `chunkID -> Set<userID>`. Wait, need sorted list. `TreeSet` or sort on request.
`userChunks`: Map `userID -> Set<chunkID>` (for easy adding and clearing).
When user leaves:
- Remove user from all `chunkOwners` sets.
- Return ID to heap.

### Complexity / Độ phức tạp
- **Time**: Join O(C log U), Leave O(C log U), Request O(U log U + C). `C` chunks, `U` users.
- **Space**: O(U*C).

---

## Analysis / Phân tích

### Approach: Heap and Maps
Use a Min-Heap to manage reusable user IDs.
Use `Map<Integer, Set<Integer>>` to map `chunkID` to `userIDs` owning it.
For `leave`: We need to know which chunks user has. `Map<Integer, List<Integer>> userToChunks`.
When leaving, iterate `userToChunks[userID]`, remove `userID` from `chunkToUsers`.
When requesting: Check `chunkToUsers`. Return list. Add `chunkID` to `userToChunks[requestingUser]` and `userID` to `chunkToUsers`.
Sử dụng Min-Heap để quản lý ID người dùng có thể tái sử dụng.
Sử dụng `Map<Integer, Set<Integer>>` để ánh xạ `chunkID` với `userIDs` sở hữu nó.

---
