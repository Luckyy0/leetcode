package leetcode.P665_NondecreasingArray;

class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (count > 1)
                    return false;

                // If the violation happens at the start or can be fixed by lowering nums[i]
                // Nếu vi phạm xảy ra ở đầu hoặc có thể được sửa bằng cách hạ thấp nums[i]
                if (i == 0 || nums[i - 1] <= nums[i + 1]) {
                    nums[i] = nums[i + 1];
                }
                // We must raise nums[i+1] to match nums[i]
                // Chúng ta phải tăng nums[i+1] để khớp với nums[i]
                else {
                    nums[i + 1] = nums[i];
                }
            }
        }
        return true;
    }
}
