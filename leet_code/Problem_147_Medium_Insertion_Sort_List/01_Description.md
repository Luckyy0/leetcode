# Result for Insertion Sort List
# *Kết quả cho bài toán Sắp xếp danh sách bằng phương pháp chèn*

## Description
## *Mô tả*

Given the `head` of a singly linked list, sort the list using **insertion sort**, and return *the sorted list's head*.
*Cho `head` của một danh sách liên kết đơn, hãy sắp xếp danh sách bằng phương pháp **sắp xếp chèn (insertion sort)**, và trả về *đầu của danh sách đã sắp xếp***.*

The steps of the insertion sort algorithm:
*Các bước của thuật toán sắp xếp chèn:*

1.  Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
    *Sắp xếp chèn lặp lại, tiêu thụ một phần tử đầu vào sau mỗi lần lặp và tăng dần danh sách đầu ra đã được sắp xếp.*
2.  At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
    *Tại mỗi lần lặp, sắp xếp chèn loại bỏ một phần tử khỏi dữ liệu đầu vào, tìm vị trí mà nó thuộc về trong danh sách đã sắp xếp và chèn nó vào đó.*
3.  It repeats until no input elements remain.
    *Nó lặp lại cho đến khi không còn phần tử đầu vào nào.*

## Example 1:
## *Ví dụ 1:*

**Input:** `head = [4,2,1,3]`
**Output:** `[1,2,3,4]`

## Example 2:
## *Ví dụ 2:*

**Input:** `head = [-1,5,3,4,0]`
**Output:** `[-1,0,3,4,5]`

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the list is in the range `[1, 5000]`.
*   `-5000 <= Node.val <= 5000`
