class Solution {
    public boolean validTree(int n, int[][] edges) {

        if (edges.length > n - 1) {
            return false;
        }

        Set<Integer> visited = new HashSet();
        Map<Integer, List<Integer>> map = new HashMap();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList());
        }

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        if (!dfs(0, visited, map, -1)) {
            return false;
        }

        return visited.size() == n;


    }

    private boolean dfs(int node, Set<Integer> visited, Map<Integer, List<Integer>> map, int parent) {
        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);

        for (int nei : map.get(node)) {
            if (nei == parent) {
                continue;
            }

            if (!dfs(nei, visited, map, node)) {
                return false;
            }
        }

        return true;
    }
}
