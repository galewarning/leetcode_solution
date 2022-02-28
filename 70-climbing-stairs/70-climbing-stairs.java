class Solution {
    /*public int climbStairs(int n) {
        if(n <= 2) {
            return n;
        } else {
            return climbStairs(n-1) + climbStairs(n-2);
        }
    }*/
    
    public int climbStairs(int n) {
        int[] ways = new int[n+1];
        ways[0]=1;
        ways[1]=1;
        for (int i = 2; i<=n; i++)
            ways[i]=ways[i-1]+ways[i-2];
        return ways[n];
    }

    
}