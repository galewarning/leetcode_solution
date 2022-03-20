class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict = new HashSet<>(wordList);
        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        int res = 1;
        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<>();
            for (String s : reached) {
                for (int i = 0; i < s.length(); i++) {
                    char[] chars = s.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if (wordDict.contains(word)) {
                            toAdd.add(word);
                            wordDict.remove(word);
                        }
                    }
                }
            }
            res++;
            if (toAdd.size() == 0) return 0;
            reached = toAdd;
        }
        return res;
    }
}