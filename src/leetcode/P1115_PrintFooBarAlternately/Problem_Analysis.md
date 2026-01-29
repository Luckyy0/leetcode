# 1115. Print FooBar Alternately / In FooBar Xen kẽ

## Problem Description / Mô tả bài toán
Two threads `A` (foo) and `B` (bar) are running.
A calls `foo` n times.
B calls `bar` n times.
Ensure output is "foobarfoobar...".
Đảm bảo đầu ra là "foobarfoobar...".

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Concurrency / Semaphores / Đồng thời / Semaphores
A starts first.
Semaphore `sFoo` (init 1), `sBar` (init 0).
Loop n times:
- `foo`: `sFoo.acquire()`, print, `sBar.release()`.
- `bar`: `sBar.acquire()`, print, `sFoo.release()`.

---
