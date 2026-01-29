# 1114. Print in Order / In theo Thứ tự

## Problem Description / Mô tả bài toán
Specifically design a class to ensure `first()`, `second()`, and `third()` are executed in order, even if called by different threads.
Thiết kế cụ thể một lớp để đảm bảo `first()`, `second()` và `third()` được thực thi theo thứ tự, ngay cả khi được gọi bởi các luồng khác nhau.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Concurrency Primitives / Nguyên tắc Đồng thời
Use Semaphores, CountDownLatch, or AtomicInteger with busy wait (not recommended for efficiency but works).
Ideally:
- Semaphore `s2` (blocked initially).
- Semaphore `s3` (blocked initially).
- `first`: run, `s2.release()`.
- `second`: `s2.acquire()`, run, `s3.release()`.
- `third`: `s3.acquire()`, run.

### Complexity / Độ phức tạp
- **Time**: Minimal overhead.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Synchronization Barriers
Use thread synchronization primitives (AtomicInteger, CountDownLatch, or Semaphore) to enforce execution order. Method `first` signals `second` to proceed, which in turn signals `third`.
Sử dụng các nguyên tắc đồng bộ hóa luồng (AtomicInteger, CountDownLatch hoặc Semaphore) để thực thi thứ tự thực hiện. Phương thức `first` báo hiệu cho `second` tiến hành, đến lượt nó báo hiệu cho `third`.

---
