class Solution {
    public int maxDistToClosest(int[] seats) {
        int prev = -1;
        int res = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (prev == -1) {
                    res = i;
                } else {
                    res = Math.max(res, (i - prev) / 2);
                }
                prev = i;
            }
        }
        res = Math.max(res, seats.length - prev - 1);
        return res;
    }
}