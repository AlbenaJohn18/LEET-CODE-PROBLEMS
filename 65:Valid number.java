class Solution {
    public boolean isNumber(String s) {
        int n = s.length();
        int i = 0;
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExponent = false;
        for (i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == '+' || c == '-') {
            if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == '.') {
                if (seenDot || seenExponent) return false;
                seenDot = true;
            } else if (c == 'e' || c == 'E') {
                if (seenExponent || !seenDigit) return false;
                seenExponent = true;
                seenDigit = false;
            } else {
                return false; 
            }
        }
        
        return seenDigit;
    }
}
