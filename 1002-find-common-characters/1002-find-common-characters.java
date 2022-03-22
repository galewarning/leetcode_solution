class Solution {
    public List<String> commonChars(String[] words) {
        int[] res = new int[26];
        Arrays.fill(res, Integer.MAX_VALUE);
        
        for (int i = 0; i < words.length; i++) {
            int[] cur = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                cur[words[i].charAt(j) - 'a']++;
            }
            for (int k = 0; k < 26; k++) {
                res[k] = Math.min(res[k], cur[k]);
            }
        }

        
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (res[i] > 0) {
                char c = (char)('a' + i);
                result.add(String.valueOf(c));
                res[i]--;
            }
        }
        
        return result;
    }
}