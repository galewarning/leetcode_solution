class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        
        for (Map.Entry<Integer, Integer> entry : entries) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().getKey();
        }
        return res;
    }
}