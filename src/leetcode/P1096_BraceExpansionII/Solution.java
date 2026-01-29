package leetcode.P1096_BraceExpansionII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> set = parse(expression);
        List<String> res = new ArrayList<>(set);
        Collections.sort(res);
        return res;
    }

    private Set<String> parse(String expr) {
        Set<String> res = new HashSet<>();
        // Split by outer-level commas (Union)
        // But also handle concatenation implicitly.
        // Actually, precedence: Concatenation is typically tighter, but ',' is union in
        // context of braces.
        // {A, B} means A U B.
        // A B means A x B.
        // Problem: {{a,z},a{b,c},{ab,z}} is basically {A, B, C}.
        // Inside {}, we have "expressions" separated by commas.
        // Wait, standard definition: { ... } encloses a list of options.
        // Outside braces, adjacent items concatenate.

        // Let's rely on recursion finding braces.
        // "a{b,c}" -> "a" * parse("{b,c}")

        // Better approach:
        // Use a Stack of Sets for current concatenation context.
        // When we hit ',', we finish current concatenation, add to Union set, reset
        // concatenation context.
        // When we hit '{', recurse or push stack.

        // Let's implement recursive split logic carefully.

        if (expr.indexOf('{') == -1) {
            // Base case: just a string like "abc,def" NO. commas only inside braces?
            // "a,b" is not possible at top level unless wrapped?
            // "Single letters"
            // "{A,B,C}"
            // The top level expression might contain commas if interpreted as a list?
            // LeetCode examples imply `expression` can have commas at top level if it's
            // inside implicit braces? NO.
            // Example 2: "{{a,z}, a{b,c}, {ab,z}}" -> this is valid input.
            // So top level CAN have commas.
            // In that case, top level is Union.

            // Wait, "a,b" is NOT a valid expression unless enclosed?
            // "a{b,c}" is valid.
            // "a,b" valid? Grammar says "{A,B,C}". Braces mandatory for union.
            // BUT Example 2 has commas at top level?
            // " {{a,z}, a{b,c}, {ab,z}} "
            // The input IS wrapped in braces? No.
            // Oh, the example input string is literally "{{a,z},a{b,c},{ab,z}}".
            // So if `expression` = "a,b", is it valid? "a,b" is "a" union "b"? NO.
            // Only inside braces does comma mean union.
            // Outside braces, "a,b" is likely invalid or just literal ',' if allowed (but
            // letters only).
            // Actually, looks like top level is essentially one "concatenation block"
            // unless explicit union happens?
            // No, the example 2 input is ONE big brace expression? "Expression:
            // {{a,z},a{b,c},{ab,z}}"
            // Oh, the expression ITSELF starts with '{' and ends with '}'.
            // Wait, example 1: "{a,b}{c,{d,e}}" -> Concatenation of two brace groups.
            // So top level is Concatenation of items.
            // Items can be: letter, or brace-group.

            // So we split by "outermost" boundaries?
            // {a,b}{c,d} -> group 1: {a,b}, group 2: {c,d}.
            // Concatenate(parse({a,b}), parse({c,d})).

            // Inside { ... }, we strip outer braces, then split by top-level commas ->
            // Unions.
        }

        // We will scan the string and handle operations.
        // 1. Identify "products" separated by commas (Wait, commas only inside braces).
        // 2. Actually, let's treat the whole string as a list of concatenated
        // components.
        // But commas?
        // Comma only valid inside braces.
        // So scan logic:
        // Main loop builds a list of "sets" to multiply (cross product).

        // Actually, simplest is recursion on finding first { }.
        // But we need to handle "a{b,c}d".
        // This is "a" x {b,c} x "d".

        Set<String> currentLevel = new HashSet<>();
        List<Set<String>> products = new ArrayList<>();
        products.add(new HashSet<>());
        products.get(0).add("");

        int i = 0;
        while (i < expr.length()) {
            if (expr.charAt(i) == '{') {
                int j = i;
                int balance = 0;
                while (j < expr.length()) {
                    if (expr.charAt(j) == '{')
                        balance++;
                    if (expr.charAt(j) == '}')
                        balance--;
                    if (balance == 0)
                        break;
                    j++;
                }
                // Recursive call on content inside braces
                // Split content by TOP LEVEL commas -> Unions
                Set<String> inner = new HashSet<>();
                String content = expr.substring(i + 1, j);

                // Split content by comma at level 0
                int start = 0;
                int b = 0;
                for (int k = 0; k < content.length(); k++) {
                    if (content.charAt(k) == '{')
                        b++;
                    if (content.charAt(k) == '}')
                        b--;
                    if (content.charAt(k) == ',' && b == 0) {
                        inner.addAll(parse(content.substring(start, k)));
                        start = k + 1;
                    }
                }
                inner.addAll(parse(content.substring(start)));

                // Concatenate inner to current product
                products.add(inner);
                i = j + 1;
            } else if (Character.isLetter(expr.charAt(i))) {
                Set<String> letter = new HashSet<>();
                // Read continuous letters? "abc"
                // No, just one char is fine, effectively concats.
                letter.add("" + expr.charAt(i));
                products.add(letter);
                i++;
            } else {
                // Should not happen if comma logic is handled inside braces
                // But if implicit concat rules apply
                i++;
            }
        }

        // Now compute cross product of all sets in 'products'
        Set<String> result = new HashSet<>();
        result.add("");
        for (Set<String> s : products) {
            Set<String> next = new HashSet<>();
            for (String pre : result) {
                for (String suf : s) {
                    next.add(pre + suf);
                }
            }
            result = next;
        }
        return result;
    }
}
