

//User function Template for Java

class Solution {
    public static List<String> generateBinaryStrings(int n) {
      // code here
      List<String> ans = new ArrayList<>();
      char[] string = new char[n];
      
      string[0] = '1';
      helper(string, n, 1, ans);
      string[0] = '0';
      helper(string, n, 1, ans);
      Collections.sort(ans);
      return ans;
  
    }
    private static void helper(char[] string, int n, int index, List<String> ans){
        if(index == string.length){
            ans.add(new String(string));
            return;
        }
        if(string[index - 1] == '0'){
            string[index] = '0';
            helper(string, n, index + 1, ans);
            string[index] = '1';
            helper(string, n, index + 1, ans);
        }
        if(string[index - 1] == '1'){
            string[index] = '0';
            helper(string, n, index + 1, ans);
        }
    }
  }
       
       