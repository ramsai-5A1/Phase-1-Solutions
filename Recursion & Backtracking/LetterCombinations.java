class Solution {
    
    
    private void solveIt(String digits, int index, int n, List<String> result, HashMap<Character, String> store, StringBuilder path) {
        
        if (index == n) {
            if (path.toString().length() > 0) {
                result.add(path.toString());
            }
            
            return;
        }
        
        String currWord = store.get(digits.charAt(index));
        //System.out.println(currWord);
        
        for (char ch: currWord.toCharArray()) {
            path.append(ch);
            solveIt(digits, index + 1, n, result, store, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> store = new HashMap<>();
        store.put('2', "abc");
        store.put('3', "def");
        store.put('4', "ghi");
        store.put('5', "jkl");
        store.put('6', "mno");
        store.put('7', "pqrs");
        store.put('8', "tuv");
        store.put('9', "wxyz");
        
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        solveIt(digits, 0, digits.length(), result, store, path);
        return result;
    }
}