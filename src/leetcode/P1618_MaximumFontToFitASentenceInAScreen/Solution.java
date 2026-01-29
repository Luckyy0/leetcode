package leetcode.P1618_MaximumFontToFitASentenceInAScreen;

interface FontInfo {
    int getWidth(int fontSize, char c);

    int getHeight(int fontSize);
}

public class Solution {
    public int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
        int left = 0;
        int right = fonts.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canFit(text, w, h, fonts[mid], fontInfo)) {
                result = fonts[mid];
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private boolean canFit(String text, int w, int h, int fontSize, FontInfo fontInfo) {
        int height = fontInfo.getHeight(fontSize);
        if (height > h)
            return false;

        int lines = 1;
        int currentWidth = 0;
        int n = text.length();

        // This problem behaves slightly differently in various interpretations.
        // Assuming character-by-character flow without word breaking is typical?
        // Actually, typically "Sentence in a Screen" (P1618) implies standard word
        // wrapping.
        // But let's verify if char-by-char is allowed? Usually NOT.

        // Let's implement word wrapping using the character widths.
        // We calculate width of each character.

        // Optimization: Pre-calculate word widths? No, depend on Font.
        // Note: Spaces are characters too.

        // Let's parse words and spaces.
        // Actually, iterating chars is fine if we carefully accumulate 'wordWidth'.

        // Wait, efficient way:
        int i = 0;
        while (i < n) {
            // Find next word
            int wordWidth = 0;
            int j = i;
            while (j < n && text.charAt(j) != ' ') {
                wordWidth += fontInfo.getWidth(fontSize, text.charAt(j));
                j++;
            }

            // Check if word fits at all
            if (wordWidth > w)
                return false;

            // Check if word fits in current line
            // If currentWidth > 0, we need a space before this word if we append
            int spaceWidth = (currentWidth > 0) ? fontInfo.getWidth(fontSize, ' ') : 0;

            if (currentWidth + spaceWidth + wordWidth <= w) {
                currentWidth += spaceWidth + wordWidth;
            } else {
                // New line
                lines++;
                currentWidth = wordWidth;
            }

            if (lines * height > h)
                return false;

            // Skip the space for next iteration logic?
            i = j;
            if (i < n && text.charAt(i) == ' ') {
                i++;
            }
        }

        return lines * height <= h;
    }
}
