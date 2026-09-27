class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        Map<Integer, List<Integer>> map = new HashMap();
        

        for (int i = 0; i <= edges.length; i++) {
            map.put(i, new ArrayList());
        }

        for (int [] edge: edges) {
            int u = edge[0], v = edge[1];
            map.get(u).add(v);
            map.get(v).add(u);
            Set<Integer> visited = new HashSet();
            if (dfs(u, -1, map, visited)) {
                return edge;
            }
        }

        return new int[0];
        
    }

    private boolean dfs(int node, int parent, Map<Integer, List<Integer>> map, Set<Integer> visited) {
        if (visited.contains(node)) {
            return true;
        }
        visited.add(node);
        for (int nei : map.get(node)) {
            if (nei == parent) {
                continue;
            }
            if (dfs(nei, node, map, visited)) {
                return true;
            }
        }

        return false;
    }
}
