package leetcode.P1265_PrintImmutableLinkedListInReverse;

interface ImmutableListNode {
    public void printValue(); // print the value of this node.

    public ImmutableListNode getNext(); // return the next node.
}

class Solution {
    public void printLinkedListInReverse(ImmutableListNode head) {
        if (head == null)
            return;
        printLinkedListInReverse(head.getNext());
        head.printValue();
    }
}
