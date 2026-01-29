# 642. Design Search Autocomplete System / Thiết Kế Hệ Thống Tự Động Hoàn Thành Tìm Kiếm

## Problem Description / Mô tả bài toán
Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with a special character '#').
Thiết kế hệ thống tự động hoàn thành tìm kiếm cho công cụ tìm kiếm. Người dùng có thể nhập một câu (ít nhất một từ và kết thúc bằng ký tự đặc biệt '#').

For each character they type except '#', you need to return the **top 3** historical hot sentences that have prefix the same as the part of sentence already typed. Here are the specific rules:
1. The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
2. The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). If several sentences have the same degree of hot, you need to use ASCII-code order (smaller one appears first).
3. If less than 3 hot sentences exist, then just return as many as you can.
4. When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.
5. Your job is to implement the following functions:
   - `AutocompleteSystem(String[] sentences, int[] times)`: This is the constructor.
   - `List<String> input(char c)`: This function is used to gather the user's input.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Trie with Hot Data / Trie với Dữ Liệu Nóng
Store sentences in a Trie.
Each Trie node can store:
1. A map of children chars.
2. A list of "hot sentences" passing through this node?
   Or traverse the subtree to find all sentences, then sort.
   Since we need real-time suggestions, traversing the whole subtree from current prefix might be slow if the tree is deep/dense.
   Optimization: Store top 3 sentences at EACH node.
   - When updating a sentence frequency: update the count, then traverse the path in Trie again and update the "Top 3" list at each node.
   - When typing `c`, move to child node, return stored list.
   
Data Structures:
- TrieNode: `Map<Character, TrieNode> children`, `Map<String, Integer> counts` (or just `counts` at leaf?), `List<String> top3`.
- Global Map: `Map<String, Integer>` to store counts of all sentences.
- `currNode`: Pointer to current trie node based on user input buffer.
- `currSentence`: Buffer for current typing.

Rules:
- '#' ends input. Update frequency of `currSentence`. Reset `currNode` to root. Reset buffer.
- Other char: append to buffer. Move `currNode`. Return `currNode.top3`.

### Complexity / Độ phức tạp
- **Time**: `input(c)`: O(1) if cached. Update: O(L * 3 log 3) or similar (L is sentence length).
- **Space**: O(N * L) where N is number of sentences.

---

## Analysis / Phân tích

### Approach: Trie with Cached Results

**Algorithm**:
1.  Build Trie from initial data.
2.  Store top 3 hot sentences in each node.
3.  On input:
    - If '#': Update frequency map and Trie nodes. Reset state.
    - Else: Navigate Trie. Return cached list.

---
