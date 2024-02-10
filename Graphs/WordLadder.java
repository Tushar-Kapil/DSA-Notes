package Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Pair {
    String first;
    int second;

    Pair(String first, int second) {
        this.first = first;
        this.second = second;
    }
}

class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        Set<String> st = new HashSet<>();
        int len = wordList.size();

        for (int i = 0; i < len; i++) {
            st.add(wordList.get(i));
        }

        st.remove(beginWord);

        while (!q.isEmpty()) {
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            if (word.equals(endWord) == true) {
                return steps;
            }

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replaceArray = word.toCharArray();
                    replaceArray[i] = ch;
                    String replacedString = new String(replaceArray);

                    if (st.contains(replacedString) == true) {
                        st.remove(replacedString);
                        q.add(new Pair(replacedString, steps + 1));
                    }
                }
            }
        }

        return 0;
    }
}
