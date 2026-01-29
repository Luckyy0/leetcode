# 1025. Divisor Game / Trò chơi Ước số

## Problem Description / Mô tả bài toán
Alice and Bob take turns playing a game, with Alice starting first.
Alice và Bob lần lượt chơi một trò chơi, Alice đi trước.
Initially, there is a number `n` on the chalkboard.
Ban đầu, có một số `n` trên bảng.

On each player's turn, that player makes a move consisting of:
- Choosing any `x` with `0 < x < n` and `n % x == 0`.
- Replacing the number `n` on the chalkboard with `n - x`.

The player who cannot make a move loses. Return `true` if Alice wins, assuming optimal play.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Mathematical Induction / Quy nạp Toán học
- Let's assume current number is `N`.
- Only divisors of `N` are allowed.
- Since `0 < x < N`, we must subtract a proper divisor.

Base cases:
- N = 1: Divisors none. Lose. (False)
- N = 2: Divisor 1. Replace with 2-1 = 1. Opponent gets 1 (Lose). Win. (True)
- N = 3: Divisor 1. Replace with 2. Opponent gets 2 (Win). Lose. (False)
- N = 4: Divisors 1, 2. Choose 1 -> 3. Opponent gets 3 (Lose). Win. (True)

Pattern:
- Even N: Can verify Alice wins.
- Odd N: Can verify Alice loses.

Proof:
If N is even, Alice can choose 1 (1 adds to odd number to make even, subtracts from even to make odd). N becomes N-1 (ODD). Opponent gets ODD.
If N is odd, divisors of odd numbers are always odd. Odd - Odd = Even. Opponent gets EVEN.

So if starting N is even, Alice gives Odd to Bob. Bob must return Even to Alice.
If starting N is odd, Alice gives Even to Bob. Bob can return Odd to Alice.

Conclusion: Return `n % 2 == 0`.

### Complexity / Độ phức tạp
- **Time**: O(1).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Parity Game
Analyze the state transitions based on number parity. An even number allows a transition to an odd state (by subtracting 1), while an odd number forces a transition to an even state (since all factors are odd). By maintaining "control" of the even numbers, a player can force the opponent into the losing odd-number trap eventually reaching 1.
Phân tích các chuyển đổi trạng thái dựa trên tính chẵn lẻ của số. Số chẵn cho phép chuyển đổi sang trạng thái lẻ (bằng cách trừ 1), trong khi số lẻ buộc phải chuyển sang trạng thái chẵn (vì tất cả các thừa số đều là số lẻ). Bằng cách duy trì "quyền kiểm soát" các số chẵn, người chơi có thể buộc đối thủ rơi vào bẫy số lẻ thua cuộc và cuối cùng đạt đến 1.

---
