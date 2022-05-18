class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        
        int curRow = 0;
        boolean goingDown = false;
        
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0) goingDown = true;
            if (curRow == numRows - 1) goingDown = false;
            if (goingDown) {
                curRow++;
            } else {
                curRow--;
            }
        }
        
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}