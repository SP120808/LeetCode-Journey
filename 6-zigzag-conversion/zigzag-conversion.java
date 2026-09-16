class Solution {
    public String convert(String s, int numRows) {

        // If there is only one row
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];

        // Create a StringBuilder for each row
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = true;

        // Put each character into the correct row
        for (int i = 0; i < s.length(); i++) {

            rows[currentRow].append(s.charAt(i));

            // Change direction at the top or bottom
            if (currentRow == 0) {
                goingDown = true;
            }
            else if (currentRow == numRows - 1) {
                goingDown = false;
            }

            // Move to the next row
            if (goingDown) {
                currentRow++;
            }
            else {
                currentRow--;
            }
        }

        // Combine all rows
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            result.append(rows[i]);
        }

        return result.toString();
    }
}