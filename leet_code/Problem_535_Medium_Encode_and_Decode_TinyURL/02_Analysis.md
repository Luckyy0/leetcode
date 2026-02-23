# Analysis for Encode and Decode TinyURL
# *Phân tích cho bài toán Mã hóa và Giải mã TinyURL*

## 1. Problem Essence & Mapping
## *1. Bản chất vấn đề & Ánh xạ*

### The Challenge
### *Thách thức*
Mapping Arbitrary String -> Short Key -> Arbitrary String.
- Must result in valid URL format (usually `http://tinyurl.com/KEY`).
- Must handle duplicates (same long URL can map to same or different short URL, usually same saves space but different is easier).
- Must avoid collisions.

### Strategy: HashMap with Auto-Increment or Random Key
### *Chiến lược: HashMap với Khóa Tự tăng hoặc Ngẫu nhiên*

1.  **Storage:** `HashMap<String, String>` where Key = ShortKey, Value = LongURL.
2.  **Key Generation:**
    - **Simple Counter:** `0, 1, 2...` encoded in Base62 (0-9, a-z, A-Z).
    - **Random:** Generate 6 random chars. Check collision. If exists, regenerate.
    - **Hash:** MD5/SHA parts.

---

## 2. Approach: Random Hash
## *2. Hướng tiếp cận: Hash Ngẫu nhiên*

### Logic
### *Logic*
`Map<String, String> db`.
`encode(longUrl)`:
- Generate 6-char random key.
- If key in `db`, retry.
- `db.put(key, longUrl)`.
- Return `http://tinyurl.com/` + key.

`decode(shortUrl)`:
- Extract key.
- Return `db.get(key)`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Simplicity:** Easy to implement.
    *Đơn giản: Dễ triển khai.*
*   **Security:** Random keys are harder to predict than incremental.
    *Bảo mật: Khóa ngẫu nhiên khó dự đoán hơn khóa tăng dần.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ on average.
    *Độ phức tạp thời gian: $O(1)$ trung bình.*
*   **Space Complexity:** $O(N \cdot L)$.
    *Độ phức tạp không gian: $O(N \cdot L)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `.../design-tinyurl`
1. Gen key `AbCdEf`.
2. Map `AbCdEf -> ...`.
3. Ret `http://.../AbCdEf`.
4. Decode: Look up `AbCdEf`. Ret long URL.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Use HashMap with Random/Counter Key generation.
*Sử dụng HashMap với việc tạo Khóa Ngẫu nhiên/Tăng dần.*
---
*Cái tên (URL) chỉ là danh xưng. Bản chất (content) mới là điều quan trọng. Bằng cách gán cho mỗi thực thể một mã định danh ngắn gọn (TinyURL), ta giúp việc truyền tải (sharing) trở nên nhẹ nhàng hơn mà không làm thay đổi giá trị cốt lõi bên trong.*
The name (URL) is just the title. The essence (Content) is what matters. By assigning each entity a concise identifier (TinyURL), we make transmission (Sharing) lighter without changing the core value inside.
