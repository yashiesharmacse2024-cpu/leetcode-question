import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] findWords(String[] words) {
       
        int[] charToRow = new int[26];
        
        String row0 = "qwertyuiop";
        String row1 = "asdfghjkl";
        String row2 = "zxcvbnm";
        
        for (char c : row0.toCharArray()) charToRow[c - 'a'] = 0;
        for (char c : row1.toCharArray()) charToRow[c - 'a'] = 1;
        for (char c : row2.toCharArray()) charToRow[c - 'a'] = 2;
        
        List<String> validWords = new ArrayList<>();
        
        for (String word : words) {
            if (word.isEmpty()) continue;
            
            
            int firstCharRow = charToRow[Character.toLowerCase(word.charAt(0)) - 'a'];
            boolean isValid = true;
            
           
            for (int i = 1; i < word.length(); i++) {
                int currentCharRow = charToRow[Character.toLowerCase(word.charAt(i)) - 'a'];
                if (currentCharRow != firstCharRow) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                validWords.add(word);
            }
        }
        return validWords.toArray(new String[0]);
    }
}