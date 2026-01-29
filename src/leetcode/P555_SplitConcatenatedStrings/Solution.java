package leetcode.P555_SplitConcatenatedStrings;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String splitLoopedString(String[] strs) {
        // Preprocess: reverse strings if lexicographically larger
        // Tiền xử lý: đảo ngược chuỗi nếu lớn hơn theo thứ tự từ điển
        for (int i = 0; i < strs.length; i++) {
            String reversed = new StringBuilder(strs[i]).reverse().toString();
            if (reversed.compareTo(strs[i]) > 0) {
                strs[i] = reversed;
            }
        }

        String res = "";

        for (int i = 0; i < strs.length; i++) {
            // Reconstruct body (all other strings)
            // Tái cấu trúc phần thân (tất cả các chuỗi khác)
            StringBuilder bodyBuilder = new StringBuilder();
            for (int k = i + 1; k < strs.length; k++)
                bodyBuilder.append(strs[k]);
            for (int k = 0; k < i; k++)
                bodyBuilder.append(strs[k]);
            String body = bodyBuilder.toString();

            // Try both original and reversed version of current string as pivot
            // Thử cả phiên bản gốc và đảo ngược của chuỗi hiện tại làm chốt
            String org = strs[i];
            String rev = new StringBuilder(org).reverse().toString();

            // Generate candidates
            List<String> pivots = new ArrayList<>();
            pivots.add(org);
            pivots.add(rev);

            for (String p : pivots) {
                for (int m = 0; m < p.length(); m++) {
                    // Split at m: p[m:] + body + p[:m]
                    // Ideally we only update res if larger
                    String cand = p.substring(m) + body + p.substring(0, m);
                    if (cand.compareTo(res) > 0) {
                        res = cand;
                    }
                }
            }
        }

        return res;
    }
}
