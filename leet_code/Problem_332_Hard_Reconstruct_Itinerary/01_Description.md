# Result for Reconstruct Itinerary
# *Kết quả cho bài toán Tái tạo Lịch trình*

## Description
## *Mô tả*

You are given a list of airline `tickets` where `tickets[i] = [fromi, toi]` represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.
*Bạn được cho một danh sách các vé máy bay `tickets` trong đó `tickets[i] = [fromi, toi]` đại diện cho sân bay khởi hành và sân bay đến của một chuyến bay. Tái tạo lịch trình theo thứ tự và trả về nó.*

All of the tickets belong to a man who departs from `"JFK"`, thus, the itinerary must begin with `"JFK"`. If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.
*Tất cả vé đều thuộc về một người đàn ông khởi hành từ `"JFK"`, do đó, lịch trình phải bắt đầu bằng `"JFK"`. Nếu có nhiều lịch trình hợp lệ, bạn nên trả về lịch trình có thứ tự từ vựng nhỏ nhất khi đọc như một chuỗi duy nhất.*

*   For example, the itinerary `["JFK", "LGA"]` has a smaller lexical order than `["JFK", "LGB"]`.
*   *Ví dụ, lịch trình `["JFK", "LGA"]` có thứ tự từ vựng nhỏ hơn `["JFK", "LGB"]`.*

You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.
*Bạn có thể giả định rằng tất cả các vé tạo thành ít nhất một lịch trình hợp lệ. Bạn phải sử dụng tất cả các vé một lần và duy nhất một lần.*

## Example 1:
## *Ví dụ 1:*

**Input:** `tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]`
**Output:** `["JFK","MUC","LHR","SFO","SJC"]`

## Example 2:
## *Ví dụ 2:*

**Input:** `tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]`
**Output:** `["JFK","ATL","JFK","SFO","ATL","SFO"]`
**Explanation:** Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in lexical order.

## Constraints:
## *Ràng buộc:*

*   `1 <= tickets.length <= 300`
*   `tickets[i].length == 2`
*   `fromi.length == 3`
*   `toi.length == 3`
*   `fromi` and `toi` consist of uppercase English letters.
*   `fromi != toi`
