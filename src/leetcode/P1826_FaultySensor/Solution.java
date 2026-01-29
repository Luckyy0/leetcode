package leetcode.P1826_FaultySensor;

public class Solution {
    public int badSensor(int[] sensor1, int[] sensor2) {
        int n = sensor1.length;
        int i = 0;

        // Find first mismatch
        while (i < n && sensor1[i] == sensor2[i]) {
            i++;
        }

        while (i < n && sensor1[i] == sensor2[i]) {
            i++;
        }

        if (i >= n - 1)
            return -1; // No significant mismatch (only last element differs or none)

        // Check if sensor 1 could be faulty (dropped value at i, so s1[i] matches
        // s2[i+1])
        boolean s1Faulty = true;
        for (int k = i; k < n - 1; k++) {
            if (sensor1[k] != sensor2[k + 1]) {
                s1Faulty = false;
                break;
            }
        }

        // Check if sensor 2 could be faulty
        boolean s2Faulty = true;
        for (int k = i; k < n - 1; k++) {
            if (sensor2[k] != sensor1[k + 1]) {
                s2Faulty = false;
                break;
            }
        }

        if (s1Faulty && !s2Faulty)
            return 1;
        if (!s1Faulty && s2Faulty)
            return 2;
        return -1;
    }
}
