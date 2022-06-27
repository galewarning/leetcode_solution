class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        Map<Long, Integer> map = new HashMap<>();
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            sb.append("-");
        }
        
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        long n = num/den;
        long reminder = num % den;
        
        sb.append(n);
        if (reminder == 0) {
            return sb.toString();
        } else {
            sb.append(".");
        }
        
        while (!map.containsKey(reminder)) {
            map.put(reminder, sb.length());
            n = reminder * 10 / den;
            reminder = reminder * 10 % den;
            if (reminder != 0 || reminder == 0 && !map.containsKey(reminder))
                sb.append(n);
        }
        
        if (reminder != 0) {
            sb.insert(map.get(reminder), "(");
            sb.append(")");
        }
        
        return sb.toString();
    }
}