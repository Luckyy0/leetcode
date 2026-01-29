package leetcode.P1507_ReformatDate;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String reformatDate(String date) {
        String[] parts = date.split(" ");
        String dayStr = parts[0];
        String monthStr = parts[1];
        String yearStr = parts[2];

        // Month map
        Map<String, String> months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");

        // Parse Day
        StringBuilder sbDay = new StringBuilder();
        for (char c : dayStr.toCharArray()) {
            if (Character.isDigit(c)) {
                sbDay.append(c);
            }
        }
        String d = sbDay.toString();
        if (d.length() == 1)
            d = "0" + d;

        return yearStr + "-" + months.get(monthStr) + "-" + d;
    }
}
