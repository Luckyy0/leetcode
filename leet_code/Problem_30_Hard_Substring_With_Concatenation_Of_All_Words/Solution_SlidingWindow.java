package leet_code.Problem_30_Hard_Substring_With_Concatenation_Of_All_Words;

public class Solution_SlidingWindow {

    // Custom List for results
    // Danh sách tùy chỉnh cho kết quả
    static class MyArrayList<T> {
        Object[] elements;
        int size;

        public MyArrayList() {
            elements = new Object[10];
            size = 0;
        }

        public void add(T e) {
            if (size == elements.length) {
                Object[] newE = new Object[elements.length * 2];
                System.arraycopy(elements, 0, newE, 0, size);
                elements = newE;
            }
            elements[size++] = e;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < size; i++) {
                sb.append(elements[i]);
                if (i < size - 1)
                    sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }
    }

    // Custom HashMap for String -> Integer
    // HashMap tùy chỉnh cho String -> Integer
    static class MyHashMap {
        static class Node {
            String key;
            int value;
            Node next;

            Node(String k, int v) {
                key = k;
                value = v;
            }
        }

        Node[] buckets;
        int size;

        public MyHashMap() {
            buckets = new Node[100]; // Small bucket size for demo, ideally larger
            size = 0;
        }

        private int getBucketIndex(String key) {
            return Math.abs(key.hashCode()) % buckets.length;
        }

        public int getOrDefault(String key, int defaultValue) {
            int idx = getBucketIndex(key);
            Node curr = buckets[idx];
            while (curr != null) {
                if (curr.key.equals(key))
                    return curr.value;
                curr = curr.next;
            }
            return defaultValue;
        }

        public void put(String key, int value) {
            int idx = getBucketIndex(key);
            Node curr = buckets[idx];
            while (curr != null) {
                if (curr.key.equals(key)) {
                    curr.value = value;
                    return;
                }
                curr = curr.next;
            }
            Node newNode = new Node(key, value);
            newNode.next = buckets[idx];
            buckets[idx] = newNode;
            size++;
        }

        public void clear() {
            for (int i = 0; i < buckets.length; i++)
                buckets[i] = null;
            size = 0;
        }
    }

    /**
     * Finds starting indices of concatenated substrings.
     * Uses Sliding Window optimization.
     * Tìm các chỉ số bắt đầu của các chuỗi con nối ghép.
     * Sử dụng tối ưu hóa Cửa sổ trượt.
     */
    public MyArrayList<Integer> findSubstring(String s, String[] words) {
        MyArrayList<Integer> result = new MyArrayList<>();
        if (s == null || words == null || words.length == 0)
            return result;

        int wordLen = words[0].length();
        int numWords = words.length;
        int totalLen = wordLen * numWords;
        int sLen = s.length();

        if (sLen < totalLen)
            return result;

        // Count frequency of words
        // Đếm tần suất của các từ
        MyHashMap counts = new MyHashMap();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        // Iterate through each offset
        // Duyệt qua từng độ lệch
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int right = i;
            MyHashMap currentCounts = new MyHashMap();
            int count = 0;

            while (right + wordLen <= sLen) {
                String word = s.substring(right, right + wordLen);
                right += wordLen; // Move right

                // Check if word is valid
                if (counts.getOrDefault(word, 0) > 0) {
                    currentCounts.put(word, currentCounts.getOrDefault(word, 0) + 1);
                    count++;

                    // If more than expected, shrink from left
                    // Nếu nhiều hơn mong đợi, thu hẹp từ bên trái
                    while (currentCounts.getOrDefault(word, 0) > counts.getOrDefault(word, 0)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currentCounts.put(leftWord, currentCounts.getOrDefault(leftWord, 0) - 1);
                        count--;
                        left += wordLen;
                    }

                    // Check if window matches
                    // Kiểm tra xem cửa sổ có khớp không
                    if (count == numWords) {
                        result.add(left);
                    }
                } else {
                    // Invalid word, reset
                    // Từ không hợp lệ, đặt lại
                    currentCounts.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_SlidingWindow solution = new Solution_SlidingWindow();

        // Test Case 1
        String s1 = "barfoothefoobarman";
        String[] w1 = { "foo", "bar" };
        System.out.println("Test Case 1: " + solution.findSubstring(s1, w1));
        // Expected: [0, 9] (order may vary)

        // Test Case 2
        String s2 = "wordgoodgoodgoodbestword";
        String[] w2 = { "word", "good", "best", "word" };
        System.out.println("Test Case 2: " + solution.findSubstring(s2, w2));
        // Expected: []

        // Test Case 3
        String s3 = "barfoofoobarthefoobarman";
        String[] w3 = { "bar", "foo", "the" };
        System.out.println("Test Case 3: " + solution.findSubstring(s3, w3));
        // Expected: [6, 9, 12]
    }
}
