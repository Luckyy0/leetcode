package leetcode.P800_SimilarRGBColor;

class Solution {
    public String similarRGB(String color) {
        StringBuilder sb = new StringBuilder("#");
        for (int i = 1; i < 7; i += 2) {
            sb.append(findBest(color.substring(i, i + 2)));
        }
        return sb.toString();
    }

    private String findBest(String hex) {
        int val = Integer.parseInt(hex, 16);
        // Find nearest multiple of 17
        int best = Math.round(val / 17.0f);
        return String.format("%x%x", best, best);
    }
}
