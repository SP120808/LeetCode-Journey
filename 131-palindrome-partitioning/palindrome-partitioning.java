import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        find(s, 0, new ArrayList<>(), list);
        return list;
    }

    public void find(String s, int start, List<String> temp, List<List<String>> list) {
        if (start == s.length()) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1);

            if (isPalindrome(str)) {
                temp.add(str);
                find(s, i + 1, temp, list);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }
}