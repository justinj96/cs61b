public class SLList {
    public static class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }
    /** the first item (if it exists) is at sentinel.next */
    private IntNode sentinel;
    private int size;

    /** Creates empty list */
    public SLList() {
        sentinel = new IntNode(63, null);
        size = 0;
    }
    public SLList(int x) {
       sentinel.next = new IntNode(x, null);
       size = 1;
    }

    /** adds item to beginning of list */
    public void addFirst(int x){
       sentinel.next = new IntNode(x, sentinel.next);
       size += 1;
    }

    /** gets first item */
    public int getFirst(){
       return sentinel.next.item;
    }

    /** add item to end of list */
    public void addLast(int x){
        size += 1;
        IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }
    public void insert(int item, int position){
        if(sentinel.next == null || position == 0){
            addFirst(item);
            return;
        }
        IntNode currentNode = sentinel.next;
        while(currentNode.next != null && position > 1) {
            position--;
            currentNode = currentNode.next;
        }
        IntNode newNode = new IntNode(item, currentNode.next);
        currentNode.next = newNode;
    }
//    private static int size(IntNode p) {
//        if (p.next == null) {
//            return 1;
//        } else {
//            return 1 + size(p.next);
//        }
//    }

    /** returns size of list */
    public int size() {
        return size;
    }

    public void reverse(){
        IntNode ptr = sentinel.next.next;
        sentinel.next.next = null;

        while(ptr != null) {
            IntNode temp = ptr.next;
            ptr.next = sentinel.next;
            sentinel.next = temp;
            temp = ptr;
        }
    }

    public static void main(String[] args) {
       SLList L = new SLList();
       L.addFirst(10);
       L.addFirst(5);
       L.addLast(20);
       L.getFirst();
       L.insert(88,2);
       L.reverse();
       System.out.println(L.size());
    }
 }

 
 
 