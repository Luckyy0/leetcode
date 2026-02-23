package Problem_1054_Medium_Distant_Barcodes;

import java.util.HashMap;
import java.util.Map;

/**
 * 1054. Distant Barcodes
 * 
 * In a warehouse, there is a row of barcodes, where the ith barcode is
 * barcodes[i].
 * Rearrange the barcodes so that no two adjacent barcodes are equal.
 * You may return any answer, and it is guaranteed an answer exists.
 */
public class Solution {

    /**
     * Thuật toán: Sắp Xếp Tham Lam Rải Chéo (Greedy Even/Odd Indexed Placement).
     * Để các phần tử giống nhau không đứng cạnh nhau, chiến lược khôn ngoan nhất
     * là:
     * - Rải thằng có số lượng ĐÔNG NHẤT vào các ô Chẵn (để cách li chúng ra).
     * - Khi hết vòng Chẵn thì lấp tiếp vào vòng Lẻ (đảm bảo chúng không chèn chân
     * lên nhau).
     * Bằng cách giải quyết Thằng Đông Nhất đầu tiên, ta loại bỏ hoàn toàn nguy cơ
     * phần hẹp còn lại không chứa nổi chúng!
     * 
     * @param barcodes Mảng chứa dãy mã vạch ban đầu
     * @return Mảng mã vạch đã qua tái cơ cấu (sắp xếp cách ly)
     */
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;

        // Bước 1: Quét mảng để gom đếm số lượng (tần suất) của từng loại mã vạch
        Map<Integer, Integer> frequencyCounter = new HashMap<>();

        int mostFrequentBarcode = 0; // Loại mã vạch đông dân nhất
        int maxFrequency = 0; // Tần suất siêu cấp nhất

        for (int barcodeElement : barcodes) {
            int count = frequencyCounter.getOrDefault(barcodeElement, 0) + 1;
            frequencyCounter.put(barcodeElement, count);

            // So sánh để ghim lại mặt "Trùm sỏ" Đông Quân Nhất Băng
            if (count > maxFrequency) {
                maxFrequency = count;
                mostFrequentBarcode = barcodeElement;
            }
        }

        int[] resultRearranged = new int[n];
        int writeIndex = 0; // Con trỏ Nhảy Vọt (Cứ cách 1 nhịp chèn 1 phát)

        // Bước 2: Tự Ái Lấy Mảnh Đất Ngon - Ưu tiên lấp "Thằng Trùm Đông Quân" Vào Lỗ
        // Chẵn Trước!
        int currentCount = frequencyCounter.get(mostFrequentBarcode);
        while (currentCount > 0) {
            resultRearranged[writeIndex] = mostFrequentBarcode;
            writeIndex += 2; // Nhảy cóc (0, 2, 4, 6...)
            currentCount--;
        }

        // Xóa Bỏ Cựu Trùm khỏi từ điển để rảnh tay xử đám tàn quân vụn vặt
        frequencyCounter.remove(mostFrequentBarcode);

        // Bước 3: Thu dọn Tàn Quân Cỏn Con
        for (Map.Entry<Integer, Integer> currentTeam : frequencyCounter.entrySet()) {
            int currentBarcodeValue = currentTeam.getKey();
            int currentTeamSize = currentTeam.getValue();

            // Nhét từng đứa một vào các khoảng hở
            while (currentTeamSize > 0) {
                // Rẽ Nhánh Va Vách: NẾU Phi tiêu nhảy Vọt Xuyên Lấp Mất Kịch Kim Rào Cuối Lớn
                // Hơn Mảng
                // -> Vòng Quay Đầu Lại Gốc! Tiến hành Lấp Toàn Bộ Bờ Khe LẺ (1, 3, 5, 7...) Mới
                // Tinh!
                if (writeIndex >= n) {
                    writeIndex = 1;
                }

                resultRearranged[writeIndex] = currentBarcodeValue;
                currentTeamSize--;
                writeIndex += 2; // Vẫn phải rải Nhảy Cóc (Đảm bảo bầy nào cũng giãn cách hết Biên Độ)
            }
        }

        return resultRearranged; // Lô Mã Vạch Xuất Xưởng an Toàn Vệ Sinh Tuyệt Đối!
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] barcodes1 = { 1, 1, 1, 2, 2, 2 };
        int[] res1 = sol.rearrangeBarcodes(barcodes1); // Expected: e.g., [2,1,2,1,2,1] or [1,2,1,2,1,2]
        System.out.println("Test 1: " + java.util.Arrays.toString(res1));

        int[] barcodes2 = { 1, 1, 1, 1, 2, 2, 3, 3 };
        int[] res2 = sol.rearrangeBarcodes(barcodes2); // Expected: e.g., [1,3,1,3,1,2,1,2]
        System.out.println("Test 2: " + java.util.Arrays.toString(res2));
    }
}
