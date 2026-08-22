class Solution {

    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    LinkedList<String> itinerary = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        // Build graph
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            graph
                .computeIfAbsent(from, k -> new PriorityQueue<>())
                .offer(to);
        }

        // Start DFS from JFK
        dfs("JFK");

        return itinerary;
    }

    private void dfs(String airport) {

        PriorityQueue<String> destinations = graph.get(airport);

        // Use every ticket from this airport
        while (destinations != null && !destinations.isEmpty()) {
            String next = destinations.poll();
            dfs(next);
        }

        // Add after using all outgoing tickets
        itinerary.addFirst(airport);
    }
}
