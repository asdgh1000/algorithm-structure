//package algorithm.leetCode.week03.No127;
//
//import com.sun.deploy.util.ArrayUtil;
//import javafx.util.Pair;
//import sun.misc.Unsafe;
//
//import java.util.*;
//
///**
// * @author ltw
// * on 2020-03-03.
// */
//class Solution {
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//
//        int L = beginWord.length();
//
//        HashMap<String, ArrayList<String>> allComboDict = new HashMap<>();
//        wordList.forEach(
//                word -> {
//                    for (int i = 0; i < L; i++) {
//                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
//                        ArrayList<String> transformations =
//                                allComboDict.getOrDefault(newWord, new ArrayList<>());
//                        transformations.add(word);
//                        allComboDict.put(newWord, transformations);
//                    }
//                });
//
//
//        //BFS遍历
//        // Queue for BFS
//        Queue<Pair<String, Integer>> Q = new LinkedList<>();
//        Q.add(new Pair(beginWord, 1));
//
//        // Visited to make sure we don't repeat processing same word.
//        HashMap<String, Boolean> visited = new HashMap<>();
//        visited.put(beginWord, true);
//
//        while (!Q.isEmpty()) {
//            Pair<String, Integer> node = Q.remove();
//            String word = node.getKey();
//            int level = node.getValue();
//            for (int i = 0; i < L; i++) {
//
//                // Intermediate words for current word
//                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
//
//                // Next states are all the words which share the same intermediate state.
//                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
//                    // If at any point if we find what we are looking for
//                    // i.e. the end word - we can return with the answer.
//                    if (adjacentWord.equals(endWord)) {
//                        return level + 1;
//                    }
//                    // Otherwise, add it to the BFS Queue. Also mark it visited
//                    if (!visited.containsKey(adjacentWord)) {
//                        visited.put(adjacentWord, true);
//                        Q.add(new Pair(adjacentWord, level + 1));
//                    }
//                }
//            }
//        }
//
//        return 0;
//    }
//
//}
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        String beginWord = "hit";
//        String endWord = "cog";
//        String[] wordList = {"hot", "dot", "dog", "lot", "log"};
//        List list = Arrays.asList(wordList);
//        solution.ladderLength(beginWord, endWord, list);
//    }
//}
