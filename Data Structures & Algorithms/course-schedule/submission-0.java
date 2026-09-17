class Solution {
    // for any course, these are the list of requirements
    // for all courses, remove me from the list and add if in degree 0

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // All prerequisites are must take x before taking y

        
        // Then do topological sort and determine if there is a valid ordering

        // Turn prerequisites into an adjacency list
        List<List<Integer>> courseRequirements = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            courseRequirements.add(new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            courseRequirements.get(prereq[1]).add(prereq[0]);
        }

        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> output = new ArrayList<>();

        // Find all courses with no dependencies and add to stack
        for (int i = 0; i < courseRequirements.size(); i++) {
            if (courseRequirements.get(i).isEmpty()) stack.add(i);
        }

        // Topoplogical sort on inDegree 0 nodes
        while (!stack.isEmpty()) {
            int courseNum = stack.poll();

            output.add(courseNum);

            // Removing inDegree from nodes
            for (int i = 0; i < courseRequirements.size(); i++) {
                List<Integer> courseReq = courseRequirements.get(i);
                
                if (courseReq.remove(Integer.valueOf(courseNum)) && courseReq.isEmpty()) {
    stack.push(i);
}
            }
        }

        return output.size() == numCourses;
    }
}
