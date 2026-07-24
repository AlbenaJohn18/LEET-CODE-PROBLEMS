class Solution {
    public boolean isMatch(String s, String p) {
        Integer[][] memo = new Integer[s.length() + 1][p.length() + 1];
        return match(s, p, 0, 0, memo);
    }

    private boolean match(String s, String p, int i, int j, Integer[][] memo) {
        if (j == p.length()) {
            return i == s.length();
        }
        if (memo[i][j] != null) {
            return memo[i][j] == 1;}
        
        boolean firstMatch = (i < s.length()) &&
                              (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');

        boolean result;
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            result = match(s, p, i, j + 2, memo) ||
                     (firstMatch && match(s, p, i + 1, j, memo));
        } else {
            result = firstMatch && match(s, p, i + 1, j + 1, memo);
        }

        memo[i][j] = result ? 1 : -1;
        return result;
    }
}
