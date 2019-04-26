public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }
    public int size() {
        if (rest == null) {
            return 1;
        } else {
            return 1 + this.rest.size();
        }
    }
    public int iterativeSize() {
        IntList p = this;
        int size = 0;
        while (p != null) {
           size += 1;
           p = p.rest;
        }
        return size;
    }

    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);
    }

    public static IntList incrList(IntList L, int x) {
        if (L == null) {
            return null;
        }
        IntList Q = new IntList(L.first + x, null);
        Q.rest = incrList(L.rest, x);
        return Q;
    }

    public static IntList dincrList(IntList L, int x) {
        if (L == null) {
            return null;
        }
        L.first = L.first - x;
        dincrList(L.rest, x);
        return L;
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(10, null);
        L.rest.rest = new IntList(15, null);
        System.out.println(L.iterativeSize());
        System.out.println(L.get(1));
        incrList(L, 2);
        dincrList(L, 2);
    }
}