package leetcode.P831_MaskingPersonalInformation;

class Solution {
    public String maskPII(String s) {
        if (s.contains("@")) {
            // Email masking
            s = s.toLowerCase();
            int atIdx = s.indexOf("@");
            return s.charAt(0) + "*****" + s.substring(atIdx - 1);
        } else {
            // Phone masking
            String digits = s.replaceAll("[^0-9]", "");
            String local = "***-***-" + digits.substring(digits.length() - 4);
            if (digits.length() == 10)
                return local;
            String country = "+";
            for (int i = 0; i < digits.length() - 10; i++)
                country += "*";
            return country + "-" + local;
        }
    }
}
