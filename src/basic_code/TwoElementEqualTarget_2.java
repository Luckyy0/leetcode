package basic_code;

import java.util.HashMap;
import java.util.Map;

public class TwoElementEqualTarget_2 {
    // Tạo 1 hashMap có key là số thứ 2 cần tìm và value là chỉ số của số thứ nhất
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int ele1 = nums[i];
            if (map.containsKey(ele1)) {
                return new int[] { map.get(ele1), i};
            } else {
                int ele2 = target - ele1;
                map.put(ele2, i);
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 7, 11, 15 };
        int target = 9;
        System.out.println(twoSum(nums, target)[0] + " " + twoSum(nums, target)[1]);
    }
}
