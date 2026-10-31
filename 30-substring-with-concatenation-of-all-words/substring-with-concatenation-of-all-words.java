import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;
        
        if (s.length() < totalLen) {
            return result;
        }

     
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

     
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int count = 0;
            Map<String, Integer> currentFreq = new HashMap<>();

            for (int right = i; right <= s.length() - wordLen; right += wordLen) {
                String word = s.substring(right, right + wordLen);

                if (wordFreq.containsKey(word)) {
                    currentFreq.put(word, currentFreq.getOrDefault(word, 0) + 1);
                    count++;

                    while (currentFreq.get(word) > wordFreq.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currentFreq.put(leftWord, currentFreq.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                 
                    if (count == wordCount) {
                        result.add(left);
                 
                        String leftWord = s.substring(left, left + wordLen);
                        currentFreq.put(leftWord, currentFreq.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }
                } else {
                 
                    currentFreq.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return result;
    }
}