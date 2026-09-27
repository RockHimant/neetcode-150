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

        Queue<int[]> q = new LinkedList();
        q.offer(new int[]{0, -1});
        visited.add(0);
        while (!q.isEmpty()) {
            int[] pair = q.poll();
            int node = pair[0], parent = pair[1];

            for (int nei : map.get(node)) {
                if (nei == parent) {
                    continue;
                }
                
                if (visited.contains(nei)) {
                    return false;
                }
                visited.add(nei);
                q.offer(new int[]{nei, node});
            }

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
