class Solution {
    
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
        
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(n, k, 1, 0);
        return res;
    }
    
    private void backtracking(int target, int k, int startIndex, int sum) {
        if (sum > target) return;
        
        if (path.size() == k) {
            if (sum == target) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backtracking(target, k, i + 1, sum);
            
            path.removeLast();
            sum -= i;
        }
    } 
}