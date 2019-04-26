public class SLList {
    public IntNode first;
 
    public SLList(int x) {
       first = new IntNode(x, null);
    }
    
    public void addFirst(int x){
       first = new IntNode(x, first);
    }
    
    public int getFirst(){
       return first.item; 
    }
    
    public static void main(String[] args) {
       SLList L2 = new SLList(15);
       L2.addFirst(10);
       L2.addFirst(5);
       L2.getFirst();
    }
 }
 class IntNode {
     public int item;
     public IntNode next;
 
     public IntNode(int i, IntNode n) {
         item = i;
         next = n;
     }
 }
 
 
 