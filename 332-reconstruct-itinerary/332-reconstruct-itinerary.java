class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> flights = new HashMap<>();
        LinkedList<String> res = new LinkedList<>();
        
        for (List<String> ticket : tickets) {
            if (!flights.containsKey(ticket.get(0))) {
                flights.put(ticket.get(0), new PriorityQueue());
            }
                flights.get(ticket.get(0)).add(ticket.get(1));
        }
        
        dfs("JFK", flights, res);
        return res;
    }
    
    public void dfs(String departure, Map<String, PriorityQueue<String>> flights, LinkedList<String> res) {
        
        PriorityQueue<String> next = flights.get(departure);
        while (next != null && !next.isEmpty()) {
            dfs(next.poll(), flights, res);
        }
        res.addFirst(departure);
    }
}

