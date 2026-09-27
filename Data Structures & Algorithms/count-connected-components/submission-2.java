class Solution {
    public int countComponents(int n, int[][] edges) {

        int count = 0;
        Map<Integer, List<Integer>> map = new HashMap();

        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList()).add(edge[0]);
        }
        Set<Integer> visited = new HashSet();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i) ){
                dfs(i, map, visited);
                count++;
            }
        }

        return count;

    }

    private void dfs(int node, Map<Integer, List<Integer>> map, Set<Integer> visited) {
   
        visited.add(node);
        for (int nei: map.getOrDefault(node, Collections.emptyList())) {
            if (!visited.contains(nei))
                dfs(nei, map, visited);
        }

    }
}
