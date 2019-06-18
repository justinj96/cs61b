public class UnionFindDriver {
    public static void main(String[] args) {
        UnionFind djs = new UnionFind(8);
        djs.union(0, 1);
        djs.union(0, 2);
        djs.union(3, 4);
        djs.union(3, 0);
        djs.union(3, 5);
        int size = djs.sizeOf(1);
    }
}
