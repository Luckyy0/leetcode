package leetcode.P1634_AddTwoPolynomialsRepresentedAsLinkedLists;

class PolyNode {
    int coefficient, power;
    PolyNode next;

    PolyNode() {
    }

    PolyNode(int x, int y) {
        this.coefficient = x;
        this.power = y;
    }

    PolyNode(int x, int y, PolyNode next) {
        this.coefficient = x;
        this.power = y;
        this.next = next;
    }
}

public class Solution {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode dummy = new PolyNode();
        PolyNode curr = dummy;

        PolyNode p1 = poly1;
        PolyNode p2 = poly2;

        while (p1 != null && p2 != null) {
            if (p1.power > p2.power) {
                curr.next = new PolyNode(p1.coefficient, p1.power);
                curr = curr.next;
                p1 = p1.next;
            } else if (p1.power < p2.power) {
                curr.next = new PolyNode(p2.coefficient, p2.power);
                curr = curr.next;
                p2 = p2.next;
            } else {
                int sumCoef = p1.coefficient + p2.coefficient;
                if (sumCoef != 0) {
                    curr.next = new PolyNode(sumCoef, p1.power);
                    curr = curr.next;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
        }

        while (p1 != null) {
            curr.next = new PolyNode(p1.coefficient, p1.power);
            curr = curr.next;
            p1 = p1.next;
        }

        while (p2 != null) {
            curr.next = new PolyNode(p2.coefficient, p2.power);
            curr = curr.next;
            p2 = p2.next;
        }

        return dummy.next;
    }
}
