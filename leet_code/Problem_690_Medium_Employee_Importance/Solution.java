package leet_code.Problem_690_Medium_Employee_Importance;

import java.util.*;

/**
 * Definition for Employee.
 */
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

public class Solution {

    private Map<Integer, Employee> employeeMap;

    /**
     * Calculates total importance of an employee and all their subordinates.
     * Strategy: Store in Map for easy access and perform recursive DFS.
     * Time: O(N), Space: O(N).
     */
    public int getImportance(List<Employee> employees, int id) {
        employeeMap = new HashMap<>();

        // Populate map for O(1) lookup
        for (Employee e : employees) {
            employeeMap.put(e.id, e);
        }

        return dfs(id);
    }

    private int dfs(int id) {
        Employee e = employeeMap.get(id);
        int total = e.importance;

        // Sum significance of each subordinate recursively
        for (int subId : e.subordinates) {
            total += dfs(subId);
        }

        return total;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        Employee e1 = new Employee();
        e1.id = 1;
        e1.importance = 5;
        e1.subordinates = Arrays.asList(2, 3);
        Employee e2 = new Employee();
        e2.id = 2;
        e2.importance = 3;
        e2.subordinates = new ArrayList<>();
        Employee e3 = new Employee();
        e3.id = 3;
        e3.importance = 3;
        e3.subordinates = new ArrayList<>();

        List<Employee> list = Arrays.asList(e1, e2, e3);
        System.out.println("Total Importance (1): " + sol.getImportance(list, 1)); // 11
    }
}
