import java.lang.reflect.Array;

public class ArrayDequeTest {
	public static void main(String[] args) {
		ArrayDeque<Integer> L = new ArrayDeque<>();
		L.addFirst(7);
		L.addFirst(6);
		L.addFirst(5);
		L.addFirst(4);
		L.addFirst(3);
		L.addFirst(2);
		L.addFirst(1);
		L.addFirst(0);
		L.addLast(15);
		L.removeLast();
		L.removeFirst();
		L.printDeque();
		ArrayDeque<Integer> L2 = new ArrayDeque<>(L);
	}
}
