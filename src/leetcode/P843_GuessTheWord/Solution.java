package leetcode.P843_GuessTheWord;

import java.util.*;

interface Master {
    int guess(String word);
}

class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        List<String> list = new ArrayList<>(Arrays.asList(wordlist));
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            String guess = list.get(rand.nextInt(list.size()));
            int x = master.guess(guess);
            if (x == 6)
                return;

            List<String> nextList = new ArrayList<>();
            for (String w : list) {
                if (match(guess, w) == x) {
                    nextList.add(w);
                }
            }
            list = nextList;
        }
    }

    private int match(String a, String b) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (a.charAt(i) == b.charAt(i))
                count++;
        }
        return count;
    }
}
