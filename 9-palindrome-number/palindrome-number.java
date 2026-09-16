class Solution {
    public boolean isPalindrome(int x) {

        // Negative numbers are not palindromes
        if (x < 0) {
            return false;
        }

        // Numbers ending in 0 cannot be palindromes
        // except 0 itself
        if (x != 0 && x % 10 == 0) {
            return false;
        }

        int reversedHalf = 0;

        while (x > reversedHalf) {

            int digit = x % 10;

            reversedHalf = reversedHalf * 10 + digit;

            x = x / 10;
        }

        // Even number of digits
        // OR odd number of digits
        return x == reversedHalf ||
               x == reversedHalf / 10;
    }
}