// https://leetcode.com/problems/word-ladder/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Pair {
    String word;
    int level;

    Pair(String w, int l) {
        word = w;
        level = l;
    }
}

public class WordLedderI {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>();

        for (String s : wordList)
            set.add(s);

        q.offer(new Pair(beginWord, 1));

        while (!q.isEmpty() && !set.isEmpty()) {
            Pair p = q.poll();
            String word = p.word;
            int level = p.level;

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    StringBuilder sb = new StringBuilder(word);
                    sb.setCharAt(i, ch);
                    String replaceWord = sb.toString();
                    // System.out.println(replaceWord);

                    if (set.contains(replaceWord)) {
                        if (replaceWord.equals(endWord))
                            return level + 1;

                        set.remove(replaceWord);
                        q.offer(new Pair(replaceWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}