//import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Indegree of every course
        int[] indegree = new int[numCourses];

        // Build graph
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];

            graph.get(prerequisite).add(course);
            indegree[course]++;
        }

        // Queue courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        // BFS
        while (!queue.isEmpty()) {
            int current = queue.poll();

            result[index++] = current;

            // Remove current course as prerequisite
            for (int next : graph.get(current)) {
                indegree[next]--;

                // All prerequisites completed
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // If we couldn't process all courses, cycle exists
        if (index != numCourses) {
            return new int[0];
        }

        return result;
    }
}