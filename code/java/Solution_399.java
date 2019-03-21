// using union find
class Solution_399 {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Pair> root = new HashMap<>();
        Map<String, Integer> rank = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            Pair r1 = root.get(equations[i][0]);
            Pair r2 = root.get(equations[i][1]);
            if (r1 == null && r2 == null) {
                root.put(equations[i][0], new Pair(equations[i][1], values[i]));
                root.put(equations[i][1], new Pair(equations[i][1], 1));
                rank.put(equations[i][0], 0);
                rank.put(equations[i][1], 1);
            } else if (r1 == null) {
                root.put(equations[i][0], new Pair(equations[i][1], values[i]));
                rank.put(equations[i][0], 0);
            } else if (r2 == null) {
                root.put(equations[i][1], new Pair(equations[i][0], 1 / values[i]));
                rank.put(equations[i][1], 0);
            } else {
                union(equations[i][0], equations[i][1], root, rank, values[i]);
            }
           
        }
        int n = queries.length;
        double[] res = new double[n]; 
        for (int i = 0; i < n; i++) {
            Pair r1 = find(root, queries[i][0]);
            Pair r2 = find(root, queries[i][1]);
            if (r1 == null || r2 == null) {
                res[i] = -1;
            } else if(r1.r.equals(r2.r)) {
                res[i] = r1.d / r2.d;
            } else {
                res[i] = -1;
            }
        }
        return res;
    }
    
    private Pair find(Map<String, Pair> root, String p) {
        if (!root.containsKey(p)) {
            return null;
        }
        if (!root.get(p).r.equals(p)) {
            Pair r = find(root, root.get(p).r);
            root.put(p, new Pair(r.r, root.get(p).d * r.d));
        }
        return root.get(p);
    }
    private void union(String p1, String p2, Map<String, Pair> root, Map<String, Integer> rank, double val) {
        Pair r1 = find(root, p1);
        Pair r2 = find(root, p2);
        if (r1.r.equals(r2.r)) {
            return;
        }
        if (rank.get(r1.r) < rank.get(r2.r)) {
            root.put(r1.r, new Pair(r2.r, r2.d / r1.d * val));
        } else if (rank.get(r1.r) > rank.get(r2.r)) {
            root.put(r2.r, new Pair(r1.r, r1.d / r2.d / val));
        } else {
            root.put(r1.r, new Pair(r2.r, r2.d / r1.d * val));
            rank.put(r2.r, rank.get(r2.r) + 1);
        }
        
    }
    
    class Pair {
        String r;
        double d;
        Pair (String r, double d) {
            this.r = r;
            this.d = d;
        }
        public String toString() {
            return this.r + " " + this.d;
        }
    }
}

// using graph
class Solution_399_1 {
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