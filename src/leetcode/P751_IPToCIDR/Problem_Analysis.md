# 751. IP to CIDR / IP sang CIDR

## Problem Description / Mô tả bài toán
An IP address is a 32-bit integer. It can be represented in dotted-decimal notation: `x.x.x.x`.
Địa chỉ IP là một số nguyên 32 bit. Nó có thể được biểu diễn dưới dạng ký hiệu thập phân có dấu chấm: `x.x.x.x`.

A CIDR block is an IP address followed by a slash and a number `n`. For example, `255.0.0.8/24`. The number `n` represents the number of bits that are fixed (the prefix).
Khối CIDR là một địa chỉ IP theo sau bởi một dấu gạch chéo và một số `n`. Ví dụ: `255.0.0.8/24`. Số `n` đại diện cho số bit cố định (tiền tố).

Given an IP address `ip` and a number `n`, return the shortest list of CIDR blocks that cover exactly `n` IP addresses starting from `ip`.
Cho một địa chỉ IP `ip` và một số `n`, hãy trả về danh sách ngắn nhất các khối CIDR bao phủ chính xác `n` địa chỉ IP bắt đầu từ `ip`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Bit Manipulation / Thao tác Bit
To find the largest CIDR block starting at a specific IP:
1. Count the number of trailing zeros in the IP address.
Để tìm khối CIDR lớn nhất bắt đầu tại một IP cụ thể: Đếm số bit 0 ở cuối trong địa chỉ IP.
2. The maximum number of IP addresses covered starting from `ip` is `2^trailing_zeros`.
Số lượng địa chỉ IP tối đa được bao phủ bắt đầu từ `ip` là `2^trailing_zeros`.
3. Also restricted by the remaining target count `n`.

Algorithm:
- Convert IP to long.
- While `n > 0`:
  - `step = ip & -ip` (finds the lowest bit set - power of 2).
  - While `step > n`, `step /= 2`.
  - Convert `ip` back to string, append `/mask`, add to result.
  - `ip += step`, `n -= step`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is small (number of CIDR blocks).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Greedy Power of 2
Always take the largest power of 2 possible that starts at the current IP and is less than or equal to the remaining count. Use bitwise `ip & -ip` to find the trailing zero alignment.
Luôn lấy lũy thừa của 2 lớn nhất có thể bắt đầu tại IP hiện tại và nhỏ hơn hoặc bằng số lượng còn lại. Sử dụng phép toán bitwise `ip & -ip` để tìm căn chỉnh số 0 ở cuối.

---
