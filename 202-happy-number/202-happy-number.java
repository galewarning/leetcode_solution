class Solution {
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNext(n);
        }
        return n==1;
        
    }
    
    private int getNext(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res = res + temp * temp;
            n = n / 10;
        }
        return res;
    }
}