
class Solution {
    public int romanToInt(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int val = 0;

            switch (s.charAt(i)) {
                case 'I': val = 1; break;
                case 'V': val = 5; break;
                case 'X': val = 10; break;
                case 'L': val = 50; break;
                case 'C': val = 100; break;
                case 'D': val = 500; break;
                case 'M': val = 1000; break;
            }

            if (i < s.length() - 1 && val < getValue(s.charAt(i + 1)))
                ans -= val;
            else
                ans += val;
        }

        return ans;
    }

    public int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}
