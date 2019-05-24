public class Sort {
    public static void sort(String[] x){
        // find smallest item
        // move to front
        // call recursively
        sort(x, 0);
    }

    /** Sorts x starting at position start. */
    private static void sort(String[] x, int start) {
        if (start == x.length) {
            return;
        }
        int smallest = findSmallest(x, start);
        swap(x, start, smallest);
        sort(x, start + 1);
    }

    /** Swaps item a and b */
    public static void swap(String[] x, int a, int b) {
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }

    /** Returns the index of the smallest String in x, starting at start */
    public static int findSmallest(String[] x, int start) {
        int smallestIndex = start;
        for (int i = start; i < x.length; i++) {
            int cmp = x[i].compareTo(x[smallestIndex]);

            if (cmp < 0) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }
}
