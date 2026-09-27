class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap();
        Set<Integer> cycle = new HashSet();
        Set<Integer> visited = new HashSet();

        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList());
        }

        for (int[] req : prerequisites) {
            map.get(req[0]).add(req[1]);
        }
        List<Integer> output = new ArrayList();
        for (int i = 0; i< numCourses; i++) {
            if (!dfs(i, cycle, visited, output, map)) {
                return new int[0];
            }
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = output.get(i);
        }

        return result;
        
    }

    private boolean dfs(int node, Set<Integer> cycle, Set<Integer>visited, List<Integer> output, Map<Integer, List<Integer>> map) {
        if (cycle.contains(node)) {
            return false;
        }
        if (visited.contains(node)) {
            return true;
        }
           cycle.add(node);
        
        for (int nei : map.getOrDefault(node, Collections.emptyList())) {
            if (!dfs(nei, cycle, visited, output, map)) {
                return false;
            }
        }

        cycle.remove(node);
        output.add(node);
        visited.add(node);


        return true;
    }


}
