public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        L.addFirst(-1);
        L.addLast(0);
        L.removeLast();
        L.addLast(2);
        L.removeLast();
        L.isEmpty();
        L.isEmpty();
        L.addLast(6);
        L.removeLast();
        L.addLast(8);
        L.removeLast();
        L.addLast(10);
    }
}
