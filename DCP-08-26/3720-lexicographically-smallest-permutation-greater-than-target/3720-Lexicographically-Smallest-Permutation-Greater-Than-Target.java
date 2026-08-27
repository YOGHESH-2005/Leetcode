class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int x = target.charAt(i) - 'a';
            if (cnt[x] == 0) {
                break;
            }
            cnt[x]--;
            prefix.append(target.charAt(i));
        }
        if (prefix.length() < n) {
            int i = prefix.length();
            int x = target.charAt(i) - 'a';
            for (int c = x + 1; c < 26; c++) {
                if (cnt[c] == 0)
                    continue;
                StringBuilder ans = new StringBuilder(prefix);
                ans.append((char) ('a' + c));
                cnt[c]--;
                for (int ch = 0; ch < 26; ch++) {
                    for (int t = 0; t < cnt[ch]; t++) {
                        ans.append((char) ('a' + ch));
                    }
                }
                return ans.toString();
            }
        }
        for (int i = prefix.length() - 1; i >= 0; i--) {
            cnt[prefix.charAt(i) - 'a']++;
            prefix.deleteCharAt(prefix.length() - 1);
            int x = target.charAt(i) - 'a';
            for (int c = x + 1; c < 26; c++) {
                if (cnt[c] == 0)
                    continue;
                StringBuilder ans = new StringBuilder(prefix);
                ans.append((char) ('a' + c));
                cnt[c]--;
                for (int ch = 0; ch < 26; ch++) {
                    for (int t = 0; t < cnt[ch]; t++) {
                        ans.append((char) ('a' + ch));
                    }
                }
                return ans.toString();
            }
        }
        return "";
    }
}