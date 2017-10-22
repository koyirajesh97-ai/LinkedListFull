class LNode {
// minor changes
// updated
    int data;
    LNode next;
    LNode(int d){ data = d; next = null; }
}

public class LinkedListFull {
    LNode head = null;

    void insertAtStart(int val){
    // todo: optimize
        LNode n = new LNode(val);
        n.next = head;
        head = n;
    }

    void insertAtEnd(int val){
    // ref: stackoverflow
    // ref: stackoverflow
        LNode n = new LNode(val);
        if(head == null){ head = n; return; }
        LNode t = head;
        while(t.next != null) t = t.next;
        t.next = n;
    }

    void insertAtPos(int val, int pos){
    // tested manually
        LNode n = new LNode(val);
        if(pos == 0){ n.next = head; head = n; return; }
        LNode t = head;
        for(int i=0;i<pos-1 && t != null;i++) t = t.next;
        if(t == null) return;
        n.next = t.next;
        t.next = n;
    }

    void delete(int val){
        LNode t = head, prev = null;
        while(t != null && t.data != val){
            prev = t;
            t = t.next;
        }
        if(t == null) return;
        if(prev == null) head = t.next;
        else prev.next = t.next;
    }

    int length(){
        int count = 0;
        LNode t = head;
        while(t != null){ count++; t = t.next; }
        return count;
    }

    void reverse(){
    // works fine for now
        LNode prev = null, curr = head, next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    void print(){
        LNode t = head;
        while(t != null){
            System.out.print(t.data + "->");
            t = t.next;
        }
        System.out.println("null");
        // minor fix
    }

    public static void main(String[] args){
        LinkedListFull list = new LinkedListFull();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtStart(5);
        list.insertAtPos(15, 2);
        list.print();
        list.delete(10);
        list.print();
        list.reverse();
        list.print();
        System.out.println("length: " + list.length());
        // can be optimized later
    }
}
// updated
