package leetcode.P556_NextGreaterElementIII;

class Solution {
    public int nextGreaterElement(int n) {
        char[] a = String.valueOf(n).toCharArray();
        int i = a.length - 2;

        // Find first decreasing digit from the right
        // Tìm chữ số giảm dần đầu tiên từ bên phải
        while (i >= 0 && a[i] >= a[i + 1]) {
            i--;
        }

        if (i < 0)
            return -1;

        // Find smallest digit larger than a[i] to its right
        // Tìm chữ số nhỏ nhất lớn hơn a[i] ở bên phải của nó
        int j = a.length - 1;
        while (j >= 0 && a[j] <= a[i]) {
            j--;
        }

        swap(a, i, j);
        reverse(a, i + 1, a.length - 1);

        try {
            return Integer.parseInt(new String(a));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private void reverse(char[] a, int i, int j) {
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }
}
