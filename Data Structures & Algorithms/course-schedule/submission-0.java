//import java.util.*;

class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Indegree of every course
        int[] indegree = new int[numCourses];

        // Build graph
        for (int[] prerequisite : prerequisites) {

            int course = prerequisite[0];
            int pre = prerequisite[1];

            // pre -> course
            graph.get(pre).add(course);

            indegree[course]++;
        }

        // Courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int completed = 0;

        // BFS / Kahn's Algorithm
        while (!queue.isEmpty()) {

            int course = queue.poll();

            completed++;

            // Remove this course from graph
            for (int nextCourse : graph.get(course)) {

                indegree[nextCourse]--;

                // All prerequisites completed
                if (indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        // If all courses were completed,
        // there is no cycle.
        return completed == numCourses;
    }
}
