public class UnionFind {
    private int[] intSet;

    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {
        intSet = new int[n];
        for (int i = 0; i < n; i++) {
            intSet[i] = -1;
        }
    }

    /* Throws an exception if v1 is not a valid index. */
    private void validate(int vertex) {
        if (vertex >= intSet.length || vertex < 0) {
            throw new IllegalArgumentException("Invalid Index");
        }
    }

    /* Returns the size of the set v1 belongs to. */
    public int sizeOf(int v1) {
        validate(v1);
        return -parent(find(v1));
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. Gives the parent's index */
    public int parent(int v1) {
        validate(v1);
        return intSet[v1];
    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) {
        validate(v1);
        validate(v2);
        return find(v1) == find(v2);
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unioning a
       vertex with itself or vertices that are already connected should not
       change the sets but may alter the internal structure of the data. */
    public void union(int v1, int v2) {
        validate(v1);
        validate(v2);
        if (!(connected(v1, v2))) {
            if (sizeOf(v1) > sizeOf(v2)) {
                /**
                 * add size of v2 root to v1 root
                 * then set v2 root equal to v1 root
                 */
                intSet[find(v1)] -= sizeOf(v2);
                intSet[find(v2)] = find(v1);
            } else {
                intSet[find(v2)] -= sizeOf(v1);
                intSet[find(v1)] = find(v2);
            }
        }
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. Returns index of root */
    public int find(int vertex) {
        validate(vertex);
        int root = vertex;
        while (parent(root) > -1) {
            root = parent(root);
        }

        while (vertex != root) {
            intSet[vertex] = root;
            vertex = parent(vertex);
        }

        return root;
    }

}
