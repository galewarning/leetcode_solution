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
        long remainder = num % den;
        
        sb.append(n);
        if (remainder == 0) {
            return sb.toString();
        } else {
            sb.append(".");
        }
        
        while (!map.containsKey(remainder)) {
            map.put(remainder, sb.length());
            n = remainder * 10 / den;
            remainder = remainder * 10 % den;
            if (remainder != 0 || remainder == 0 && !map.containsKey(remainder))
                sb.append(n);
        }
        
        if (remainder != 0) {
            sb.insert(map.get(remainder), "(");
            sb.append(")");
        }
        
        return sb.toString();
    }
}