package leet_code.Problem_726_Hard_Number_of_Atoms;

import java.util.*;

public class Solution {

    /**
     * Parses a chemical formula and returns atom counts in a sorted string.
     * Strategy: Stack of TreeMaps to handle nested parentheses and multipliers.
     * Time: O(N^2) worst case, Space: O(N).
     */
    public String countOfAtoms(String formula) {
        int n = formula.length();
        Stack<TreeMap<String, Integer>> stack = new Stack<>();
        stack.push(new TreeMap<>());

        int i = 0;
        while (i < n) {
            char c = formula.charAt(i);

            if (c == '(') {
                // Start a new scope
                stack.push(new TreeMap<>());
                i++;
            } else if (c == ')') {
                // Close current scope
                TreeMap<String, Integer> currentMap = stack.pop();
                i++;

                // Read multiplier
                int start = i;
                while (i < n && Character.isDigit(formula.charAt(i)))
                    i++;
                int multiplier = (start == i) ? 1 : Integer.parseInt(formula.substring(start, i));

                // Merge into the scope above
                TreeMap<String, Integer> parentMap = stack.peek();
                for (String atom : currentMap.keySet()) {
                    int count = currentMap.get(atom);
                    parentMap.put(atom, parentMap.getOrDefault(atom, 0) + count * multiplier);
                }
            } else {
                // Parse Atom Name
                int start = i;
                i++; // First char is Uppercase
                while (i < n && Character.isLowerCase(formula.charAt(i)))
                    i++;
                String atom = formula.substring(start, i);

                // Parse Atom Count
                start = i;
                while (i < n && Character.isDigit(formula.charAt(i)))
                    i++;
                int count = (start == i) ? 1 : Integer.parseInt(formula.substring(start, i));

                // Add to current scope
                TreeMap<String, Integer> currentMap = stack.peek();
                currentMap.put(atom, currentMap.getOrDefault(atom, 0) + count);
            }
        }

        // Generate final string from the global map
        StringBuilder sb = new StringBuilder();
        TreeMap<String, Integer> finalMap = stack.pop();
        for (String atom : finalMap.keySet()) {
            sb.append(atom);
            int count = finalMap.get(atom);
            if (count > 1)
                sb.append(count);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countOfAtoms("H2O")); // H2O
        System.out.println(sol.countOfAtoms("Mg(OH)2")); // H2MgO2
        System.out.println(sol.countOfAtoms("K4(ON(SO3)2)2")); // K4N2O14S4
    }
}
