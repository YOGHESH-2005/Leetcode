class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        int odd = 0;
        for (int f : freq) {
            if (f % 2 != 0) {
                odd++;
            }
        }
        if (odd > 1) {
            return "";
        }
        int halfLen = n / 2;
        int[] half = new int[26];
        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
        }
        int matchLen = 0;
        int[] temp = half.clone();
        for (int i = 0; i < halfLen; i++) {
            int idx = target.charAt(i) - 'a';
            if (temp[idx] > 0) {
                temp[idx]--;
                matchLen++;
            } else {
                break;
            }
        }
        if (matchLen == halfLen) {
            String palindrome =
                buildPalindrome(target.substring(0, halfLen), freq);
            if (palindrome.compareTo(target) > 0) {
                return palindrome;
            }
        }
        for (int i = Math.min(matchLen, halfLen - 1); i >= 0; i--) {
            int[] remaining = half.clone();
            for (int k = 0; k < i; k++) {
                remaining[target.charAt(k) - 'a']--;
            }
            int targetChar = target.charAt(i) - 'a';
            for (int c = targetChar + 1; c < 26; c++) {
                if (remaining[c] == 0) {
                    continue;
                }
                int[] tempRemaining = remaining.clone();
                tempRemaining[c]--;
                StringBuilder left = new StringBuilder();
                left.append(target, 0, i);
                left.append((char) ('a' + c));
                for (int ch = 0; ch < 26; ch++) {
                    while (tempRemaining[ch] > 0) {
                        left.append((char) ('a' + ch));
                        tempRemaining[ch]--;
                    }
                }
                return buildPalindrome(left.toString(), freq);
            }
        }
        return "";
    }
    private String buildPalindrome(String left, int[] freq) {
        StringBuilder ans = new StringBuilder();
        ans.append(left);
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                ans.append((char) ('a' + i));
                break;
            }
        }
        ans.append(new StringBuilder(left).reverse());
        return ans.toString();
    }
}