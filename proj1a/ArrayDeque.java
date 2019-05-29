public class ArrayDeque<T> {
    private T[] items;
    private int first; // index of first item
    private int last; // index of last item
    private int size;

    // start size of arrays is always 8
    private static final int STARTSIZE = 8;
    // multiply or divide array size by this to shrink or enlarge
    private static final int RFACTOR = 2;

    public ArrayDeque() {
        items = (T[]) new Object[STARTSIZE];
        first = 0;
        last = 0;
        size = 0;
    }

//    public ArrayDeque(ArrayDeque other) {
//        items = (T[]) new Object[STARTSIZE];
//        first = 0;
//        last = 0;
//        size = 0;
//
//        for (int i = 0; i < other.size(); i++) {
//            addLast((T) other.get(i));
//        }
//    }


    /** if usage ratio is < 25%, shrink */
    private void checkUsage() {
        double length = (double) size / (double) items.length;
        if (length < .25) {
            shrink(items.length / RFACTOR);
        }
    }

    /** makes array larger */
    private void enlarge(int capacity, int start) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, start, size);
        items = a;
    }

    /** makes array smaller */
    private void shrink(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, capacity);
        items = a;
    }

    /** helper method to shift array when first item is removed */
    private void shift() {
        T[] a = (T[]) new Object[items.length];
        System.arraycopy(items, 1, a, 0, items.length - 1);
        items = a;
        checkUsage();
    }

    public void addFirst(T x) {
        if (size == 0) {
            enlarge(STARTSIZE, 1);
        } else if (size == items.length) {
            enlarge(size * RFACTOR, 1);
            last += 1;
        } else {
            enlarge(items.length, 1);
            last += 1;
        }
        items[0] = x;
        size += 1;

    }

    public void addLast(T x) {
        if (size == items.length) {
            enlarge(size * RFACTOR, 0);
            last += 1;
        } else if (size > 0) {
            last += 1;
        }
        items[size] = x;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    private T getFirst() {
        return items[0];
    }

    private T getLast() {
        if (size == 0) {
            return null;
        }
        return items[last];
    }

    public T removeFirst() {
        T x = getFirst();
        if (x == null || size == 0) {
            return null;
        }
        items[0] = null;
        size -= 1;
        last -= 1;
        shift();
        return x;
    }

    public T removeLast() {
        T x = items[last];
        if (x == null || last == -1) {
            return null;
        }
        items[last] = null;
        size -= 1;
        last -= 1;
        checkUsage();
        return x;
    }

    public T get(int x) {
        if (x < 0) {
            return null;
        }
        return items[x];
    }
}
