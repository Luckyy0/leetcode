# 1121. Divide Array Into Increasing Sequences / Chia Mảng thành các Chuỗi Tăng

## Problem Description / Mô tả bài toán
Given a non-decreasing array of positive integers `nums` and an integer `K`, find whether this array can be divided into one or more disjoint increasing subsequences of length at least `K`.
Cho một mảng không giảm các số nguyên dương `nums` và một số nguyên `K`, hãy tìm xem mảng này có thể được chia thành một hoặc nhiều chuỗi con tăng rời rạc có độ dài ít nhất là `K` hay không.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Frequency Analysis / Phân tích Tần suất
If the max frequency of any number is `maxFreq`, then we need at least `maxFreq` subsequences to separate these identical numbers.
Since we have `N` total elements, if we use `maxFreq` groups, the average length is `N / maxFreq`.
We need `length >= K`.
So condition: `N >= K * maxFreq`.

Why?
We can always construct `maxFreq` increasing subsequences.
Since array is sorted, we can just distribute elements round-robin `i % maxFreq`.
This ensures duplicates are in different groups.
Since `nums` is non-decreasing, round-robin distribution maintains order.
The smallest group will have size `floor(N / maxFreq)`. We need `floor(N / maxFreq) >= K`? Or basic check `N >= K * maxFreq`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1) or O(N) for counting (but sorted, so O(1)).

---

## Analysis / Phân tích

### Approach: Frequency Constraint Check
The problem hinges on handling duplicate elements. If a number appears `M` times, we need at least `M` separate subsequences to accommodate each instance while maintaining strictly increasing order within each sequence. If we force `M` sequences, the total capacity must be at least `M * K` to satisfy the minimum length constraint. Thus, the condition is simply `ArrayLength >= MaxFrequency * K`.
Vấn đề phụ thuộc vào việc xử lý các phần tử trùng lặp. Nếu một số xuất hiện `M` lần, chúng ta cần ít nhất `M` chuỗi con riêng biệt để chứa từng trường hợp trong khi vẫn duy trì thứ tự tăng nghiêm ngặt trong mỗi chuỗi. Nếu chúng ta buộc phải có `M` chuỗi, tổng dung lượng phải ít nhất là `M * K` để thỏa mãn ràng buộc độ dài tối thiểu. Do đó, điều kiện chỉ đơn giản là `ArrayLength >= MaxFrequency * K`.

---
