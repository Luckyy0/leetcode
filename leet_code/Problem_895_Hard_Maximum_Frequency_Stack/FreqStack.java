package leet_code.Problem_895_Hard_Maximum_Frequency_Stack;

import java.util.*;

/**
 * Problem 895: Maximum Frequency Stack
 * https://leetcode.com/problems/maximum-frequency-stack/
 */
public class FreqStack {

    // Store the frequency of each value
    Map<Integer, Integer> freqMap;
    // Group elements by frequency: k -> Stack of elements with frequency k
    Map<Integer, Stack<Integer>> groupMap;
    // Track the current maximum frequency
    int maxFreq;

    public FreqStack() {
        freqMap = new HashMap<>();
        groupMap = new HashMap<>();
        maxFreq = 0;
    }

    /**
     * Pushes an element onto the stack.
     * Strategy:
     * 1. Update frequency of val.
     * 2. Update maxFreq if needed.
     * 3. Push val to the stack corresponding to its new frequency.
     */
    public void push(int val) {
        int f = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, f);

        if (f > maxFreq) {
            maxFreq = f;
        }

        // Push val to the stack for frequency 'f'
        // This ensures that the most recent occurrence of 'val' (at frequency f)
        // is at the top of the stack for 'f'.
        groupMap.computeIfAbsent(f, k -> new Stack<>()).push(val);
    }

    /**
     * Removes and returns the most frequent element.
     * Strategy:
     * 1. Identify the stack corresponding to maxFreq.
     * 2. Pop the element from that stack.
     * 3. Decrement frequency of the popped element.
     * 4. If the maxFreq stack becomes empty, decrement maxFreq.
     */
    public int pop() {
        Stack<Integer> stack = groupMap.get(maxFreq);
        int val = stack.pop();

        // Decrement frequency
        freqMap.put(val, maxFreq - 1);

        // If no more elements have frequency equal to maxFreq, reduce maxFreq
        if (stack.isEmpty()) {
            maxFreq--;
        }

        return val;
    }

    public static void main(String[] args) {
        FreqStack fs = new FreqStack();
        fs.push(5);
        fs.push(7);
        fs.push(5);
        fs.push(7);
        fs.push(4);
        fs.push(5);

        System.out.println("Pop: " + fs.pop()); // 5
        System.out.println("Pop: " + fs.pop()); // 7
        System.out.println("Pop: " + fs.pop()); // 5
        System.out.println("Pop: " + fs.pop()); // 4
    }
}
