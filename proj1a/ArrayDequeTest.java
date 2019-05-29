public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        L.addFirst(0);
        L.addLast(1);
        L.addLast(2);
        L.removeLast();
        L.removeLast();
        L.removeLast();
        L.removeLast();
    }
}
