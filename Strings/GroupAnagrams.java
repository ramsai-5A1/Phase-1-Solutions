class Solution {

    private String getToken(String word) {
        int[] frequency = new int[26];
        for(char ch: word.toCharArray()) {
            frequency[(int) ch - (int) 'a']++;
        }

        String token = "";
        for(int index = 0; index < 26; index++) {
            token += Integer.toString(frequency[index]);
            token += '#';
        }
        return token;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> store = new HashMap<>();

        for(String word: strs) {
            String token = getToken(word);
            if (!store.containsKey(token)) {
                store.put(token, new ArrayList<String>());
            }
            store.get(token).add(word);
        }

        Set<String> keys = store.keySet();
        for(String key: keys) {
            result.add(store.get(key));
        }
        return result;
    }
}