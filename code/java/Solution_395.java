class Solution_395 {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            graph.computeIfAbsent(equations[i][0], k -> new HashMap<>()).put(equations[i][1], values[i]);
            graph.computeIfAbsent(equations[i][1], k -> new HashMap<>()).put(equations[i][0], 1 / values[i]);
        }
        int n = queries.length;
        double[] res = new double[n];
        for (int i = 0; i < n; i++) {
            double val = calcEquation(queries[i][0], queries[i][1], new HashSet<>(), graph);
            res[i] = val == 0 ? -1 : val;
        }
        return res;
    }
    
    private double calcEquation(String src, String dest, Set<String> visited, Map<String, Map<String, Double>> graph) {
        if (!graph.containsKey(src)) {
            return 0;
        }
        if (src.equals(dest)) {
            return 1.0;
        }
        visited.add(src);
        for (String next : graph.get(src).keySet()) {
            if (visited.contains(next)) {
                continue;
            }
            double d = calcEquation(next, dest, visited, graph);
            if (d != 0) {
                return d * graph.get(src).get(next);
            }
        }
        return 0;
    }
}