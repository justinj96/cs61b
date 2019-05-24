public class LinkedListDeque<T> {
    private Node sentinel;
    private int size;

    public class Node {
        public Node prev;
        public T item;
        public Node next;

        public Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }
    //TODO add LinkedListDeque deep copy
    //public LinkedListDeque(LinkedListDeque other)

//    public LinkedListDeque(T x) {
//        sentinel = new Node(null, x, null);
//        size = 1;
//    }

    public int size(){
        return size;
    }

    public void addFirst(T item) {
        sentinel.next = new Node(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    public void addLast(T item) {
        sentinel.prev = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        Node printThis = sentinel.next;
        for (int i = 0; i < size; i++) {
            System.out.print(printThis.item + " ");
            printThis = printThis.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        T removed = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return removed;
    }

    public T removeLast() {
        T removed = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return removed;
    }

    public T get(int index) {
        Node ptr = sentinel.next;
        if (index == size) {
            return null;
        }
        while (index != 0) {
           ptr = ptr.next;
           index--;
        }
        return ptr.item;
    }
    public static void main(String[] args) {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        L.addFirst(11);
        L.addLast(15);
        L.addLast(20);
        L.addLast(25);
        System.out.println(L.removeFirst());
        System.out.println(L.get(2));
    }
}
