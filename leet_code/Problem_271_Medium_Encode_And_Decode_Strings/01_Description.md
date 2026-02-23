# Result for Encode and Decode Strings
# *Kết quả cho bài toán Mã hóa và Giải mã Chuỗi*

## Description
## *Mô tả*

Design an algorithm to encode a list of strings to a string. The encoded string is then sent to the other end of the network, where it is decoded back to the original list of strings.
*Thiết kế một thuật toán để mã hóa một danh sách các chuỗi thành một chuỗi. Chuỗi đã mã hóa sau đó được gửi đến đầu bên kia của mạng, nơi nó được giải mã trở lại thành danh sách các chuỗi ban đầu.*

Machine 1 (sender) has the function:
```java
public String encode(List<String> strs) {
  // ... your code
  return encoded_string;
}
```
Machine 2 (receiver) has the function:
```java
public List<String> decode(String s) {
  //... your code
  return strs;
}
```

So Machine 1 does:
`string encoded_string = encode(strs);`
and Machine 2 does:
`List<String> strs2 = decode(encoded_string);`
`strs2` in Machine 2 should be the same as `strs` in Machine 1.

Implement the `encode` and `decode` methods.
*Triển khai các phương thức `encode` và `decode`.*

Note:
*   The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized enough to work on any possible characters.
*   Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
*   Do not rely on any library like `eval` or serialize methods. You should implement your own encode/decode algorithm.

## Constraints:
## *Ràng buộc:*

*   `0 <= strs.length <= 200`
*   `0 <= strs[i].length <= 200`
*   `strs[i]` contains any possible characters out of 256 valid ASCII characters.
